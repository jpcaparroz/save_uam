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

@app.route('/')
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

@app.route('/apiusuario', methods = ['GET',])
def apiUsuario():
    banco = carregaBanco()
    cur = banco.cursor()

    result = cur.execute("""
    SELECT * FROM usuario 
    """,
    ).fetchall()
    
    banco.commit()
    banco.close()

    return make_response (jsonify (email = result.index(1), nome = result.index(2)))

@app.route('/apifilmesusuario', methods = ['GET',])
def apiFilmesUsuario():
    banco = carregaBanco()
    cur = banco.cursor()

    result = cur.execute("""
    SELECT * FROM filmeusuario  
    """,
    ).fetchall()
    
    banco.commit()
    banco.close()

    return jsonify (login = result.login, nome = result.nome)
