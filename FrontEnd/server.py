from flask import Flask, render_template, url_for, redirect, request, flash, session
from flask_login import LoginManager, login_user, login_required, logout_user, current_user
from httplib2 import Http
import os
import json
h = Http()
app = Flask(__name__)
user = 'abc'
@app.route("/")
@app.route("/index", methods = ['GET', 'POST'])
def index():
    if request.method == 'POST':

        session.pop('user', None)
        # User validation and registration
        user = request.form['email'].split('@')[0]
        if request.form['password'] == "password":
            session['user'] = user
            # loginSuccessful = True
        # if(loginSuccessful):
            return redirect(url_for('home', user=user))
    else:
        # session.pop('user',None)
        if session.get('user') != None:
            return redirect(url_for('home', user=session.get('user')))
        return render_template('index.html')

@app.route("/home", methods = ['GET', 'POST'])
# @login_required
def home():
    if request.method == 'POST':
        resp, content = h.request("http://localhost:9000/loginError", 'GET');
        return content
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
