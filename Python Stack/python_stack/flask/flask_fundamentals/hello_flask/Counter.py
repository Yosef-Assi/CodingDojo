from flask import Flask, render_template, request,session,redirect
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'
@app.route("/counter")
def index():
    if 'count' in session:
        session['count']=session.get('count')+1
    else:
        session['count']=1
    return render_template("Counter.html",count2=session['count'])



@app.route("/")
def index2():
    if 'count2' in session:
        session['count2']=session.get('count2')+1
    else:
        session['count2']=1

    return render_template("Counter.html",count2=session['count2'])
@app.route("/destroy_session")
def destroy_session():
    session.pop('count',None)
    return redirect('/counter')
@app.route('/increment2')
def increment2():
    session['count']+=1
    return redirect('/counter')
@app.route('/reset')
def reset():
    session['count']=0
    return redirect('/counter')

    # session["name"]=request.form["name"]
    # session["select1"]=request.form.get('select8')
    # session["select2"]=request.form.get('select2')
    # session["textarea"]=request.form["textarea"]


if __name__ == "__main__":
    app.run(debug=True)