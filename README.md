# fastfood


## Description

This is a simple application that allows users to order food online and have it delivered to their location.

## Hexagonal Architecture

The application is structured as follows:

- src
    - main
        - java
            - br.com.fiap.postech.fastfood
                - config
                - controller
                - domain
                    - model
                    - repository
                    - usecase
                - dtos
                - enums
                - exceptions
                - infrastructure
                    - persistence
                - metrics
                - util
        - resources
            - db
                - migration
    - test
        - java
            - br.com.fiap.postech.fastfood
                - controller
                - domain
                - infrastructure
        - resources


