# Átomo+ — API do Quiz (Java Advanced · Sprint 1)

API REST em **Java 21 + Spring Boot** que serve de motor do quiz educativo sobre as aplicações benéficas da tecnologia nuclear (saúde, agricultura, indústria, pesquisa e energia). Projeto do **Challenge CTMSP 2026** (Centro Tecnológico da Marinha em São Paulo) - FIAP, 2TDS.

## Grupo

| Nome                | RM         |
|---------------------|------------|
| _Gustavo Siciliano_ | _RM568419_ |
| _Gustavo de Jesus_  | _RM567926_ |
| _Manuel Gouveia_    | _RM567458_ |
| _Samuel Keniti_     | _RM567614_ |
| _Vinicius Morrone_  | _RM566884_ |

## O que foi desenvolvido nesta Sprint

- CRUD completo de **Pergunta** (com suas 4 **Alternativas**) usando Spring Data JPA
- Busca por texto do enunciado com **Query Method** (`findByEnunciadoContainingIgnoreCase`)
- **Spring Validation** nos dados de entrada
- **Tratamento global de exceções** (`@RestControllerAdvice`)
- Documentação **Swagger / OpenAPI**
- Dados de teste carregados automaticamente (9 perguntas)

## Regras de negócio

- Cada pergunta pertence a uma categoria (`CRIANCA`, `JOVEM`, `ADULTO`) e a um setor (`SAUDE`, `AGRICULTURA`, `INDUSTRIA`, `PESQUISA`, `ENERGIA`)
- Toda pergunta tem **exatamente 4 alternativas** e **só 1 correta**, sem textos repetidos
- Pontos por acerto conforme a categoria: Criança = 10, Jovem = 20, Adulto = 30 (campo `pontos` na resposta)

## Como executar

Requisito: JDK 21.

```bash
./mvnw spring-boot:run
```

Por padrão usa **H2 em memória** (nada para configurar).

- Swagger: http://localhost:8080/swagger-ui.html
- Console H2: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:atomo`, usuário `sa`, senha vazia)

### Usando Oracle (opcional)

As credenciais **não ficam no repositório**; use variáveis de ambiente:

```bash
export ORACLE_URL=jdbc:oracle:thin:@//host:1521/servico
export ORACLE_USER=usuario
export ORACLE_PASSWORD=senha
./mvnw spring-boot:run -Dspring-boot.run.profiles=oracle
```

## Endpoints

| Método | Rota | Descrição |
| --- | --- | --- |
| POST | `/perguntas` | Cadastra pergunta |
| GET | `/perguntas` | Lista (filtro opcional `?categoria=JOVEM`) |
| GET | `/perguntas/busca?texto=radiacao` | Busca por texto do enunciado |
| GET | `/perguntas/{id}` | Consulta por id |
| PUT | `/perguntas/{id}` | Atualiza |
| DELETE | `/perguntas/{id}` | Exclui |

Exemplo de corpo para `POST /perguntas`:

```json
{
  "enunciado": "Qual elemento é usado como combustível em usinas nucleares?",
  "categoria": "JOVEM",
  "setor": "ENERGIA",
  "alternativas": [
    { "texto": "Urânio", "correta": true },
    { "texto": "Carvão", "correta": false },
    { "texto": "Hélio", "correta": false },
    { "texto": "Sódio", "correta": false }
  ]
}
```

Códigos de erro: `400` (dados inválidos), `404` (pergunta não encontrada), `422` (regra de negócio violada).

## Estrutura

```
src/main/java/br/com/protons/sprintapi
├── controller # endpoints REST + anotações Swagger
├── service # regras de negócio
├── repository # Spring Data JPA (Query Methods)
├── model # entidades Pergunta e Alternativa, enums Categoria e Setor
├── dto # records de entrada e saída
├── exception # exceções e handler global
└── config # OpenAPI e dados de teste
```
