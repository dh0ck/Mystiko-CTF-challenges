from flask import Flask, request
from flask_restful import Resource, Api
import random
import time
import base64

app = Flask(__name__)
api = Api(app)

class Evolve(Resource):
    def get(self, index):
        flag = "3volut10n_n3ed5_r4nd0m_mu7at10ns"
        i=int(index)
        flag = self.evolve(flag,i)

        return {"pass": str(flag) }

    def evolve(self, flag, i):
        print("xxx: " +flag + str(len(flag)))
        L=len(flag)
        b = [0] * L
        S = []
        for character in flag:
            S.append(ord(character))

        print(S)

        for ik in range(1,i):
            for j in range(L):
                a = random.randint(1,26)
                b[j] += a
            S1 = [int(x/i)-13 for x in b]
        out = u''.join([chr(a+b) for a,b in zip(S,S1)])

        print(out)
        return ''.join([chr(a+b) for a,b in zip(S,S1)])


api.add_resource(Evolve, '/evolution/question=<index>')

if __name__ == '__main__':

    @app.errorhandler(500)
    def internal_error(error):
        return render_template('500.html'),500
    @app.errorhandler(404)
    def internal_error(error):
        return render_template('500.html'),500

    app.run(host="173.212.221.197",port=34006,debug=False) #its necessary to have debug=False to handle errors with custom page (decorators above)