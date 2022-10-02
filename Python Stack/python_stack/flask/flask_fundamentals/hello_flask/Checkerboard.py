from flask import Flask, render_template 
app = Flask(__name__)                     



@app.route('/play')                           
def hello_world():
    
    return render_template("Checkerboard.html",)

@app.route('/play/<x>')
def print1(x):
    return render_template("Checkerboard.html",times=int(x))


@app.route('/<x>/<y>')
def print2(x,y):
    return render_template("Checkerboard.html",value1=int(x),value2=int(y))
@app.route('/<x>/<y>/<c1>/<c2>')
def print21(x,y,c1,c2):
    return render_template("Checkerboard.html",value1=int(x),value2=int(y),color1=c1,color2=c2)
if __name__=="__main__":
    app.run(debug=True)   