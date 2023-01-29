[![Java CI with Maven](https://github.com/fuhr-br/cadastro/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/fuhr-br/cadastro/actions/workflows/maven.yml)
## Deploy 
````
https://cadastro-pessoa.herokuapp.com/swagger-ui/index.html
````

## Avaliação Desenvolvedor Back-end Attornatus

<br>

O objetivo deste documento é identificar seus conhecimentos quanto às tecnologias utilizadas no cotidiano de
desenvolvimento da equipe de Back-end na Attornatus Procuradoria Digital.

<br>

Esta análise propõe avaliar os seguintes temas:

* Qualidade de código
* Java, Spring boot
* API REST
* Testes

<br>

A entrega deverá ser feita da seguinte forma:

* O prazo para entrega da avaliação será de até 7 dias após envio da mesma
* Encaminhar este documento com as perguntas respondidas e com o link do código público em sua conta do GitHub
* Opcionalmente, caso você consiga fazer o build da aplicação, poderá também informar o link de acesso

<br>

Qualidade de código

1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

   <b>
   Primeiramente atender ao usuário final de forma satisfatória a ele e que seja seguro.
   Construir um software escalável e que tenha boas práticas de programação para facilitar manutenção e inserção de novas funcionalidades, que seja facilmente escalável.
   Ter uma pirâmide de testes, fazer uso de integração contínua e metodologia ágil.
   Escolher o uso correto das tecnologias conforme a necessidade do projeto.
   </b>

2. Em qual etapa da implementação você considera a qualidade de software?

   <b>
   A qualidade do software vai do inicio ao fim do projeto, não há uma parte que não deva se preocupar com qualidade.
   </b>

---

## Desafio Java

<br>

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:

* Criar uma pessoa
* Editar uma pessoa
* Consultar uma pessoa
* Listar pessoas
* Criar endereço para pessoa
* Listar endereços da pessoa
* Poder informar qual endereço é o principal da pessoa

Uma Pessoa deve ter os seguintes campos:

* Nome
* Data de nascimento
* Endereço:
    * Logradouro
    * CEP
    * Número
    * Cidade

Requisitos

* Todas as respostas da API devem ser JSON
* Banco de dados H2

Diferencial

* Testes
* Clean Code

Será levado em avaliação

* Estrutura, arquitetura e organização do projeto
* Boas práticas de programação
* Alcance dos objetivos propostos.

## Extras
### Swagger local configurado para
http://localhost:8080/swagger-ui/index.html


### H2 configurações
Para acessar o banco em memória via URL acesse: http://localhost:8080/h2 <br>
Setar o campo JDBC URL para:  **jdbc:h2:mem:cadastro**

### Descrição dos endpoints:
| Metodo | Endpoint | Documentação |
| :-: | :-: | :-: |
| PUT | /cadastro/pessoa  Altera dados somente da pessoa, sem endereço |
| POST | /cadastro/pessoa | Cadastra uma pessoa com endereço |
| PUT | /cadastro/pessoa/{idPessoa}/endereco/{idEndereco} | Seta ou troca o endereço principal |
| POST | /cadastro/pessoa/{id}/endereco} | Adiciona um endereço a uma pessoa |
| GET | /cadastro/pessoa/{id} | Busca uma pessoa pelo ID |
| GET | /cadastro/pessoa | Busca todas as pessoas com seus endereços listados |

#### Testes

Testes unitários e de Integração, com testes de controller usando MockMvc 
com banco em memória.

<br>
Foi feito também integração continua com o GitHub e Heroku.