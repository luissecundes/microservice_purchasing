# Microservice Purchasing

Projeto de microserviço de compras (Purchasing) desenvolvido em **Spring Boot + MySQL**, com suporte a execução:

✅ Em ambiente local (desenvolvimento rápido)  
✅ Em ambiente Docker (produção / integração / QA)  

## ⚙️ Tecnologias

- Java 21+
- Spring Boot 3+
- Spring Data JPA
- MySQL 8+
- Docker & Docker Compose
- HikariCP (pool de conexões)
- Lombok

## 🚀 Objetivo

Este microserviço faz a gestão completa de **Pedidos de Compra (Purchase Orders)**, com:

- Fornecedores
- Pedidos de compra
- Itens dos pedidos
- Recebimento de mercadorias
- Documentos de fornecedores
- Aprovação de pedidos de compra

---

## 🛠️ Ambientes suportados

### 1️⃣ Ambiente Local (recomendado para desenvolvimento)

Para desenvolvimento local você **NÃO precisa rebuildar imagens Docker a cada alteração**.

Recomendado:

✅ Banco MySQL rodando localmente  
✅ Aplicação rodando via `./mvnw spring-boot:run` ou via IntelliJ

👉 Assim você ganha agilidade no desenvolvimento.

### Como configurar:

#### 1. Copie o arquivo de exemplo:

```bash
cp src/main/resources/application-dev.properties.example 
   src/main/resources/application-dev.properties
```

#### 2. Preencha seu application-dev.properties com seus dados locais:

````
spring.datasource.url=jdbc:mysql://localhost:3306/microservice_purchasing
spring.datasource.username=root
spring.datasource.password=sua-senha
...
````

#### 3. Rode o projeto localmente:

````
./mvnw spring-boot:run
````

### 2️⃣ Ambiente com Docker (produção, homologação, CI/CD)
Quando você quiser rodar a aplicação com o banco MySQL já via Docker:  
Navegue até a pasta do projeto, rode os comando a seguir porém não se esqueça de conferir suas credenciais no `.env`.   
Também verifique se as portas que está utilizando para requisição estão corretas (Docker: 8089)   

````
docker-compose --build (criar a imagem)
docker-compose up (subir o container)
````

O application-prod.properties já está configurado para usar variáveis de ambiente (`SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, etc).

O arquivo `.env.example` está disponível como template para o seu `.env` (não versionado por questões de segurança =D).   

Obs: Lembre-se de que o ambiente com docker, pode ser improdutivo, dado que a cada mudança no código, precisará ser criada uma nova imagem e um novo container.

### 🌍 Estrutura de Profiles

| Profile        | Finalidade              | Arquivo utilizado                       |
|----------------|-------------------------|-----------------------------------------|
| dev (default)  | Desenvolvimento local   | application-dev.properties              |
| prod           | Produção (com Docker)   | application-prod.properties + .env      |



Definido em:

```` 
# application.properties
spring.profiles.active=dev
````

Para forçar produção:

````
SPRING_PROFILES_ACTIVE=prod ./mvnw spring-boot:run
````
---

## 🛡️ Segurança e Boas práticas
NUNCA, JAMAIS, NEVER, suba senhas em application-dev.properties para o repositório.

- O `application-dev.properties` está no `.gitignore`.
- O `application-dev.properties.example` serve como template.
- Variáveis de ambiente sensíveis são controladas via `.env`, que também está no `.gitignore`.

---

## 📝 Checklist para Pull

✅ Clonar o repositório  
✅ Copiar `application-dev.properties.example` → `application-dev.properties`  
✅ Rodar MySQL local (ou via Docker Compose)  
✅ Rodar aplicação com `./mvnw spring-boot:run`  
✅ Não commitar arquivos `.env` ou `application-dev.properties`

---

## 🗂️ Estrutura de pastas

````
/src/main/java/com/gruposv/microservice_purchasing
  /modules
    /supplier
    /purchase_orders
    /purchase_order_items
    /goods_receipts
    /goods_receipt_items
    /po_approvals
/domain
/config
````
---

## 🖥️ Endpoints disponíveis
Exemplo:

#### Método	Endpoint	Descrição

| Método | Endpoint                      | Descrição              |
|--------|-------------------------------|------------------------|
| GET    | /api/suppliers                | Listar fornecedores    |
| POST   | /api/suppliers                | Criar fornecedor       |
| PUT    | /api/suppliers/{id}           | Atualizar fornecedor   |
| DELETE | /api/suppliers/{id}           | Soft delete fornecedor |


