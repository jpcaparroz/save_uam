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

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@123.com","Vingadores",2019, "https://www.showmetech.com.br/wp-content/uploads/2018/03/um-poster-de-filme-16102826189046.jpg", 4)

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@123.com","Projeto: Gemini",2011, "https://br.web.img3.acsta.net/pictures/19/04/23/16/26/2808586.jpg", 2)

-- INSERT INTO usuario(email, nome) VALUES ("root@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t2@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t1@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t3@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("t4@admin.com", "admin");

-- INSERT INTO usuario(email, nome) VALUES ("teste@123.com", "Joao - Teste");

-- INSERT INTO filmeusuario(emailUsuario, nomeFilme, anoFilme, posterFilme, notaFilme) 
-- VALUES ("teste@123.com","Capita Marvel",2017, "https://img.elo7.com.br/product/original/23646C7/big-poster-filme-capita-marvel-tamanho-90x60-cm-presente-geek.jpg", 3);