# Framework Simples em Java

Este projeto é um framework para gerenciar entidades genéricas, permitindo a realização de operações básicas de CRUD (Create, Read, Update, Delete).


## Componentes do Framework

1. **CrudRepository.java**: Interface genérica que define os métodos para operações CRUD: `save`, `findById`, `update`, `delete` e `findAll`.

2. **InMemoryRepository.java**: Implementação da interface `CrudRepository` utilizando uma lista para armazenar as entidades em memória.

3. **InFileRepository.java**: Outra implementação da interface `CrudRepository`, que utiliza armazenamento em arquivo para gerenciar as entidades.

4. **Produto.java**: Classe que representa a entidade `Produto`, com atributos `nome` e `preco`, além de um método `toString` para exibir suas informações.

5. **Main.java**: Programa principal que demonstra o uso do framework, criando instâncias de `Produto` e utilizando o `InMemoryRepository` para armazená-los e exibir a lista de produtos.

6. **FrameworkTest.java**: Contém testes unitários para verificar o funcionamento do framework e das implementações de repositório.

## Como Testar o Framework

1. Clone o repositório em sua máquina local.
2. Navegue até a pasta do projeto.
3. Compile o projeto utilizando o Gradle: `./gradlew build`.
4. Execute o programa principal: `java -cp build/libs/Atividade06.jar Main`.
5. Verifique a saída no console para ver a lista de produtos.
