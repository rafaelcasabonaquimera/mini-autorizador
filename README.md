# <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="vscode" width="45" height="45"/>   mini-autorizador

[![All Contributors](https://img.shields.io/badge/all_contributors-0-orange.svg?style=flat-square)](#contributors-)

## Description
api responsavel em processar transações de Vale Refeição e Vale Alimentação

## Requirements

- Java 17
- Spring boot 3.3.1

## Arquitetura

- Arquitetura hexagonal: A principais vantagens da arquitectura hexagonal são: Independência: dividir o software em diferentes camadas permite 
mantê-los isolados e independentes. Isso facilita as alterações e atualizações. Flexibilidade: embora o núcleo do programa seja estático, os outros componentes não são absolutamente indispensáveis.
- Spring Webflux: Permite que todo o fluxo das rotas trabalhem de forma não bloquante, de forma que a api nunca será um gargalho então a aplicação limitasse apenas a sua infra.

### Build
```
mvn clean install
```

### Request for POST - /cartoes
```
curl --location 'localhost:8080/cartoes/' \
--header 'Content-Type: application/json' \
--header 'Authorization: ••••••' \
--header 'Cookie: JSESSIONID=50516B11C3E987A4E1C71148537314DC' \
--data '{
    "numeroCartao": "6149873025634619",
    "senha": "123123"
}'
```

### Response
````
{
    "numeroCartao": "6149873025634619",
    "senha": "123123"
}
````

### Request for GET - /cartoes/:numeroCartao
```
curl --location 'localhost:8080/cartoes/6549873025634619' \
--header 'Authorization: ••••••' \
```

### Response
````
450.00
````

### Request for GET - /cartoes/:numeroCartao
```
curl --location 'localhost:8080/transacoes/' \
--header 'Content-Type: application/json' \
--header 'Authorization: ••••••' \
--header 'Cookie: JSESSIONID=50516B11C3E987A4E1C71148537314DC' \
--data '{
    "numeroCartao": "6549873025634619",
    "senhaCartao": "1231231",
    "valor": 10.00
}'
```

### Response
````
{
    "numeroCartao": "6549873025634619",
    "senhaCartao": "123123",
    "valor": 440.00
}
````


### Contributors ✨
