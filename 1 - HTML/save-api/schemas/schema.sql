create table IF NOT EXISTS usuario (
email varchar(80) primary key NOT NULL,
nome varchar(50) NOT NULL
);

create table IF NOT EXISTS filmeusuario (
id integer PRIMARY KEY AUTOINCREMENT,
emailUsuario varchar(100),
nomeFilme varchar (60),
anoFilme integer,
posterFilme varchar(300),
notaFilme integer,
CONSTRAINT fk_usuario FOREIGN KEY (emailUsuario) REFERENCES Usuario(email)
);

-- INSERT INTO usuario(email, nome) VALUES ("root@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t2@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t1@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t3@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t4@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("teste@123.com", "Joao - Teste");

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@123.com","Capita Marvel",2017, "https://img.elo7.com.br/product/original/23646C7/big-poster-filme-capita-marvel-tamanho-90x60-cm-presente-geek.jpg", 3);

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("t4@admin.com","Shrek",2007, "https://cdn-cosmos.bluesoft.com.br/products/4035519332737", 5);

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@gmail.com","afddfs",2017, "image", 4);

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@gmail.com","testtttts",2017, "image", 4);
