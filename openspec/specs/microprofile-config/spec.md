# microprofile-config

## Purpose

Configuração do banco de dados via MicroProfile Config, mapeando variáveis de ambiente com valores padrão e centralizando propriedades de conexão JDBC.

## Requirements

### Requirement: Database configuration through MicroProfile Config
O sistema SHALL configurar a conexão com o banco de dados MySQL usando MicroProfile Config, lendo propriedades do arquivo `microprofile-config.properties` localizado em `META-INF/`. Cada propriedade SHALL mapear uma variável de ambiente com um valor padrão de fallback.

#### Scenario: Database connection uses MicroProfile config properties
- **WHEN** a aplicação inicia em qualquer ambiente (local, Docker, CI)
- **THEN** o datasource SHALL ser configurado com as propriedades `db.url`, `db.user`, `db.password` oriundas do MicroProfile Config

#### Scenario: Environment variable overrides default in microprofile-config.properties
- **WHEN** a variável de ambiente `MYSQL_USER` está definida como `prod_user`
- **THEN** a propriedade `db.user` SHALL resolver para `prod_user` ao invés do valor padrão `root`

#### Scenario: Default value used when environment variable is absent
- **WHEN** a variável de ambiente `MYSQL_PASSWORD` NÃO está definida
- **THEN** a propriedade `db.password` SHALL resolver para o valor padrão `root`

### Requirement: .env file preservation
O arquivo `.env` existente SHALL ser mantido sem alterações como fonte de variáveis de ambiente para desenvolvimento local.

#### Scenario: .env file unchanged after migration
- **WHEN** a configuração via MicroProfile Config é aplicada
- **THEN** o arquivo `.env` permanece idêntico ao estado anterior, com as mesmas chaves e valores

### Requirement: Datasource definition references MicroProfile Config
O `@DataSourceDefinition` SHALL referenciar propriedades do MicroProfile Config (`${db.user}`, `${db.password}`, `${db.url}`) ao invés de `${ENV=MYSQL_*}`.

#### Scenario: DataSource resolves properties from MicroProfile Config
- **WHEN** o Payara Micro inicia e processa o `@DataSourceDefinition`
- **THEN** os valores de `user`, `password` e `url` do datasource SHALL ser resolvidos via MicroProfile Config a partir das propriedades `db.user`, `db.password` e `db.url`
