# Cadastro de Produtos

## Descrição

Esta é uma API desenvolvida em Java com Spring Boot para gerenciar produtos.
A aplicação permite criar e listar produtos, utilizando PostgreSQL como banco de dados.
A aplicação foi implantada em um servidor remoto.

## Funcionalidades

- Criar um novo produto 
- Listar todos os produtos retornando nome, valor
- Quando cadastrar um novo produto irá listar os produtos atualizados e ordenados pelo menor preço

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.1
- PostgreSQL 16
- Maven

## Como usar a api

1. Instale o Postman em sua máquina.
2. Crie duas requisições uma Post e outra Get
3. Utilize a URL para fazer as requisições: https://desafio-dev.onrender.com/produtos
4. Na requisição Post para criar o objeto, vá para aba Body e selecione JSON e insira um exemplo baseado nesse:
 {
    "nome":"Banana",
    "descricao":"Fruta",
    "preco": 3.00,
    "disponivel": true
}

5. Para listar, utilizar a requisições Get com a URL passada na opção 3.
   
