# Pontos de Interesse

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Maven**
- **H2 Database**
- **Spring Data JPA**

## Entidades
Abaixo estão as entidades principais da aplicação:

- **PointOfInterest**: Representa um ponto de interesse com os atributos nome e localização em coordenadas.

## Endpoints
Aqui estão os principais endpoints disponíveis na aplicação:

### Point of Interest
- **GET /api/point-of-interest**: Retorna todos os pontos de interesse.
- **POST /api/point-of-interest**: Cria um novo ponto de interesse.
- **POST /api/point-of-interest/proximity**: Retorna uma lista de pontos de interesse mais próximos de um ponto de referência.

## Como Executar
   ```sh
   ./mvnw spring-boot:run
   ```
Acesse a aplicação em `http://localhost:8080`.

## Scripts SQL
Scripts de inicialização do banco de dados estão em:
- `src/main/resources/import.sql`

## Documentação
Acesse `http://localhost:8080/swagger-ui/index.html`

