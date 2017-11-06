from flask import Flask, render_template, url_for, redirect, request, flash
from httplib2 import Http
h = Http()
app = Flask(__name__)
user = 'abc'
@app.route("/")
@app.route("/index", methods = ['GET', 'POST'])
def index():
    if request.method == 'POST':
        # User validation and registration
        user = request.form['email'].split('@')[0]
        loginSuccessful = True
        if(loginSuccessful):
            return redirect(url_for('home', user=user))
    else:
        return render_template('index.html')

@app.route("/home", methods = ['GET', 'POST'])
def home():
    if request.method == 'POST':
        resp, content = h.request("http://localhost:9000/loginError", 'GET');
        return content
    else:
        print "HETER"
        return render_template("home.html", user=user)

if __name__ == "__main__":
    app.secret_key = 'super_secret_key'
    app.debug = True
    app.run(host='127.0.0.1', port=27015)
    print "listening on 27015"
