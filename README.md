## :hotel: Desafio Hotel (backend) :hotel:

### Implementação:

​		API REST desenvolvida em Java pela IDE IntelliJ, utilizando banco de dados PostgreSQL.

​		Utilizados os frameworks Spring Boot com Maven.

​		

### Instalação:

​		Atenção: Alterar a senha do usuário **postgress** no arquivo **application.properties**, localizado na pasta **resources**. 

Exemplo:  **spring.datasource.password=123**



### Métodos:

#### Hóspede:

- **api/hospede/incluiHospede:**Inclui hóspedes no banco de dados.

  - **Parâmetro:** JSON com a seguinte estrutura:

    {

    "nome":"Fulano da Silva",

    "documento":"123456",

    "telefone":"9925-2211"

    }

  - **Exemplo de chamada:**localhost:8080/api/hospede/incluiHospede

- **api/hospede/excluiHospede:** Exclui hóspede pelo seu id.

  - **Parâmetro:** id: Integer.
  - **Exemplo de chamada:**localhost:8080/api/hospede/excluiHospede?id=4

- **api/hospede/alteraHospede:** Lista hóspede pelo id.

  - **Parâmetro:** id: Integer.
  - **Exemplo de chamada:**localhost:8080/api/hospede/listaHospedeId?id=4

- **api/hospede/listaHospede:** Lista todos os hóspedes.

  - **Parâmetro:** Sem parâmetros.
  - **Exemplo de chamada:**localhost:8080/api/hospede/listaHospede

- **api/hospede/listaHospedeId:** Lista hóspede pelo seu id.

  - **Parâmetro:** id: Integer.
  - **Exemplo de chamada:**localhost:8080/api/hospede/listaHospedeId?id=4

#### Checkin:

- **api/checkin/incluiCheckin:** Inclui checkin no banco de dados.

  - **Parametro:** JSON com a seguinte estrutura: 

    {

    "hospede": {},

    "dataEntrada": "2021-07-18T08:00:00",

    "dataSaida":"2021-07-19T11:00:00",

    "adicionalVeiculo": false/true

    }

  - **Exemplo de chamada:** localhost:8080/api/checkin/incluirCheckin

- **api/checkin/consultaHospede:**Consulta no banco os checkins realizados pelos hóspedes.

  - **Parametros:**

    **nome** (Adicionar o símbolo "+" nos espaços em branco, exemplo: "Ana Paula = "Ana+Paula).

    **documento**(Sem caracteres separadores como '.', '-', '/').

    **telefone**(Poderá haver caracteres separadores, desde que siga o padrão no momento do cadastro).

  - **Exemplos de chamada:**

    localhost:8080/api/checkin/consultaHospede?nome=Fulano+da+Silva

    localhost:8080/api/checkin/consultaHospede?documento=123456

    localhost:8080/api/checkin/consultaHospede?telefone=9925-2211



### Problemas do projeto a serem corrigidos:



### To do:





