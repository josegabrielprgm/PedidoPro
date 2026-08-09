# PedidoPro

Sistema de gerenciamento de pedidos desenvolvido com **Java e Spring Boot**, com foco em desenvolvimento de APIs REST, organização de código, regras de negócio, persistência de dados e boas práticas de desenvolvimento.

O projeto foi desenvolvido como uma aplicação completa, envolvendo gerenciamento de dados, relacionamentos entre entidades, validações, autenticação, segurança e testes automatizados.

## 🛠️ Tecnologias

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Bean Validation
* Spring Security
* JWT
* JUnit

## 🏗️ Arquitetura

O projeto utiliza uma arquitetura baseada em camadas, separando as responsabilidades da aplicação:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Também são utilizados **DTOs e Mappers** para controlar a comunicação entre as diferentes camadas da aplicação.

### Estrutura

```text
src/main/java/br/com/jose/pedido_pro/

├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── mapper/
└── exception/
```

## 🗄️ Banco de Dados

O sistema utiliza **MySQL** como banco de dados e **JPA/Hibernate** para persistência.

O modelo possui entidades relacionadas entre si, permitindo trabalhar com diferentes tipos de relacionamentos, regras de negócio e integridade dos dados.

## 🔐 Segurança

A aplicação utiliza **Spring Security** para controle de acesso e **JWT** para autenticação baseada em tokens.

O objetivo é garantir que os recursos da API sejam acessados de acordo com as permissões do usuário autenticado.

## 🧪 Testes

O projeto utiliza testes automatizados para verificar o comportamento da aplicação e garantir maior segurança durante a evolução do sistema.

## ⚙️ Como executar

### Pré-requisitos

* Java 21+
* Maven
* MySQL
* Git

### 1. Clone o projeto

```bash
git clone https://github.com/SEU_USUARIO/orderflow.git
cd orderflow
```

### 2. Crie o banco de dados

```sql
CREATE DATABASE PedidoPro;
```

### 3. Configure o banco

No arquivo:

```text
src/main/resources/application.properties
```

Configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/orderflow
spring.datasource.username=root
spring.datasource.password=SUA_SENHA
```

### 4. Execute a aplicação

```bash
mvn spring-boot:run
```

Ou execute a classe principal:

```text
OrderFlowApplication.java
```

A aplicação será iniciada, por padrão, em:

```text
http://localhost:8080
```

## 📚 Objetivo

O OrderFlow é um projeto de estudo e portfólio criado para aplicar, na prática, conceitos de **Java, Spring Boot, APIs REST, bancos de dados, JPA, segurança, autenticação, testes e arquitetura de software**.

## 🚧 Status

**Em desenvolvimento.**
