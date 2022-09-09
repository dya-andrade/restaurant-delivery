# Restaurant Delivery
CONCLUÍDO - Desafio para criar uma API RESTful de um delivery de restaurante.

# Desenvolvimento

* Java 8

* Spring Boot (Data, Validation, Security e Hateoas)

* DozerMapper para conversão de VO para Entity

* MySQL 8.0.23 e Flyway para banco de dados

* Postman para teste dos endpoints

* Swagger para documentação dos endpoints

* JWT com security para autenticação via token

# Swagger

![image](https://user-images.githubusercontent.com/101612046/188738349-09e86547-bca3-4a7c-ae0d-3de2fa634918.png)

# Login

* JSON para realizar login

```json
{
    "email":"admin.teste@gmail.com",
    "senha":"123456"
}
```

* JSON resposta

```json
{
    "email": "admin.teste@gmail.com",
    "autenticado": true,
    "criado": "2022-09-06T21:23:28.265+00:00",
    "expiracao": "2022-09-06T22:23:28.265+00:00",
    "accessToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbi50ZXN0ZUBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX0FETUlOIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImV4cCI6MTY2MjUwMzAwOCwiaWF0IjoxNjYyNDk5NDA4fQ.ju-xggR9CTfl5fiIQkdUEZMqdqRM-C-8udMhrEzGORI",
    "refreshToken": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbi50ZXN0ZUBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX0FETUlOIl0sImV4cCI6MTY2MjUxMDIwOCwiaWF0IjoxNjYyNDk5NDA4fQ.vhX3UJLmMMCVSkeLQS6EBl0KLXhZLwqEiP4QO5D7g-A"
}
```

![image](https://user-images.githubusercontent.com/101612046/188742841-c16a23cb-7cc3-4ad1-b218-c260393c0a6b.png)


# Usuário

* JSON para criar usuário

```json
{
    "email":"dyane.aaraujo@gmail.com",
    "senha":"123456",
    "perfilAcesso":{
        "descricao":"Administrador"
    }
}
```


* JSON resposta

```json
{
    "id": 3,
    "email": "dyane.aaraujo@gmail.com",
    "senha": "123456",
    "perfilAcesso": {
        "descricao": "Administrador"
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/restaurante-delivery/usuario/3"
        }
    }
}
```

![image](https://user-images.githubusercontent.com/101612046/188738620-7171795c-ebf9-4bc4-9cfc-287082e855c8.png)

# Cliente

* JSON para criar cliente

```json
{
    "nome": "Dyane Andrade",
    "telefone": "(11)92003-2417",
    "formaPagamento":"Débito",
    "endereco":{
        "logradouro":"Rua XXXX",
        "bairro":"XXXXXXX",
        "localidade":"Embu das Artes",
        "uf":"SP",
        "cep":"XXXXX-XXX"
    }
}
```

* JSON resposta

```json
{
    "id": 2,
    "nome": "Dyane Andrade",
    "telefone": "(11)92003-2417",
    "endereco": {
        "logradouro": "Rua XXXX",
        "bairro": "XXXXXXX",
        "localidade": "Embu das Artes",
        "uf": "SP",
        "cep": "XXXXX-XXX"
    },
    "formaPagamento": "Débito",
    "_links": {
        "self": {
            "href": "http://localhost:8080/restaurante-delivery/cliente/2"
        }
    }
}
```

![image](https://user-images.githubusercontent.com/101612046/188739120-ccd2fedd-5ef0-40d2-a502-bc9b0ecd21d1.png)

# Pedido

* JSON para criar pedido

```json
{
"itensPedido":[
        {
            "comidaBebida": "Picadinho",
            "quantidade": 3,
            "valorTotal": 50.00
        },
        {
            "comidaBebida": "Refrigerante",
            "quantidade": 1,
            "valorTotal": 5.00
        },
        {
            "comidaBebida": "Suco",
            "quantidade": 1,
            "valorTotal": 4.00
        }
    ],
"idCliente": 1,
"desconto":0.02
}
```

* JSON resposta

```json
{
    "id": 1,
    "cliente": {
        "id": 1,
        "nome": "Dyane Andrade",
        "telefone": "(11)92003-2417",
        "endereco": {
            "logradouro": "Rua XXXX",
            "bairro": "XXXXXXX",
            "localidade": "Embu das Artes",
            "uf": "SP",
            "cep": "XXXXX-XXX"
        },
        "formaPagamento": "Débito"
    },
    "itensPedido": [
        {
            "id": 1,
            "comidaBebida": "Picadinho",
            "quantidade": 3,
            "valorTotal": 75
        },
        {
            "id": 2,
            "comidaBebida": "Refrigerante",
            "quantidade": 1,
            "valorTotal": 5
        },
        {
            "id": 3,
            "comidaBebida": "Suco",
            "quantidade": 1,
            "valorTotal": 4
        }
    ],
    "data": "2022-09-06T17:53:36.6971438",
    "valorTotal": 83.98,
    "desconto": 0.02,
    "_links": {
        "self": {
            "href": "http://localhost:8080/restaurante-delivery/pedido/1"
        }
    }
}
```
![image](https://user-images.githubusercontent.com/101612046/188739576-ee8ac3a1-885b-4358-9461-ff158c1593b0.png)

# Entrega

* JSON para criar entrega

```json
{
    "motoboy":"Leandro",
    "valor":10.0,
    "idPedidos":[
        1
    ]
}
```

* JSON resposta

```json
{
    "id": 1,
    "data": "2022-09-06T18:19:00.1792196",
    "motoboy": "Leandro",
    "valor": 10.0,
    "pedidos": [
        {
            "id": 1,
            "cliente": {
                "id": 1,
                "nome": "Dyane Andrade",
                "telefone": "(11)92003-2417",
                "endereco": {
                    "logradouro": "Rua XXXX",
                    "bairro": "XXXXXXX",
                    "localidade": "Embu das Artes",
                    "uf": "SP",
                    "cep": "XXXXX-XXX"
                },
                "formaPagamento": "Débito"
            },
            "itensPedido": [
                {
                    "id": 4,
                    "comidaBebida": "Picadinho",
                    "quantidade": 3,
                    "valorTotal": 75.00
                },
                {
                    "id": 5,
                    "comidaBebida": "Refrigerante",
                    "quantidade": 1,
                    "valorTotal": 5.00
                },
                {
                    "id": 6,
                    "comidaBebida": "Suco",
                    "quantidade": 1,
                    "valorTotal": 4.00
                }
            ],
            "data": "2022-09-06T17:55:42.396686",
            "valorTotal": 83.50,
            "desconto": 0.50
        }
    ],
    "_links": {
        "self": {
            "href": "http://localhost:8080/restaurante-delivery/entrega/1"
        }
    }
}
```

![image](https://user-images.githubusercontent.com/101612046/188740630-32b3afb9-4ac7-4f8f-bc0b-c41bcc7dd369.png)
