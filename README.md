# API Banco

Projeto desenvolvido com Java 17, Spring Boot 3, Spring Data JPA, H2 Database, PostgreSQL e Swagger.

## Objetivo
Desenvolver uma API REST de sistema bancário como entrega do desafio de projeto.

## Tecnologias utilizadas
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- PostgreSQL
- Swagger / OpenAPI
- Maven
- GitHub
- Railway

## Funcionalidades
- Cadastro de clientes
- Listagem de clientes
- Busca de cliente por ID
- Criação de contas
- Listagem de contas
- Depósito em conta
- Saque em conta

## Estrutura do projeto
- controller
- domain
- repository
- service

## Endpoints principais
- GET /clientes
- GET /clientes/{id}
- POST /clientes
- GET /contas
- GET /contas/{id}
- POST /contas
- POST /contas/{id}/deposito
- POST /contas/{id}/saque

## Deploy
A aplicação será publicada no Railway.
