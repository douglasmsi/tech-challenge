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
     
## Cronograma

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


