# Finance App

## 📌 Descrição do Projeto
O **Finance App** é uma aplicação de gestão e controle de finanças pessoais, desenvolvida com **Java Spring Boot** e banco de dados **MySQL AWS**. O objetivo do projeto é permitir que os usuários cadastrem, consultem e gerenciem suas transações financeiras de forma eficiente, além de gerar relatórios e análises para auxiliar no planejamento financeiro.

## 🛠️ Tecnologias Utilizadas
- **Backend:** Java 17, Spring Boot, Spring Data JPA, Spring Security
- **Banco de Dados:** MySQL (AWS RDS)
- **Frontend:** HTML, CSS, Bootstrap, Thymeleaf
- **Gerenciamento de Dependências:** Maven
- **Autenticação:** JWT (JSON Web Token)
- **Versionamento:** Git e GitHub

## 📂 Estrutura do Projeto
```bash
finance-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── isaquesoares/
│   │   │   │   │   ├── controller/        # Controladores das requisições
│   │   │   │   │   ├── model/              # Modelos de dados (entidades)
│   │   │   │   │   ├── repository/         # Repositórios para acesso ao banco de dados
│   │   │   │   │   ├── service/            # Regras de negócio
│   │   │   │   │   ├── dto/                # Objetos de transferência de dados
│   │   │   │   │   ├── security/           # Configuração de segurança (JWT, autenticação)
│   │   │   ├── application/                # Configurações do Spring Boot
│   │   ├── resources/
│   │   │   ├── static/                     # Arquivos estáticos (CSS, JS, imagens)
│   │   │   ├── templates/                  # Views Thymeleaf
│   │   │   └── application.properties      # Configurações da aplicação
├── pom.xml                                  # Dependências do Maven
└── README.md                                # Documentação do projeto
```

## 📌 Funcionalidades
- **Autenticação e Cadastro de Usuários**
  - Cadastro de usuários com criptografia de senha
  - Login com autenticação JWT
  - Controle de acesso baseado em permissões

- **Gestão Financeira**
  - Cadastro de receitas e despesas
  - Classificação por categorias
  - Relatórios financeiros mensais e anuais
  - Gráficos interativos de análise

- **Configurações e Personalização**
  - Edição de perfil do usuário
  - Definição de metas financeiras
  - Exportação de dados para CSV

## 🚀 Como Executar o Projeto
### 🔧 Pré-requisitos
Antes de rodar o projeto, certifique-se de ter instalado:
- **Java 17**
- **MySQL AWS** configurado
- **Maven**

### 🏃 Rodando a Aplicação
1. Clone o repositório:
   ```bash
   git clone https://github.com/Dev-Isaque/finance-app.git
   ```
2. Configure o banco de dados no **application.properties**:
   ```properties
   spring.datasource.url=jdbc:mysql://seu-banco.mysql.aws.com:3306/finance_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a aplicação no navegador:
   ```
   http://localhost:8080
   ```

## 📜 Licença
Este projeto está sob a licença MIT. Sinta-se à vontade para utilizá-lo e modificá-lo conforme necessário.

---
📌 **Autor:** [Isaque Soares](https://github.com/Dev-Isaque)  
📌 **Repositório:** [Finance App no GitHub](https://github.com/Dev-Isaque/finance-app-spring-boot-aws)
