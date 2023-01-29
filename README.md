[![Java CI with Maven](https://github.com/fuhr-br/cadastro/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/fuhr-br/cadastro/actions/workflows/maven.yml)
# CRUD simples de uma pessoa com endereço
### Swagger local configurado para
http://localhost:8080/swagger-ui/index.html


### H2 configurações
Para acessar o banco em memória via URL acesse: http://localhost:8080/h2 <br>
Setar o campo JDBC URL para:  **jdbc:h2:mem:cadastro**

### Descrição dos endpoints:
PUT /cadastro/pessoa : Altera dados somente da pessoa, sem endereço <br>
POST /cadastro/pessoa : Cadastra uma pessoa com endereço <br>
PUT /cadastro/pessoa/{idPessoa}/endereco/{idEndereco}: Seta ou troca o endereço principal <br>
POST /cadastro/pessoa/{id}/endereco} : Adiciona um endereço a uma pessoa <br>
GET /cadastro/pessoa/{id} : Busca uma pessoa pelo ID <br>
