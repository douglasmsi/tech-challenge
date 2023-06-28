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

## API Documentation

[Swagger Documentation](http://localhost:8080/swagger-ui/index.html#/)