SELECT filme.nome, usuario.nome, usuariofilme.nota
FROM usuariofilme
INNER JOIN usuario
ON usuariofilme.emailUsuario = usuario.email
INNER JOIN filme
ON usuariofilme.idFilme = filme.id;
    