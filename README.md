# LeagueOfJava

### Esse repositorio contém um CRUD inspirado no jogo League of Legends, a aplicação contém uma tela de Login, Cadastro e a tela de CRUD. Foi utilizado o banco de dados MySql para persistência dos dados.

## Telas

<div>
<img src="https://user-images.githubusercontent.com/103899434/195191712-c43af102-42ce-47e9-b24d-92c14a45dcb9.png" height="250px">
<img src="https://user-images.githubusercontent.com/103899434/195191702-e1cd3a45-5f4b-4765-a2a9-ef5301bb94f8.png" height="250px">
<img src="https://user-images.githubusercontent.com/103899434/195191708-12757800-c691-4047-8025-be878e842957.png" height="250px">
<div>

## Primeiros passos

Antes de clonar o repositorio, vamos primeiro criar nosso banco de dados:

> Primeiro crie o DataBase utilizando o seguinte comando:
>> CREATE DATABASE leagueofjava_db;

> Com o DataBase criado você irá criar as tabelas do seu banco de dados com o seguinte comando:
>> CREATE TABLE classe (
	id integer auto_increment not null primary key,
    nome varchar(50)
); <br>
CREATE TABLE rota (
	id integer auto_increment not null primary key,
    nome varchar(50)
); <br>
CREATE TABLE campeao (
	id integer auto_increment not null primary key,
    vida integer,
    ataque integer,
    defesa integer,
    nome varchar(50),
    rotaId integer not null,
    classeId integer not null,
    FOREIGN KEY (classeId) REFERENCES classe(id),
    FOREIGN KEY (rotaId) REFERENCES rota(id)
); <br>
CREATE TABLE login (
	id integer auto_increment not null primary key,
    login varchar(50),
    nome varchar(50),
    cpf varchar(50),
    senha varchar(50)
); <br>

> Agora só falta popular nosso banco de dados com os seguintes comandos:
>> INSERT INTO rota (nome) 
VALUES ("Rota Superior"); <br>
INSERT INTO rota (nome) 
VALUES ("Selva"); <br>
INSERT INTO rota (nome) 
VALUES ("Rota do meio"); <br>
INSERT INTO rota (nome) 
VALUES ("Rota Inferior"); <br>
INSERT INTO rota (nome) 
VALUES ("Suporte"); <br>
INSERT INTO classe (nome) 
VALUES ("Tank"); <br>
INSERT INTO classe (nome) 
VALUES ("Off-Tank"); <br>
INSERT INTO classe (nome) 
VALUES ("Mago"); <br>
INSERT INTO classe (nome) 
VALUES ("Assassino"); <br>
INSERT INTO login (login, nome, cpf, senha) 
VALUES ("admin", "admin", "admin", "admin"); <br>

Terminamos a etapa do banco de dados, agora vamos abrir nosso projeto no Eclipse:

> Primeiro vamos importar nosso projeto clicando em "Import Projects".
<img src="https://user-images.githubusercontent.com/103899434/195200006-0f2417a3-6a74-4b9f-be56-d33b01ace9c7.png" height=500px>

> Selecionamos a opção "Projects from Git" e clicamos em "Next".
<img src="https://user-images.githubusercontent.com/103899434/195200004-67b29bf0-55e3-4120-b4d4-1d9967257b5e.png" height=500px>

> Agora selecionamos a opção "Clone URL" e clicamos em "Next".
<img src="https://user-images.githubusercontent.com/103899434/195199992-2839ba9f-e9a8-41df-8e22-17202543bfe7.png" height=500px>

> Colocamos o URL do repositorio no campo indicado e clicamos em "Next".
<img src="https://user-images.githubusercontent.com/103899434/195200013-f9aba259-786c-475e-9b24-fe0e1743d465.png" height=500px>

> Agora vamos dar "Next" três vezes seguidas e por fim "Finish", agora temos nosso projeto importado no Eclipse.
<img src="https://user-images.githubusercontent.com/103899434/195200007-21af84c9-1229-41fa-8537-a7eb1f7913d8.png" height=250px>
<img src="https://user-images.githubusercontent.com/103899434/195200010-75344b7a-d511-40c7-9e40-5381009cadda.png" height=250px>
<img src="https://user-images.githubusercontent.com/103899434/195200011-a4db3fea-be54-4038-85f4-0f1e80483587.png" height=250px>
<img src="https://user-images.githubusercontent.com/103899434/195199997-9d6a0b60-7d2e-49bf-baf7-5c8a4e7dc41a.png" height=250px>

Agora temos que importar o Connector/J para possibilitar a conexão da nossa aplicação com o banco de dados.

> Primeiro você deve entrar no site do MySql e baixar o Connector/J correspondente a sua versão do MySql (8.0.30 no meu caso) e escolhendo o sistema operacional como "Plataforma Independente".
![Connect](https://user-images.githubusercontent.com/103899434/195203355-30a6b8d6-deb6-437b-9d20-1bfab9dc7efa.png)

> Agora basta extrair o arquivo baixado e entrar no Eclipse para adicionar o connector ao projeto, conforme as figuras abaixo:
<img src="https://user-images.githubusercontent.com/103899434/195203990-5315819c-78a0-4573-aa25-ed18c7235699.png" width=400px>
<img src="https://user-images.githubusercontent.com/103899434/195203988-85b0646b-eea1-4e89-87e5-7bdd1fd8a98c.png" height=300px>

Para finaliza basta você acessar dentro do Eclipse o caminho "src -> factory -> ConnectionFactory" e colocar seu usuário/senha do MySql nos campos solicitados. <br>
![Factory](https://user-images.githubusercontent.com/103899434/195204691-43de62e8-165d-44f0-a4cd-66303d1bfd06.png)

## Agora podemos rodas nossa aplicação seguindo o caminho dentro do Eclipse "src -> teste -> testeExec" e rodando a aplicação java.
![Rodando](https://user-images.githubusercontent.com/103899434/195205336-6ab87013-8835-4bcb-b5b0-32a264b79e81.png)

## A login/senha padrão da aplicação é admin/admin, espero que gostem da aplicação!
