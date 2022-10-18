#uma empresa necessita criar um sistema para agendamento de reuniões/ compromissos entre os colaboladores em que estem podem reservar 
#algumas salas da empresa em determinado dia e horario para a realização de reuniões internas do grupo

#entidades- funcionario colabolador - id funcionario
#agendamento - id agendamento -ref de qual funcionario fez 
#nomes das tabelas: funcionario e agendamento
#funcionario ( id , nome, email, cargo)
#agendamento (id , fk_funcionario , local , dia , hora, tipo"festa,reuniao)

CREATE database Aula03;
SHOW databases;
/*selecionar o banco a ser utulizado*/
USE Aula03;
#exibir as tabelas existentes no banco
SHOW tables;
#criar tabela no banco
#auto_increment(banco cuida sobre, os id unicos.
#funcionario ( id , nome, email, cargo)
CREATE table Funcionario (
	ID int not null auto_increment	primary key, 
    Nome varchar(20),
    Email varchar(50) ,
    Cargo varchar(20));
    #agendamento (id , fk_funcionario , local , dia , hora, tipo"festa,reuniao)
    INSERT into Funcionario (Nome, Email, Cargo) values('Carlos' ,'carlos@gamil.com', 'senior' );
    INSERT into Funcionario (Nome, Email, Cargo) values('Bernardo' ,'bernardo@gamil.com', 'junior' );
    INSERT into Funcionario (Nome, Email, Cargo) values('Mauricio' ,'maumau@gamil.com', 'junior' );
    INSERT into Funcionario (Nome, Email, Cargo) values('Leonardo' ,'leo@gamil.com', 'estagiario');
    INSERT into Funcionario (Nome, Email, Cargo) values('Roger' ,'Roger@gamil.com', 'estagiario');
    
    select * from Funcionario;
    select nome, email from funcionario where id = 4;
    #alterar coluna 
    ALTER table Funcionario modify column Email varchar(60);
    
    CREATE table Agenda (
	ID int not null auto_increment	primary key, 
    ID_funcionario int,
    Local_ varchar(40),
    Data_dia date,
	Hora time,
    Tipo varchar(20));
    #inserindo chave estrangeira na tabela criada
    alter table Agenda
    add foreign key(ID_funcionario) references funcionario (ID);
    
    INSERT into Agenda (ID_funcionario, Local_, Data_dia, Hora, Tipo) values('4' ,'salao 203', '2022-10-22' , '09:30', 'reuniao');
    INSERT into Agenda (ID_funcionario, Local_, Data_dia, Hora, Tipo) values('2' ,'salao festa', '2022-10-23' , '10:30', 'festa');
    INSERT into Agenda (ID_funcionario, Local_, Data_dia, Hora, Tipo) values('1' ,'mesa redonda', '2022-10-22' , '15:30', 'reuniao');
    INSERT into Agenda (ID_funcionario, Local_, Data_dia, Hora, Tipo) values('4' ,'salao 203', '2022-10-21' , '17:30', 'festa');
    INSERT into Agenda (ID_funcionario, Local_, Data_dia, Hora, Tipo) values('3' ,'salao 203', '2022-10-21' , '20:30', 'debate');
    INSERT into Agenda (ID_funcionario, Local_, Data_dia, Hora, Tipo) values('3' ,'casa', '2022-10-18' , '20:30', 'playzada dos guri');
    select * from Agenda;
    #recuperar info de funcionarios que tem agendamento 
    select nome, cargo from Funcionario, Agenda where Funcionario.ID = Agenda.ID_funcionario;
    #recuperar nome cargo data hora e dia, das pessoas que tem agendamento 
    select nome, cargo, Data_dia, Hora, local_ from Funcionario, Agenda where Funcionario.ID = Agenda.ID_funcionario;
    
    #qyaus sai is fybcuibaruis qye reservaram a sala 203?
    select nome,local_ from Funcionario, agenda where funcionario.ID = agenda.ID_funcionario and agenda.local_ = 'salao 203';
    
    #quais saao os funcionarios que possuem alguma reserva em algum dia no horario de 16:00/17:30
    select funcionario.nome, agenda.data_dia from funcionario, agenda where funcionario.ID = agenda.ID_funcionario and agenda.Hora = '17:30';
    # quais sao as salas e o nome do funcionarios que possuem reserva na data 2022-10-21;
    select agenda.local_, funcionario.nome from funcionario,agenda where agenda.data_dia = '2022-10-21' and agenda.ID_funcionario = funcionario.ID 
    
    #exercicios
    #utilizar o banco de dados e as tabelas criadas para responder as seguintes perguntas:
    #1- qual o nome e email dos funcionarios que reservaram a sala 203:
	#2- qual o cargo dos funcionarios que possuem reserva para reuniao
    #3- qual nome e cargo dos funcionarios que possuem reserva em algum dia apos as 16:00
    #4- quais sao os funcionarios que possuem reservar da sala 206 apos as 18h?
    #5- quais funcionarios reservaram salas antes das 18h por motivo de comemoração/festa?
    #6- tem algum dirtero que reservou a sala para comemoração
    #7- quais sao os funcionario que possuem reserva para festa asntes das 23h
    
    
    
    
    
    

