from flask import Flask, render_template 
app = Flask(__name__)                     



@app.route('/play')                           
def hello_world():
    
    return render_template("index1.html",)

@app.route('/play/<x>')
def print1(x):
    return render_template("index1.html",times=int(x))


@app.route('/play/<x>/<color>')
def print2(x,color):
    return render_template("index1.html",times=int(x),color=color)

if __name__=="__main__":
    app.run(debug=True)   