# fastfood


## Description

This is a simple application that allows users to order food online and have it delivered to their location.

## Hexagonal Architecture

The application is structured as follows:

## Structure general

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


### Classes

1. `FastfoodApplication`: The main class of the application that initiates the program execution. It contains the main method that initializes the application.

2. `Controller`: Classes responsible for receiving external requests and mapping them to the application's operations. They communicate with the service layer to execute the requested operations. Examples of classes in this layer: ClienteController, ItemController, MetodoPagamentoController, PedidoController, etc.

3. `Service`: Classes that contain the business logic of the application. They implement the application's use cases and are responsible for orchestrating the operations. Service classes communicate with domain objects and persistence adapters. Examples of classes in this layer: ClienteServicePortImpl, ItemServicePortImpl, MetodoPagamentoServicePortImpl, PedidoServicePortImpl, etc.

4. `Domain Model`: Classes that represent the business objects and domain rules of the application. These classes encapsulate the data and behaviors related to domain entities. Examples of classes in this layer: Cliente, Item, MetodoPagamento, Pedido, etc.

5. `Persistence`: Classes responsible for handling data persistence. They communicate with the service layer to retrieve and store information in the database. Examples of classes in this layer: ClientePersistencePortImpl, ItemPersistencePortImpl, MetodoPagamentoPersistencePortImpl, PedidoPersistencePortImpl, etc.

6. `Repository`: Classes that provide methods to access and manipulate data in the database. They implement the data access logic. Examples of classes in this layer: ClienteJpaRepository, ItemJpaRepository, MetodoPagamentoJpaRepository, PedidoJpaRepository, etc.

In this hexagonal structure, the clear separation of responsibilities in different layers and the interaction between them is emphasized. The core of the application is represented by the domain, which is independent of external technologies such as the database and controllers. The external layers, such as the controllers and persistence, communicate with the core through interfaces, following the principle of inversion of control.
     
## Run the application

Using mavem, run the following command in the root directory of the project:

```bash
mvn clean package
```

To run the application, you need to have Docker installed on your machine. Then, run the following command in the root directory of the project:

```bash
docker-compose up
```

## TO-DO - API Documentation


### Cronograma

1. Documentação do sistema (DDD) utilizando a linguagem ubíqua, dos seguintes fluxos:
a. Realização do pedido e pagamento **OK** </p>
b. Preparação e entrega do pedido **OK** </p>

2. Uma aplicação para todo sistema de backend (monolito) que deverá serdesenvolvidoseguindo os padrões apresentados nas aulas:
a. Utilizando arquitetura hexagonal **OK** </p>
b. APIs: </p>
• Cadastro do Cliente **OK** </p>
• Identificação do Cliente via CPF **OK** </p>
• Criar, editar e remover de produto </p>
• Buscar produtos por categoria </p>
• Fake checkout, apenas enviar os produtos escolhidos para a fila </p>
• Listar os pedidos </p>
c. Aplicação deverá ser escalável para atender grandes volumes nos horários de pico </p>
d. Banco de dados a sua escolha </p>
• Inicialmente deveremos trabalhar e organizar a fila dos pedidos apenas em banco de dados </p>
3. A aplicação deve ser entregue com um Dockerfile configurado para executá-la corretamente. </p>
Para validação da POC, temos a seguinte limitação de infraestrutura: </p>
a. 1 instância para banco de dados </p>
b. 1 instâncias para executar aplicação </p>


