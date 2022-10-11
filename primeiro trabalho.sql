SHOW databases;
#criando um banco de dados
CREATE database trabalho;
/*selecionar o banco a ser utulizado*/
USE trabalho;
#exibir as tabelas existentes no banco
SHOW tables;
#criar tabela no banco
CREATE table Veiculos (
	ID int not null auto_increment	primary key,
    Marca varchar(20),
    Modelo varchar(20),
    Cor varchar(10),
    AnoFabric date,
    Valor int);
#ver descritivo da tabela 
DESC Veiculos;
# 1 - ADD 5 VHECS PARA BASE DE DADOS values
INSERT into Veiculos (Marca, Modelo, Cor, AnoFabric, Valor) values('BMW' ,'M4', 'PRETO' , '2000-04-2', '200000');
INSERT into Veiculos (Marca, Modelo, Cor, AnoFabric, Valor) values('HONDA' ,'CIVIC', 'PRETO' , '2020-04-2','1000000');
INSERT into Veiculos (Marca, Modelo, Cor, AnoFabric, Valor) values('CHEFROLET' ,'CELTA', 'AZUL' , '1994-04-2','30000');
INSERT into Veiculos (Marca, Modelo, Cor, AnoFabric, Valor) values('CHEVY' ,'MAVERIK', 'LARANJA' , '1893-04-2', 20000);
INSERT into Veiculos (Marca, Modelo, Cor, AnoFabric, Valor) values('CARRINHO DE MAO' ,'ROLIMA', 'MADEIRA' , '2003-04-2','200000');
#MOSTRA TODA A TABELA
select * from Veiculos;

#2- CONSULTAR CUJO O CODIGO É 3;

select Marca, Modelo, Cor, AnoFabric, Valor from Veiculos where id = 3;

#3- CONSULTAR A MARCA DOS VEICULOS CADASTRADOS

select Marca from Veiculos;

#4- CONSULTAR O VALOR DOS CARROS CADASTRADOS

select Modelo, Valor from Veiculos;

#5- CONSULTAR QUAIS CARROS SAO DA MARCA GM/ 'bmw'

select ID, Modelo, Cor, AnoFabric, Valor from Veiculos where Marca = 'BMW';





    