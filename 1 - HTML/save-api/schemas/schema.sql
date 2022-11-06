create table IF NOT EXISTS usuario (
email varchar(80) primary key NOT NULL,
nome varchar(50) NOT NULL
);

create table IF NOT EXISTS filmeusuario (
emailUsuario varchar(100),
nomeFilme varchar (60) PRIMARY KEY,
anoFilme integer,
posterFilme varchar(300),
notaFilme integer,
CONSTRAINT fk_usuario FOREIGN KEY (emailUsuario) REFERENCES Usuario(email)
);

-- INSERT INTO usuario(email, nome) VALUES ("teste@gmail.com", "Joao Pedro");

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@gmail.com","asd  nnqes",2017, "image", 4);

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@gmail.com","afddfs",2017, "image", 4);

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@gmail.com","testtttts",2017, "image", 4);
