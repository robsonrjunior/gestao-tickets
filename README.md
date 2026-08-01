# Gestão Tickets

Aplicação de gestão de tickets de suporte: criar, acompanhar, atribuir e resolver.

**Stack:** Java 21 · Jakarta EE 11 · Payara Micro · PrimeFaces · PrimeFlex · MySQL

---

## Requirements

- [Java SE 21+](https://adoptium.net)
- [Maven Wrapper](https://maven.apache.org/wrapper/) (incluído — não precisa instalar Maven)
- [GNU Make](https://www.gnu.org/software/make/)
- [Docker](https://docs.docker.com/get-docker/) _(opcional)_

## Development Notes

- UI: preferir componentes **PrimeFaces** (`p:`) e utilitários **PrimeFlex** (sem Bootstrap).
- Models em `src/main/java/.../model` usam Lombok (`@Getter`, `@Setter`, etc.).
- Ative annotation processing no IDE para o Lombok.
- Verifique com `./mvnw -q -DskipTests compile`.

> Primeira vez: torne o Maven Wrapper executável.
>
> ```bash
> chmod +x mvnw
> ```

---

## Running the Project

> Variáveis de `.env` são carregadas automaticamente pelo Makefile.
> Copie `.env-example` para `.env` se ainda não tiver o arquivo.

### Utilitários (MySQL)

Suba o banco antes de iniciar a aplicação (dev local ou Docker):

```bash
docker compose -f docker-compose.utils.yml up -d
```

Credenciais padrão (alinhadas com `.env-example`):

| Variável | Valor |
|---|---|
| Host / Porta | `localhost:3306` |
| Database | `gestao_tickets` |
| User | `user` |
| Password | `password` |

Parar / remover:

```bash
docker compose -f docker-compose.utils.yml down        # para o container
docker compose -f docker-compose.utils.yml down -v     # para e remove o volume de dados
```

### Standard (Payara no host)

Com o MySQL (utils) no ar e `MYSQL_HOST=localhost` no `.env`:

```bash
make start
```

Acesse [http://localhost:8080/gestao-tickets](http://localhost:8080/gestao-tickets).

`make start` e `make dev` rodam a app no host — só precisam do compose de utilitários, não do compose da aplicação.

---

### Hot Reload

```bash
make dev
```

### Stop Payara server

```bash
make stop
```

### Force stop Payara server

```bash
sudo fuser -k 8080/tcp
```

---

### Other Commands

```bash
make build    # package the application
make package  # clean and package
make test     # run tests
make clean    # remove build artifacts
```

---

### Docker (aplicação)

Pré-requisitos: WAR gerado e utilitários (MySQL) no ar.

```bash
make package
docker compose -f docker-compose.utils.yml up -d
docker compose up -d --build
```

Parar a aplicação:

```bash
docker compose down
```

Acesse [http://localhost:8080/gestao-tickets](http://localhost:8080/gestao-tickets).

> No compose da app, `MYSQL_HOST` é sobrescrito para `mysql` (hostname do serviço na rede Docker). No host (`make start`/`make dev`), use `MYSQL_HOST=localhost` no `.env`.
