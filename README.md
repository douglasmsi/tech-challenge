## 🍔 Fastfood

Welcome to the Fastfood documentation! 🎉🎉 This documentation provides an overview of the Fastfood application, a simple online food ordering and delivery system.

### Description

This is a simple application that allows users to order food online and have it delivered to their location. Whether you're craving a juicy burger, a delicious pizza, or a refreshing salad, Fastfood has got you covered!

### Hexagonal Architecture

The Fastfood application follows a hexagonal architecture, which provides a clear separation of concerns and promotes modularity and maintainability.

#### General Structure

                                 +-------------------------+
                                 |    FastfoodApplication   |
                                 +-------------------------+
                                            |
                                            |
                +-----------------------------------------------------------------+
                |                                                                 |
          +-----v-----+                                                   +-----v-----+
          | Controller |                                                   | Persistence|
          +-----+-----+                                                   +-----+-----+
                |                                                                 |
                |                                                                 |
      +---------v----------+                                            +---------v----------+
      |       Service       |                                            |     Repository       |
      +---------+----------+                                            +---------+----------+
                |                                                                 |
                |                                                                 |
      +---------v----------+                                            +---------v----------+
      |    Domain Model    |                                            |     Database         |
      +--------------------+                                            +----------------------+

#### Classes

1. `FastfoodApplication`: The main class of the application that initiates the program execution. It contains the main method that initializes the application.

2. `Controller`: These classes are responsible for receiving external requests and mapping them to the application's operations. They communicate with the service layer to execute the requested operations. Examples of classes in this layer: `ClienteController`, `ItemController`, `MetodoPagamentoController`, `PedidoController`, etc.

3. `Service`: These classes contain the business logic of the application. They implement the application's use cases and are responsible for orchestrating the operations. Service classes communicate with domain objects and persistence adapters. Examples of classes in this layer: `ClienteServicePortImpl`, `ItemServicePortImpl`, `MetodoPagamentoServicePortImpl`, `PedidoServicePortImpl`, etc.

4. `Domain Model`: These classes represent the business objects and domain rules of the application. They encapsulate the data and behaviors related to domain entities. Examples of classes in this layer: `Cliente`, `Item`, `MetodoPagamento`, `Pedido`, etc.

5. `Persistence`: These classes are responsible for handling data persistence. They communicate with the service layer to retrieve and store information in the database. Examples of classes in this layer: `ClientePersistencePortImpl`, `ItemPersistencePortImpl`, `MetodoPagamentoPersistencePortImpl`, `PedidoPersistencePortImpl`, etc.

6. `Repository`: These classes provide methods to access and manipulate data in the database. They implement the data access logic. Examples of classes in this layer: `ClienteJpaRepository`, `ItemJpaRepository`, `MetodoPagamentoJpaRepository`, `PedidoJpaRepository`, etc.

The hexagonal structure emphasizes the clear separation of responsibilities in different layers and the interaction between them. The core of the application is represented by the domain, which is independent of external technologies such as the database and controllers. The external layers, such as the controllers and persistence, communicate with the core through interfaces, following the principle of inversion of control.

### ✅ Running the Application

To run the application, you need to have Docker installed on your machine. Please follow these steps:

1. Open your terminal and navigate to the root directory of the project.

2. Run the following command:

```bash
make up
```

This command will start the application and set up the necessary environment.

### ⚠️ Viewing Application Logs

To view the logs of the aplication run the following command:

```bash
make logs
```

### 🛑 Stop Application

And to stop this aplication run this one:

```bash
make down
```



Passo 1:

- Cadastro do Cliente
  Pegar swagger do post pra cadastro do cliente

  curl --location 'localhost:8080/clientes' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "cpf": "654321",
  "nome": "Nome do Cliente 2",
  "telefone": "4444555",
  "endereco": "Endereço do Cliente 2",
  "email": "cliente2@example.com"
  }'

Passo 2: Cadastro de itens
Pegar swagger de cadastro de itens

	curl --location 'localhost:8080/items' \
--header 'Content-Type: application/json' \
--data '{
"nome": "Batata frita",
"descricao": "Bata frita",
"valor": 10.00,
"categoria": "ACOMPANHAMENTO"
}
'


Passo 3: Cadastrar os metodos de pagamento
Pegar swagger de metodos de pagamento

		curl --location 'localhost:8080/metodo-pagamentos' \
--header 'Content-Type: application/json' \
--data '{
"metodoPagamento": {
"cvv": "123",
"dataExpiracao": "12/24",
"numeroCartao": "134556",
"cpf": "22222"
}
}'


Passo 4: Cadastrar Abertura do Pedido
Pegar swagger de Pedido

	curl --location 'localhost:8080/pedidos' \
	--header 'Content-Type: application/json' \
	--data '{
	  "cpf": "123456"
	}
	'


Passo 5: Adicionar itens do Pedido
Pegar swagger de itens Pedido

		curl --location 'http://localhost:8080/pedidos/itempedido/FF2706234754' \
--header 'Content-Type: application/json' \
--data '{
"numeroPedido": "FF2706234754",
"item": {

    "id": 2
},
"quantidade": 1
}'


Passo 6: Checkout de Pagamento
Pegar swagger de Checkout de Pagamento

	curl --location 'http://localhost:8080/pedidos/checkout/FF2706234754' \
--header 'Content-Type: application/json' \
--data '{
"cpf": "1234567",
"metodoPagamentoId" : 2
}'

Passo 7: Alterar status do pedido
Pegar swagger de status do pedido

	curl --location --request PUT 'localhost:8080/pedidos/FF2706234754' \
--header 'Content-Type: application/json' \
--data '{
"statusPedido": "ANDAMENTO",
"cpf": "1234567",
"numeroPedido": "FF2706234754"
}'




