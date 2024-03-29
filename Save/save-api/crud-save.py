import json
import sqlite3

from flask import Flask, request, render_template
from flask import g
from flask import jsonify, make_response

dataServer = './save-bd.db'

app = Flask(__name__)
app.config["TEMPLATES_AUTO_RELOAD"] = True

def carregaBanco():
    banco = getattr(g, '_database', None)

    if banco is None:
        g._database = sqlite3.connect(dataServer)
        banco = g._database

        return banco

def criarTabela():
    banco = carregaBanco()
    scriptTabela = open ('schemas\schema.sql').read()
    banco.executescript(scriptTabela)

@app.route('/criartabelas')
def index():
    banco = carregaBanco
    criarTabela()
    return "<h1>Tabelas Criadas :)</h1>"

@app.route('/addUser', methods = ['POST',])
def addUsuario():
    banco = carregaBanco()
    cur = banco.cursor()

    email = request.form["email"]
    nome = request.form["nome"]
    
    cur.execute("""
    INSERT INTO Usuario (email, nome)
    VALUES (?,?)""",
    (email, nome))
    
    banco.commit()
    banco.close()

    return "Nome: %s, Email: %s" % (email, nome)

@app.route('/usuarios', methods = ['GET',])
def usuarios():
    banco = carregaBanco()
    cur = banco.cursor()

    result = cur.execute("""
    SELECT * FROM usuario 
    """,
    ).fetchall()
    
    banco.commit()
    banco.close()

    return render_template ("usuarios.html", result = result)

@app.route('/filmesUsuario', methods = ['GET',])
def filmesUsuario():
    banco = carregaBanco()
    cur = banco.cursor()

    result = cur.execute("""
    SELECT * FROM filmeusuario 
    """,
    ).fetchall()
    
    banco.commit()
    banco.close()

    return render_template ("test.html", result = result)

########################################################################################################
##############                            API                                             ##############
########################################################################################################

#API que retorna usuarios do banco 
@app.route('/api/usuario', methods = ['GET',])
def apiUsuario():
    banco = carregaBanco()
    cur = banco.cursor()

    result = cur.execute("""
    SELECT * FROM usuario 
    """,
    ).fetchall()
    
    columns = [desc[0] for desc in cur.description]
    results = []

    for row in result:
        row = dict(zip(columns, row))
        results.append(row)
    
    banco.commit()
    banco.close()

    return jsonify (results)

#API que retorna filmes que o usuario já assistiu
@app.route('/api/filmeusuario', methods = ['GET',])
def apiFilmeUsuario():
    banco = carregaBanco()
    cur = banco.cursor()

    result = cur.execute("""
    SELECT * FROM filmeusuario  
    """,
    ).fetchall()

    columns = [desc[0] for desc in cur.description]
    results = []

    for row in result:
        row = dict(zip(columns, row))
        results.append(row)
    
    banco.commit()
    banco.close()

    return jsonify (results)

@app.route('/api/top250', methods = ['GET',])
def apiTop250():

    with open('250.json', 'r') as data:
        top250 = json.load(data)

    colums = ['title', 'year', 'image']
    results = []

    i = 0
    limit = 100

    for film in top250['items']:

        title = film['title']
        year = film['year']
        image = film['image']

        film = [title, year, image]

        film = dict(zip(colums,film))
        results.append(film)
        i+= 1

        if i == limit:
            break

    return jsonify(results)
