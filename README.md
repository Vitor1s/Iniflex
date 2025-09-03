# Projeto Iniflex - Sistema de Gerenciamento de Funcionários

![Java](https://img.shields.io/badge/Java-11+-blue)
![Status](https://img.shields.io/badge/Status-Completo-green)

##  Descrição

O **Projeto Iniflex** é um sistema completo de gerenciamento de funcionários desenvolvido em Java que implementa operações essenciais de CRUD e relatórios para uma empresa. O sistema foi projetado seguindo os princípios da Programação Orientada a Objetos (POO) e utiliza as melhores práticas de desenvolvimento Java.

##  Objetivos

Este projeto foi desenvolvido para demonstrar:
- Implementação de herança em Java
- Manipulação de datas com `LocalDate`
- Operações precisas com valores monetários usando `BigDecimal`
- Uso de coleções (`List`, `Map`) e Stream API
- Formatação de dados conforme padrões brasileiros
- Aplicação de princípios SOLID

##  Arquitetura

O projeto segue uma arquitetura simples e organizada:

```
src/
├── Pessoa.java        # Classe base com atributos fundamentais
├── Funcionario.java   # Classe que estende Pessoa com informações profissionais
└── Principal.java     # Classe principal com toda a lógica de negócio
```

###  Estrutura das Classes

#### `Pessoa.java`
- **Atributos:**
  - `nome` (String): Nome da pessoa
  - `dataNascimento` (LocalDate): Data de nascimento
- **Características:**
  - Classe base para herança
  - Encapsulamento com getters/setters
  - Construtor parametrizado

#### `Funcionario.java`
- **Herança:** Estende a classe `Pessoa`
- **Atributos adicionais:**
  - `salario` (BigDecimal): Salário do funcionário (precisão monetária)
  - `funcao` (String): Cargo/função do funcionário
- **Características:**
  - Uso de `BigDecimal` para cálculos monetários precisos
  - Método `toString()` personalizado

#### `Principal.java`
- **Responsabilidade:** Lógica principal da aplicação
- **Funcionalidades implementadas:**
  - Gerenciamento de lista de funcionários
  - Operações de busca e filtragem
  - Cálculos salariais e relatórios
  - Formatação de saída conforme padrões brasileiros

##  Funcionalidades

###  Operações Básicas
1. **Inserção de Funcionários** - Cadastro completo com todos os dados
2. **Remoção de Funcionários** - Exclusão por nome
3. **Listagem Formatada** - Exibição com formatação brasileira

###  Relatórios e Análises
4. **Aumento Salarial** - Aplicação de percentual de aumento (10%)
5. **Agrupamento por Função** - Organização usando `Map<String, List<Funcionario>>`
6. **Aniversariantes** - Filtro por meses específicos (outubro e dezembro)
7. **Funcionário Mais Velho** - Cálculo de idade e identificação
8. **Ordenação Alfabética** - Lista ordenada por nome
9. **Total de Salários** - Soma total da folha de pagamento
10. **Análise Salarial** - Conversão para múltiplos do salário mínimo

###  Formatação Brasileira
- **Datas:** Formato `dd/MM/yyyy`
- **Valores Monetários:** `R$ x.xxx,xx` (ponto para milhares, vírgula para decimais)
- **Números:** Padrão brasileiro de separadores

##  Como Executar

### Pré-requisitos
- Java 11 ou superior
- JDK instalado e configurado

### Passos para execução

1. **Clone o repositório:**
```bash
git clone https://github.com/Vitor1s/Iniflex.git
cd Iniflex
```

2. **Compile o projeto:**
```bash
javac -d out src/*.java
```

3. **Execute a aplicação:**
```bash
java -cp out Principal
```

### Execução Alternativa (dentro da pasta src)
```bash
cd src
javac *.java
java Principal
```

##  Dados de Teste

O sistema vem pré-configurado com os seguintes funcionários:

| Nome     | Data Nascimento | Salário    | Função        |
|----------|----------------|------------|---------------|
| Maria    | 18/10/2000     | R$ 2.009,44| Operador      |
| João     | 12/05/1990     | R$ 2.284,38| Operador      |
| Caio     | 02/05/1961     | R$ 9.836,14| Coordenador   |
| Miguel   | 14/10/1988     | R$ 19.119,88| Diretor      |
| Alice    | 05/01/1995     | R$ 2.234,68| Recepcionista |
| Heitor   | 19/11/1999     | R$ 1.582,72| Operador      |
| Arthur   | 31/03/1993     | R$ 4.071,84| Contador      |
| Laura    | 08/07/1994     | R$ 3.017,45| Gerente       |
| Heloísa  | 24/05/2003     | R$ 1.606,85| Eletricista   |
| Helena   | 02/09/1996     | R$ 2.799,93| Gerente       |

> **Nota:** O funcionário "João" é removido automaticamente durante a execução conforme especificação.

##  Saída Esperada

A aplicação produzirá relatórios detalhados incluindo:

- ✅ Lista de funcionários após remoção
- ✅ Lista com formatação brasileira
- ✅ Funcionários após aumento de 10%
- ✅ Agrupamento por função
- ✅ Aniversariantes de outubro e dezembro
- ✅ Funcionário mais velho com idade calculada
- ✅ Lista em ordem alfabética
- ✅ Total da folha de pagamento
- ✅ Análise de salários em múltiplos do salário mínimo (R$ 1.212,00)

##  Tecnologias Utilizadas

- **Java 11+**: Linguagem principal
- **LocalDate**: Manipulação de datas
- **BigDecimal**: Cálculos monetários precisos
- **Collections Framework**: `List`, `Map`, `ArrayList`
- **Stream API**: Operações funcionais e filtragem
- **NumberFormat**: Formatação de números e moedas
- **DateTimeFormatter**: Formatação de datas

##  Conceitos Demonstrados

### Programação Orientada a Objetos
- **Herança**: `Funcionario extends Pessoa`
- **Encapsulamento**: Atributos privados com getters/setters
- **Polimorfismo**: Sobrescrita do método `toString()`

### Boas Práticas Java
- **Imutabilidade**: Uso de `final` em constantes
- **Precisão Monetária**: `BigDecimal` em vez de `double`
- **Programação Funcional**: Stream API para operações em coleções
- **Formatação Localizada**: Padrões brasileiros

### Padrões de Design
- **Single Responsibility**: Cada classe tem uma responsabilidade específica
- **DRY (Don't Repeat Yourself)**: Métodos auxiliares para formatação

## 👨‍💻 Autor

**Vitor Andrade**
- GitHub: [@Vitor1s](https://github.com/Vitor1s)

---
