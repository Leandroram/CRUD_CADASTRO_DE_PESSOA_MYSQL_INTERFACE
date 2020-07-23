# CRUD_CADASTRO_DE_PESSOA_MYSQL_INTERFACE
Sistema de cadastro Simples com interface gráfica, onde contempla: Cadastrar, Editar, Excluír e Listar.


![1](https://user-images.githubusercontent.com/68626959/88314982-15e68b00-ccec-11ea-99f4-4ccc00916919.jpg)
![2](https://user-images.githubusercontent.com/68626959/88314991-1a12a880-ccec-11ea-8209-9b7bd5309dc6.JPG)
![3](https://user-images.githubusercontent.com/68626959/88314995-1c750280-ccec-11ea-9a0a-c87004a67fdb.JPG)
![4](https://user-images.githubusercontent.com/68626959/88315005-1ed75c80-ccec-11ea-90ae-48832283630e.JPG)


É necessario inserir a biblioteca: mysql-connector-java-5.0.8-bin-g, para a parte de banco funcionar.

Codigo MYSQL:

CREATE TABLE clientes ( 
id int(11) NOT NULL AUTO_INCREMENT, 
nome varchar(100) NOT NULL, 
email varchar(100) NOT NULL, 
sexo varchar(10) NOT NULL, 
telefone varchar(30) NOT NULL, 
PRIMARY KEY(id) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO clientes (id, nome, email, sexo, telefone) VALUES 
(1, 'Teste', 'email', 'Masculino', 'telefone'), 
(2, 'pedro', 'pedro@pedro.com', 'Masculino', '123654789'), 
(3, 'nome', 'email', 'sexo', 'telefone'), 
(4, 'nome', 'email', 'Masculino', 'telefone'), 
(5, 'nome', 'email', 'Feminino', 'telefone');
