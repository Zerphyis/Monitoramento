# Sistema de Gestão de Estoque

Este é um projeto de demonstração de um **Sistema de Gestão de Estoque** desenvolvido utilizando **Spring Boot**, **Thymeleaf**, e **JPA**. O sistema é capaz de gerenciar produtos, fornecedores, movimentações de estoque e notificações. Ele permite registrar, listar, editar e excluir os registros no banco de dados.

## Funcionalidades

- **Cadastro de Produtos:** Gerencia o cadastro e exibição de produtos no estoque.
- **Movimentações de Estoque:** Registra as entradas e saídas de produtos.
- **Notificações de Estoque:** Envia notificações de reabastecimento e alertas de estoque.
- **Cadastro de Fornecedores:** Gerencia o cadastro de fornecedores dos produtos.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para construção de aplicações Java.
- **Thymeleaf**: Motor de template para renderização de páginas HTML.
- **JPA (Java Persistence API)**: Interface para mapeamento objeto-relacional.
- **MySQL**: Banco de dados relacional.

## Pré-requisitos

- **Java 17** ou superior
- **Maven** para gerenciamento de dependências
- **MySQL** ou outro banco de dados relacional configurado

## Como Executar o Projeto

### Passo 1: Clone o Repositório

```bash
git clone <URL-do-repositório>
cd monitoramento
Passo 2: Configure o Banco de Dados
Configure o banco de dados no arquivo application.properties, localizado em src/main/resources:
````
````
spring.datasource.url=jdbc:mysql://localhost:3306/URl_BANCO
spring.datasource.username=usarname do banco
spring.datasource.password=senha do banco
spring.jpa.hibernate.ddl-auto=update
Crie o banco de dados no MySQL (se ainda não estiver criado):

CREATE DATABASE crie um banco o coloque em URl_BANCO ;
````

````
Passo 3: Execute o Projeto
mvn spring-boot:run
A aplicação estará disponível em http://localhost:8080.
````

### Estrutura das Telas da Aplicação
### Tela Inicial - Sistema de Gestão de Estoque
####  Na tela inicial, o usuário pode acessar as principais funcionalidades do sistema, como cadastro de produtos, movimentações de estoque, fornecedores, etc.
<br>

![Image](https://github.com/user-attachments/assets/08786d10-f5e6-4b1a-8105-2bf870c73f17)
<br>
### Tela de Lista de Produtos
#### Nessa tela, o usuário pode visualizar todos os produtos cadastrados no estoque, além de poder editar, excluir ou adicionar novos produtos.
<br>

![Image](https://github.com/user-attachments/assets/9daf882a-4d1d-4bea-96ce-7d52af4eb53a)
<br>
### Tela de Cadastro de Produto
#### Aqui, o usuário pode adicionar ou editar informações sobre um produto, incluindo nome, preço, quantidade, categoria e fornecedor.
<br>

![Image](https://github.com/user-attachments/assets/3e5a6418-a765-4683-ac9d-7b00641083c1)
<br>
### Tela de Forncedores 
#### A tela de fornecedores exibe uma lista de todos os fornecedores cadastrados no sistema. O usuário pode adicionar, editar ou excluir fornecedores conforme necessário.
<br>

![Image](https://github.com/user-attachments/assets/6dca7a63-8d04-45dd-abee-446de2f34d56)
<br>
### Tela de Cadastro de Fornecedores
#### Nessa tela, o usuário pode registrar novos fornecedores ou editar fornecedores existentes.
<br>

![Image](https://github.com/user-attachments/assets/9283c041-9135-43eb-8da3-c3403dbf4571)
<br>

### Tela de Movimentações de Estoque
####  A tela de movimentações de estoque exibe todas as movimentações realizadas, como entradas e saídas de produtos.
<br>

![Image](https://github.com/user-attachments/assets/09902182-be64-4457-8459-37b84e8792cb)
<br>
### Tela de Cadastro de Movimentações de Estoque
#### Nesta tela, o usuário pode registrar novas movimentações de estoque, seja uma entrada (reabastecimento) ou uma saída (venda).
<br>

![Image](https://github.com/user-attachments/assets/235ee1da-53d3-443a-80f5-b6c8afd7a7f3)
<br>

### Tela de Notificações de Estoque
#### Aqui, o usuário pode visualizar as notificações de estoque, como alertas de baixo estoque e reabastecimento.
<br>

![Image](https://github.com/user-attachments/assets/e5544600-13c2-43d7-9c78-1e3813d6c073)
<br>

### Tela de Cadastro Notificações de Estoque
#### A tela de cadastro de notificações permite que o usuário registre notificações com base nas movimentações de estoque, como alertas para reabastecimento.
<br>

![Image](https://github.com/user-attachments/assets/e3563aba-3319-4861-8517-0e6d2df81b29)
<br>
