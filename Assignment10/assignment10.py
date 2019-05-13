from flask import Flask, render_template, request
import random

app = Flask(__name__)

@app.route('/assignment10.html')
def index():

    return render_template("assignment10.html")

@app.route('/hiThere', methods = ['GET'] )
def hiThere():
    randomNum = random.randint(1,6)
    firstname = request.args["firstname"]
    lastname = request.args["lastname"]
    return render_template("hiThere.html", firstname = firstname, lastname = lastname, randomNum = str(randomNum))

@app.route('/guessed', methods = ['POST','GET'])
def guessed():
    guess = request.form["guess"]
    answer = request.form["answer"]
    if guess == answer:
        return render_template("guessed.html")
    else:
        return render_template("guessing.html",guess = guess , randomNum = answer)
    #return render_template("testing.html")
if __name__ == "__main__":
    app.run(debug=True)