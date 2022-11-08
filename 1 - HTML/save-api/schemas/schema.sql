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
-- VALUES ("teste@123.com","Capitã Marvel",2017, "https://img.elo7.com.br/product/original/23646C7/big-poster-filme-capita-marvel-tamanho-90x60-cm-presente-geek.jpg", 3);

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@gmail.com","afddfs",2017, "image", 4);

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@gmail.com","testtttts",2017, "image", 4);
