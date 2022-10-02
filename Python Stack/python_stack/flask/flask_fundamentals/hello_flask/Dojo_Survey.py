from flask import Flask, render_template, request,session,redirect
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'
@app.route("/")
def index():
    return render_template("Dojo_Survey.html")
@app.route('/result', methods=['POST','GET'])
def create_user():
       
    # session["name"]=request.form["name"]
    # session["select1"]=request.form.get('select8')
    # session["select2"]=request.form.get('select2')
    # session["textarea"]=request.form["textarea"]
    if request.method == 'POST':
        return render_template("DojoSurvey2.html",name=request.form["name"],select1=request.form.get('select8'),select2=request.form.get('select2'),textarea=request.form['textarea'],fav=request.form.get('fav_language'),car=request.form.get('vehicle'))
    elif request.method == 'GET':
        return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)