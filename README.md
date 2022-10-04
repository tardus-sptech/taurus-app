# TAURUS - PERSONAL FINANCE

Projeto desenvolvido para solucionar a necessidade de acompanhamento financeiro e gestão do seu dinheiro, utilizando das principais boas práticas do mercado, como conceito de microserviços, mensageria e padrões de projeto. No front, foi utilizado ReactJS. O projeto foi todo pensado com o conceito de Agile, desde a elicitação de requisitos a gestão do time que participou do projeto. Foi desenvolvido documentação do frontend e do backend, passando por todos os processos de arquitetura de software. Também foi feita uma pesquisa para desenvolvermos nossa proto-persona a fim de solucionar uma necessidade real.

## Tecnologias

* **Java 11**
* **Spring Boot**
* **Javascript ES6**
* **Node.js 14**
* **ES6 Modules**
* **Express.js**
* **API REST**
* **PostgreSQL (Container)**
* **RabbitMQ (Container e CloudAMQP)**
* **Docker**
* **docker-compose**
* **JWT**
* **Spring Cloud OpenFeign**
* **Axios**

## Arquitetura Proposta

Desenvolvemos a seguinte aquitetura:

![Arquitetura Proposta](https://i.imgur.com/GBcLtrZ_d.webp?maxwidth=760&fidelity=grand)

2 APIs:

* **Auth-API**: API de Autenticação com Node.js 14, Express.js, Sequelize, PostgreSQL, JWT e Bcrypt.
* **Finance-API**: API de Cadastro das informações necessárias de uma aplicação de personal-finance, como gastos e categoria. Construida com Java 11, Spring Boot, Spring Data JPA, PostgreSQL, validação de JWT, RabbitMQ e Spring Cloud OpenFeign para clients HTTP.

Toda a arquitetura rodando em containers docker via docker-compose.

## FLUXO DE EXECUÇÃO
O fluxo está descrito abaixo:

* 01 - O início do fluxo será fazendo uma requisição ao endpoint de criação de usuário.
* 02 - O payload (JSON) de entrada será o informando os dados necessários para o cadastro do usuário.
...
