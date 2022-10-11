CREATE database vetcenter;
/*selecionar o banco a ser utulizado*/
USE vetcenter;
#exibir as tabelas existentes no banco
SHOW tables;
#criar tabela no banco
#auto_increment(banco cuida sobre, os id unicos.
#1,2 - crie a tabela Mascotes (id, nome , tipo (cão,gato,leao),sexo ,raca ,idade,data que foi encontrado, data que foi inserido na base de dados, estado de saude,(otimo/medio/razoavel/sendo tratado)
CREATE table Mascotes (
	ID int not null auto_increment	primary key, 
    Nome varchar(20),
    Tipo varchar(20) ,
    Sexo varchar(20),
    Raca varchar(20),
    Idade int,
    DataEncontrado date,
    DataInserido date,
    Saude varchar(20),
	DataFabic date);
#cadastre 10 bichos
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('meggie','gato','feminino','shi-shu','6' , '2022-04-02','2022-04-01','razoavel');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('carlos','cao','masculino','vira-lata','4' , '2022-02,01','2022-02-02','tratando');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('robsom','cao','masculino','juba vermelha','3' , '2022-06-03','2022-06-04','otimo');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('cardoso','gato','masculino','gato do mato','1' , '2022-08-06','2022-08-06','medio');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('jumberto','cao','feminino','vira-lata','3' , '2022-03-04','2022-03-05','razoavel');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('vit','gato','feminino','juba azul','2' , '2022-06-02','2022-06-01','tratando');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('joao','gato','masculino','vira-lata','6' , '2022-04-02','2022-04-01','razoavel');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('vitoria','cao','masculino','caramelo','10' , '2022-03-02','2022-03-01','razoavel');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('enzo','gato','feminino','vira-lata','6' , '2022-02-02','2022-02-01','medio');
INSERT into Mascotes (Nome, Tipo, Sexo, Raca, Idade,DataEncontrado ,  DataInserido , Saude ) values('cacau','gato','feminino','chow-chow','6' , '2022-04-02','2022-04-01','razoavel');
#qual o nome de todos os bichos cadastrados na base de dados ?
select Nome , tipo from Mascotes;
#qual mascotes possuem mais do que 5 anos de idade?
select nome , tipo , idade from Mascotes where Idade > 5;
#quais são as racas que necessitam cuidados?
select Raca from Mascotes where Saude = 'tratando';
#qual o sexo dos que estao otimos de saude? 
select Nome ,tipo , Sexo , Raca from Mascotes where Saude = 'otimo';
#tem gato que necessite de cuidados ?
select Tipo , Saude from Mascotes where Tipo = 'gato' and Saude = 'tratando';
#quais caes queestao razoaveis de saude 
select raca ,nome ,Tipo , Saude from Mascotes where Tipo = 'cao' and Saude = 'razoavel';
#quais os dias que foram encontrados os bichos de sexo feminino?
select tipo,  DataEncontrado from Mascotes where Sexo = 'feminino';
#quais os dias que foram cadastrados no sistema os bichos da raca "vira-lata'?
select tipo,Raca,DataInserido from Mascotes where Raca = 'vira-lata';
#qual tipo de mascote cujo nome é rex/joao
select tipo,Raca,DataInserido from Mascotes where nome = 'joao';
#qual raça e a idade da gata cacau
select nome , idade  from Mascotes where nome = 'cacau';

#3 alterações 
#3.1-Altere a raça de todos os cães para SRD (sem raça definida)
update Mascotes set raca = 'SDR';
select *from Mascotes;

#3.2-Altere para ótimo o estado de todos os gatos;
update Mascotes set Saude = 'otimo' where tipo = 'gato';
select * from Mascotes where tipo = 'gato';

#4-Eclusões
#4.1 Exclua do banco de daos todos os bichinhos de estimação menores de 2 anos.
delete From Mascotes where idade <2;
#4.2 Exclua do banco de dados todos os gatos do sexo masculino.
delete From Mascotes where tipo = 'gato' and sexo = 'masculino';
select *from Mascotes;




