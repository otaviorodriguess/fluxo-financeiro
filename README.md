# 💰 Fluxo Financeiro

<p align="center">
  API REST para controle financeiro com autenticação JWT
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-red?style=flat-square&logo=java">
  <img src="https://img.shields.io/badge/SpringBoot-3.x-brightgreen?style=flat-square&logo=springboot">
  <img src="https://img.shields.io/badge/SpringSecurity-JWT-green?style=flat-square">
  <img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=flat-square&logo=postgresql">
  <img src="https://img.shields.io/badge/Maven-Build-orange?style=flat-square&logo=apachemaven">
</p>

---

## 📌 Visão Geral

O **Fluxo Financeiro** é uma API desenvolvida com foco em:

- 🔐 Autenticação segura com JWT  
- 👤 Cadastro e gerenciamento de usuários  
- 💵 Registro de receitas e despesas  
- 📊 Cálculo automático de saldo  

Projeto ideal para estudo avançado de Spring Security, arquitetura REST e boas práticas com Java 21.

---

## 🏗 Arquitetura do Projeto

Estrutura organizada em camadas:

```
src
 ├── config
 ├── controller
 ├── service
 ├── repository
 ├── model
 └── security
```

✔ Separação clara de responsabilidades  
✔ Código limpo e escalável  
✔ Arquitetura preparada para crescimento  

---

## 🚀 Tecnologias

| Tecnologia | Finalidade |
|------------|------------|
| Java 21 | Linguagem principal |
| Spring Boot 3 | Estrutura da aplicação |
| Spring Security | Controle de acesso |
| JWT | Autenticação Stateless |
| Spring Data JPA | Persistência |
| Hibernate | ORM |
| PostgreSQL | Banco de dados |
| Maven | Gerenciador de dependências |

---

## ⚙️ Como Executar

### 1️⃣ Clonar o projeto

```bash
git clone https://github.com/otaviorodriguess/fluxo-financeiro.git
cd fluxo-financeiro
```

---

### 2️⃣ Configurar Banco de Dados

Arquivo:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/fluxo_financeiro
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 🔒 Variáveis de ambiente (recomendado)

```bash
setx DB_USER "seu_usuario"
setx DB_PASS "sua_senha"
```

---

### 3️⃣ Iniciar aplicação

```bash
mvn spring-boot:run
```

Aplicação disponível em:

```
http://localhost:8080
```

---

# 🔑 Endpoints

## 🔐 Autenticação

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/auth/register` | Cadastro de usuário |
| POST | `/auth/login` | Login e geração do token |
| GET | `/auth/me` | Usuário autenticado |

---

## 💳 Transações

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/transactions` | Criar nova transação |
| GET | `/transactions` | Listar transações |

---

## 📊 Resumo Financeiro

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/finance/resumo` | Retorna receitas, despesas e saldo |

---

# 📬 Exemplos de Uso

### 📝 Cadastro

```json
POST /auth/register
{
  "nome": "Tavin",
  "email": "tavin@teste.com",
  "senha": "123456"
}
```

---

### 🔐 Login

```json
POST /auth/login
{
  "email": "tavin@teste.com",
  "senha": "123456"
}
```

Resposta:

```json
{
  "token": "eyJhbGciOi..."
}
```

---

### 💵 Criar Transação

```json
POST /transactions
Authorization: Bearer <token>

{
  "descricao": "Salário",
  "valor": 5000.00,
  "tipo": "RECEITA",
  "data": "2026-03-05"
}
```

---

### 📊 Resumo

```json
GET /finance/resumo
Authorization: Bearer <token>
```

Resposta:

```json
{
  "receitas": 5000.0,
  "despesas": 1500.0,
  "saldo": 3500.0
}
```

---

# 📈 Próximas Evoluções

- 📤 Exportação CSV/Excel  
- 🔔 Notificação de saldo negativo  
- 🌐 Front-end consumindo API  
- 🧪 Testes automatizados  

---

# 👨‍💻 Autor

**Otávio Rodrigues (Tavin)** 🚀  
Projeto voltado para evolução técnica em back-end com Spring Boot.
