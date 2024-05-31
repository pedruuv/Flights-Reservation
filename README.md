# Flight Reservation API

Este projeto é uma API de reserva de voos construída usando Spring Boot e PostgreSQL. A API permite gerenciar voos (listar, criar, atualizar, deletar) e utiliza Spring Security para autenticação e autorização.

## Funcionalidades

- **Listar Voos**: A API permite buscar voos específicos fornecendo a cidade de origem, cidade de destino e data de embarque.
- **Criar Voo**: Adicionar um novo voo ao sistema.
- **Atualizar Voo**: Atualizar informações de um voo existente.
- **Deletar Voo**: Remover um voo do sistema.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação.
- **Spring Boot**: Framework para construção de aplicações Java.
- **Spring Data JPA**: Framework para simplificar o acesso a dados.
- **PostgreSQL**: Banco de dados relacional.
- **Spring Security**: Framework de segurança.
- **Gradle**: Ferramenta de automação de compilação e gerenciamento de dependências.

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Gradle](https://gradle.org/install/)
- [PostgreSQL](https://www.postgresql.org/download/)

## Configuração do Banco de Dados

1. Instale e configure o PostgreSQL.
2. Crie um banco de dados para a aplicação:

   ```sql
   CREATE DATABASE flight_reservation;
   ```

3. No arquivo `src/main/resources/application.properties`, configure as credenciais de acesso ao banco de dados:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/flight_reservation
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

## Segurança

A API utiliza Spring Security para autenticação e autorização. Apenas usuários autenticados podem acessar os endpoints de criação, atualização e deleção de voos.
