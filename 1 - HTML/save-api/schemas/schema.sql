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

INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
VALUES ("teste@dqwgmadfsil.com","Vingadorew  nnqes",2017, "image", 4);

INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
VALUES ("testvccce@dqwg352mail.com","Vingadorasdewnbbbbqes",2017, "image", 4);

INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
VALUES ("testvvve@dqwgmai43l.com","Vingadorexcvxccbcxwqes",2017, "image", 4);

INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
VALUES ("testzxbvcbe@dqwgma546il.com","Vingadorvfdxcvvwqes",2017, "image", 4);

INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
VALUES ("testzxce@dqwgma123il.com","Vingadorewcxbxgffqes",2017, "image", 4);

INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
VALUES ("teste@dcvbq234wgmail.com","Vingadorewbxcqzxcaes",2017, "image", 4);

INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
VALUES ("teste@dqwggfdm324ail.com","Vingadorewqevbcncvrwees",2017, "image", 4);