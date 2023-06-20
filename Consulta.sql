create table usuario(
id int(11) not null auto_increment,
nome varchar(50) default '',
cpf varchar(20) default '',
email varchar(50) default '',
telefone varchar(50) default '',
primary key (id)
)engine=innodb;

INSERT INTO usuario(nome, cpf, email, telefone)
VALUES ('António', '876.211.234-56', 'antonio2@gmail.com', '(71)987654212')