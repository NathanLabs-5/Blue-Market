# Blue Market API — V2
Backend REST em Java 21 + Spring Boot + Spring Data JPA + MySQL.

## Requisitos
- JDK 21
- Maven 3.9+
- Docker e Docker Compose (recomendado para MySQL)

## Banco de dados
Na raiz do repositório:
```bash
docker compose up -d mysql
```
O MySQL fica em localhost:3307. Configure a aplicação:
```bash
export DB_URL='jdbc:mysql://localhost:3307/blue_market?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC'
export DB_USERNAME=blue_market_user
export DB_PASSWORD=blue_market_dev
```

## Executar
```bash
cd backend
mvn spring-boot:run
```
API: http://localhost:8080

## Endpoints
| Método | Endpoint | Função |
|---|---|---|
| GET | /api/produtos | Listar produtos ativos |
| GET | /api/produtos/{id} | Consultar produto |
| POST | /api/produtos | Cadastrar produto |
| PUT | /api/produtos/{id} | Atualizar produto |
| DELETE | /api/produtos/{id} | Desativar produto |
| POST | /api/usuarios/cadastro | Cadastrar cliente |
| POST | /api/pedidos | Finalizar pedido |
| GET | /api/pedidos/cliente/{id} | Histórico de pedidos |

## Estrutura
- model: entidades JPA
- repository: persistência com Spring Data
- service: regras de negócio e transações
- controller: endpoints HTTP
- dto: contratos de entrada e saída

## Segurança / estágio atual
Senhas são armazenadas com BCrypt. A API ainda está em modo de desenvolvimento: todas as rotas estão liberadas e JWT/autorização por perfil ainda não foram implementados. Não exponha esta versão à internet nem use em produção antes de concluir essa camada. CORS inicial: http://localhost:5173.
