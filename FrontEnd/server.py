from flask import Flask, render_template, url_for, redirect, request, flash, session
from flask_login import LoginManager, login_user, login_required, logout_user, current_user
# from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import create_engine, asc, desc
from sqlalchemy.orm import sessionmaker
from database_setup import User, Base
from urllib import urlencode

from httplib2 import Http
import os
import json
h = Http()
app = Flask(__name__)
# Connect to Database and create database session
engine = create_engine('sqlite:///vsmUser.db')
Base.metadata.bind = engine

DBSession = sessionmaker(bind=engine)
dbSession = DBSession()

@app.route("/")
@app.route("/index", methods = ['GET', 'POST'])
def index():
    if request.method == 'POST':

        # session.pop('user', None)
        # User validation and registration
        if request.form['submit'] == 'login':
            # Login Action
            user = request.form['email'].split('@')[0]
            print user
            dbUser = dbSession.query(User).filter_by(username=user).one()
            if request.form['password'] == dbUser.password:
                session['user'] = user
                return redirect(url_for('home'))
        elif request.form['submit'] == 'register':
            # Register action
            # add user to DB
            user = request.form['email'].split('@')[0]
            email = request.form['email']
            password = request.form['password']
            firstName = request.form['firstName']
            lastName = request.form['lastName']
            fullName = firstName + " " + lastName
            newUser = User(username=user, fullName=fullName, email=email, password=password)
            dbSession.add(newUser)
            dbSession.commit()
            #Start Session
            session['user'] = user
            return redirect(url_for('home'))
    else:
        session.pop('user',None)
        # if session.get('user') != None:
        #     return redirect(url_for('home', user=session.get('user')))
        return render_template('index.html')

@app.route("/home", methods = ['GET', 'POST'])
# @login_required
def home():
    if request.method == 'POST':
        data = dict(user=session.get('user'),
                    stockName=request.form['stockName'],
                    stockPrice = request.form['stockPrice'],
                    stockQuantity = request.form['stockQuantity'],
                    action = request.form['submit'])
        resp, content = h.request("http://localhost:27016/Broker", "POST", urlencode(data));

        return redirect(url_for('home'))
    else:
        user = session.get('user')
        if user != None:
            resp, content = h.request("http://localhost:8091/Bank?id=1", 'GET');
            clientJson = json.loads(content)
            balance = clientJson['Balance']
            return render_template("home.html", user=user, balance=balance)
        else:
            return redirect(url_for('index'));

@app.route("/logout", methods = ['POST'])
def logout():
    if request.method == 'POST':
        session.pop('user', None)
        return redirect(url_for('index'))

if __name__ == "__main__":
    app.secret_key = 'super_secret_key'
    app.debug = True
    app.run(host='127.0.0.1', port=27015)
    print "listening on 27015"
