
## Lojinha API Automação

Este é um repositório que contém a automação de alguns testes de API Rest de um software denominado lojinha. Os subtópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java

(https://www.oracle.com/java/technologies/java-se-development-kit11-downloads.html)

- JUnit

(https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0-M1)

- RestAssured

(https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.4.0)

- Maven

(https://maven.apache.org/)

## Testes Automatizados

Testes para validar as partições de equivalência relacionadas ao valor do produto na lojinha, que estão vinculados diretamente a regra de negócio.

## Notas Gerais

- Sempre utilizamos a anotação Before Each para capturar o token que será utilizado posteriormente no métodos de testes.

- Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes.

- Armazenamos os dados que serão enviados para a API através do uso de classes Pojo.

- Criamos dados iniciais através do uso de classes Data Factory, para facilitar a criação e controle dos mesmos.