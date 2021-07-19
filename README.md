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

    `{`

    `"nome":"<string>",`

    `"documento":"<string>",`

    `"telefone":"<string>"`

    `}`

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

     {`

    ​        `"checkin": {`

    ​            `"dataEntrada": "<data hora>",`

    ​            `"dataSaida": "<data hora>",`

    ​            `"adicionalVeiculo":<boolean>,`

    ​            `"hospede": {`

    ​                `"id": <int>,`

    ​                `"nome": "<string>",`

    ​                `"documento": "<string>",`

    ​                `"telefone": "<string>"`

    ​            `}`

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

  - **Retorno:**

    `[    {`

    ​        `"checkin": {`

    ​            `"idCheckin": <int>,`

    ​            `"dataEntrada": "<data hora>",`

    ​            `"dataSaida": "<data hora>",`

    ​            `"adicionalVeiculo":<boolean>,`

    ​            `"hospede": {`

    ​                `"id": <int>,`

    ​                `"nome": "<string>",`

    ​                `"documento": "<string>",`

    ​                `"telefone": "<string>"`

    ​            `}`

    ​        `},`

    ​        `"totalDiariasSemana": <long>,`

    ​        `"totalDiariasFinalSemana": <long>,`

    ​        `"valorTotal": <float>`

    ​    `}`

    `]`

- **api/checkin/consultaHospedados:**Consulta no banco os checkins em aberto.

  - **Parametros:** não possui.

  - **Exemplo de chamada:**

    localhost:8080/api/checkin/consultaHospedados

  - **Retorno:**

    `[    {`

    ​        `"checkin": {`

    ​            `"idCheckin": "<int>",`

    ​            `"dataEntrada": "<data hora>",`

    ​            `"dataSaida": "",`

    ​            `"adicionalVeiculo":<boolean>,`

    ​            `"hospede": {`

    ​                `"id": <int>,`

    ​                `"nome": "<string>",`

    ​                `"documento": "<string>",`

    ​                `"telefone": "<string>"`

    ​            `}`

    ​        `},`

    ​        `"totalDiariasSemana": 0`

    ​        `"totalDiariasFinalSemana": 0,`

    ​        `"valorTotal": 0.0`

    ​    `}`

    ###### `]`

- **api/checkin/consultaCheckouts:** Consulta no banco os checkins já finalizados.

  - **Parametros:** não possui.

    **Exemplos de chamada:**

    localhost:8080/api/checkin/consultaCheckouts

    **Retorno:**

  - `[    {`

    ​        `"checkin": {`

    ​            `"idCheckin": <int>,`

    ​            `"dataEntrada": "<data hora>",`

    ​            `"dataSaida": "<data hora>",`

    ​            `"adicionalVeiculo":<boolean>,`

    ​            `"hospede": {`

    ​                `"id": <id>,`

    ​                `"nome": "<string>",`

    ​                `"documento": "<string>",`

    ​                `"telefone": "<string>"`

    ​            `}`

    ​        `},`

    ​        `"totalDiariasSemana": <long>,`

    ​        `"totalDiariasFinalSemana": <long>,`

    ​        `"valorTotal": <float>`

    ​    `}`

    `]`



### Problemas do projeto a serem corrigidos:



### To do:





