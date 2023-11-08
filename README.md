# Anotações de Mapeamento

No contexto do mapeamento objeto-relacional (ORM) com o Java Persistence API (JPA), existem várias anotações de mapeamento que são usadas para definir relacionamentos entre entidades e mapeá-las para tabelas em um banco de dados. Aqui estão algumas das anotações de mapeamento mais comuns:

1. **@Entity**:
   - Anotação usada para marcar uma classe como uma entidade persistente. Isso significa que a classe será mapeada para uma tabela no banco de dados.

2. **@Table**:
   - Usada para especificar detalhes da tabela associada à entidade, como o nome da tabela, o esquema, etc.

3. **@Id**:
   - Marca uma propriedade da entidade como a chave primária. Pode ser usada em combinação com outras anotações, como `@GeneratedValue`, para definir a estratégia de geração de valores da chave primária.

4. **@GeneratedValue**:
   - Usada em conjunto com a anotação `@Id` para especificar a estratégia de geração de valores da chave primária, como `GenerationType.IDENTITY`, `GenerationType.SEQUENCE`, etc.

5. **@Column**:
   - Usada para mapear uma propriedade da entidade para uma coluna específica no banco de dados. Permite especificar detalhes, como o nome da coluna, o tipo de dados, a restrição de exclusão e outros.

6. **@Basic**:
   - É uma anotação de mapeamento simples que permite controlar o mapeamento de uma propriedade básica, como tipos primitivos e suas classes embrulhadoras.

7. **@Transient**:
   - Marca uma propriedade como não persistente, o que significa que ela não será mapeada para uma coluna no banco de dados.

8. **@OneToOne**:
   - Usada para definir um relacionamento um-para-um entre duas entidades. Isso é frequentemente usado quando uma entidade se relaciona com outra entidade de forma exclusiva.

9. **@ManyToOne**:
   - Usada para definir um relacionamento muitos-para-um entre duas entidades. Isso é comumente usado quando várias entidades se relacionam com uma única entidade.

10. **@OneToMany**:
    - Usada para definir um relacionamento um-para-muitos entre duas entidades. Isso é usado quando uma entidade pode se relacionar com várias entidades.

11. **@ManyToMany**:
    - Usada para definir um relacionamento muitos-para-muitos entre duas entidades. Isso é comumente usado quando várias entidades podem se relacionar com várias outras entidades.

12. **@JoinTable**:
    - Usada em conjunto com anotações de relacionamento, como `@ManyToMany`, para especificar uma tabela de junção que é usada para mapear o relacionamento muitos-para-muitos.

13. **@JoinColumn**:
    - Usada para especificar a coluna de junção em um relacionamento. É comumente usada para personalizar o nome da coluna e outras propriedades da junção.

14. **@OneToMany(mappedBy = "propriedade")**:
    - Usada na entidade "lado inverso" de um relacionamento bidirecional para mapear o relacionamento.

15. **@Cascade**:
    - Usada para especificar as operações que devem ser aplicadas em cascata em um relacionamento. Isso pode incluir operações de persistência, atualização e exclusão.

Estas são algumas das anotações de mapeamento mais comuns em JPA. Elas permitem definir relacionamentos complexos entre entidades e personalizar como as propriedades da entidade são mapeadas para o banco de dados. O uso correto dessas anotações é fundamental para criar um mapeamento eficiente e preciso entre objetos Java e tabelas de banco de dados.

# Anotação `@GeneratedValue`

A anotação `@GeneratedValue` é usada em conjunto com a anotação `@Id` para especificar como os valores da chave primária de uma entidade são gerados no banco de dados. Ela define a estratégia de geração dos valores da chave primária. Existem vários valores que pode atribuir à propriedade `strategy` da anotação `@GeneratedValue` para controlar a estratégia de geração. Aqui estão os valores mais comuns:

1. **GenerationType.IDENTITY**:
   - Esse valor indica que a chave primária será gerada automaticamente pelo banco de dados, geralmente usando colunas autoincrementáveis. Isso é comum em bancos de dados como o MySQL, PostgreSQL e SQL Server.

   Exemplo:
   ```java
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   ```

2. **GenerationType.SEQUENCE**:
   - Esse valor indica que a chave primária será gerada com base em uma sequência definida no banco de dados. O nome da sequência pode ser especificado usando a propriedade `generator`. Isso é comum em bancos de dados como o Oracle.

   Exemplo:
   ```java
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nomeDaSequencia")
   private Long id;
   ```

3. **GenerationType.TABLE**:
   - Esse valor indica que a chave primária será gerada com base em uma tabela especial no banco de dados que mantém um valor de chave primária. Isso é menos comum e pode ser usado quando as estratégias automáticas não estão disponíveis.

   Exemplo:
   ```java
   @Id
   @GeneratedValue(strategy = GenerationType.TABLE, generator = "nomeDaTabela")
   private Long id;
   ```

4. **GenerationType.AUTO**:
   - Este valor deixa a escolha da estratégia de geração para o provedor JPA ou banco de dados. O provedor JPA escolherá a estratégia apropriada com base no banco de dados subjacente.

   Exemplo:
   ```java
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   ```

5. **GenerationType.SEQUENCE** (Padrão):
   - Se você não especificar uma estratégia de geração, o JPA usará automaticamente a estratégia `GenerationType.SEQUENCE` como padrão. Isso pode ser personalizado definindo a propriedade `hibernate.id.new_generator_mappings` como `true` nas configurações do Hibernate, para usar a estratégia padrão do banco de dados.

   Exemplo:
   ```java
   @Id
   @GeneratedValue
   private Long id;
   ```

As estratégias de geração de valores da chave primária podem variar de um banco de dados para outro, portanto, é importante escolher a estratégia apropriada com base no banco de dados que você está usando. A anotação `@GeneratedValue` oferece flexibilidade para lidar com várias estratégias de geração de chaves primárias em diferentes bancos de dados.

# Anotação @Table

A anotação `@Table` é usada em mapeamento objeto-relacional (ORM) com o Java Persistence API (JPA) para especificar detalhes sobre a tabela de banco de dados associada a uma entidade. A propriedade `uniqueConstraints` na anotação `@Table` é usada para definir restrições de unicidade em colunas da tabela. Essas restrições garantem que os valores nas colunas especificadas sejam únicos, o que significa que não podem ser duplicados no banco de dados.

As propriedades e valores relacionados à anotação `@Table`:

- `name` (Padrão: Nome da entidade em letras minúsculas):
   - Essa propriedade permite especificar o nome da tabela no banco de dados que será associada à entidade. O valor padrão é o nome da entidade em letras minúsculas.

- `uniqueConstraints`:
   - Essa propriedade permite definir uma ou mais restrições de unicidade para as colunas da tabela. Cada restrição de unicidade é definida como um objeto `@UniqueConstraint`. Você pode especificar uma ou várias colunas em cada restrição e, opcionalmente, dar um nome à restrição.

- `indexes`:
   - Essa propriedade permite definir índices para as colunas da tabela, o que pode melhorar o desempenho de consultas ao banco de dados. Assim como `uniqueConstraints`, você pode especificar os nomes dos índices, se desejar.

Exemplo que usa a propriedade `uniqueConstraints` para criar uma restrição de unicidade em uma coluna chamada "nome" na tabela associada a uma entidade:

```java
@Entity
@Table(name = "pessoa", uniqueConstraints = {
    @UniqueConstraint(columnNames = "nome")
})
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Outros campos e métodos
}
```

Neste exemplo, a entidade `Pessoa` está mapeada para a tabela "pessoa" no banco de dados. A propriedade `uniqueConstraints` está sendo usada para especificar que a coluna "nome" deve ter valores únicos, ou seja, não podem haver duas pessoas com o mesmo nome na tabela.

Essa restrição de unicidade garante que o banco de dados impeça a inserção de registros duplicados na coluna "nome". Se uma tentativa de inserção violar essa restrição, o banco de dados lançará uma exceção ou retornará um erro, dependendo do sistema de gerenciamento de banco de dados usado. Isso é útil quando você deseja garantir a integridade dos dados e evitar duplicações em colunas específicas.

# Propriedade cascade

A propriedade `cascade` na anotação de mapeamento, como `@OneToMany`, `@ManyToOne`, `@OneToOne`, e outras, é usada para especificar as operações que devem ser propagadas automaticamente do objeto proprietário (ou principal) para os objetos dependentes (ou relacionados). O valor `CascadeType.ALL` é um dos valores possíveis dessa propriedade e indica que todas as operações devem ser propagadas. Outros valores possíveis incluem `CascadeType.PERSIST`, `CascadeType.MERGE`, `CascadeType.REMOVE`, entre outros.

Explicação mais detalhada do valor `CascadeType.ALL` e de outros valores comuns:

1. **`CascadeType.ALL`**:
   - O valor `CascadeType.ALL` indica que todas as operações de persistência (inserção, atualização e exclusão) devem ser propagadas automaticamente dos objetos proprietários para os objetos dependentes. Isso significa que, se você criar, atualizar ou excluir o objeto proprietário, as mesmas operações serão aplicadas automaticamente aos objetos relacionados.

2. **`CascadeType.PERSIST`**:
   - O valor `CascadeType.PERSIST` indica que apenas a operação de persistência (inserção) deve ser propagada automaticamente. Isso é útil quando deseja que objetos dependentes sejam inseridos no banco de dados automaticamente quando o objeto proprietário for persistido.

3. **`CascadeType.MERGE`**:
   - O valor `CascadeType.MERGE` indica que apenas a operação de mesclagem (atualização) deve ser propagada automaticamente. Isso é útil quando deseja que objetos dependentes sejam atualizados automaticamente quando o objeto proprietário for mesclado.

4. **`CascadeType.REMOVE`**:
   - O valor `CascadeType.REMOVE` indica que apenas a operação de remoção (exclusão) deve ser propagada automaticamente. Isso é útil quando deseja que objetos dependentes sejam excluídos automaticamente quando o objeto proprietário for removido.

5. **`CascadeType.REFRESH`**:
   - O valor `CascadeType.REFRESH` indica que a operação de recarregamento (refresh) deve ser propagada automaticamente. Isso é útil quando deseja que objetos dependentes sejam atualizados a partir do banco de dados automaticamente quando o objeto proprietário for recarregado.

6. **`CascadeType.DETACH`**:
   - O valor `CascadeType.DETACH` indica que a operação de desanexação (detach) deve ser propagada automaticamente. Isso é útil quando deseja que objetos dependentes sejam desanexados da sessão do JPA automaticamente quando o objeto proprietário for desanexado.

A escolha do valor apropriado para a propriedade `cascade` depende das necessidades específicas do seu aplicativo. Se você quiser que todas as operações sejam propagadas automaticamente, pode usar `CascadeType.ALL`. No entanto, em muitos casos, é melhor especificar apenas os valores necessários para evitar operações indesejadas. Por exemplo, se você deseja apenas que objetos dependentes sejam inseridos quando o objeto proprietário for persistido, use `CascadeType.PERSIST`.

# Propriedade `fetch`

No contexto do mapeamento objeto-relacional (ORM) com o Java Persistence API (JPA), a propriedade `fetch` é usada para especificar a estratégia de carregamento de associações entre entidades. O valor da propriedade `fetch` controla como as entidades associadas são carregadas quando você recupera uma entidade do banco de dados. Existem dois valores principais para a propriedade `fetch`:

1. **FetchType.LAZY**:
   - Quando uma associação é definida como `FetchType.LAZY`, as entidades associadas são carregadas somente quando você acessa explicitamente essa associação. Isso significa que, se você recuperar uma entidade que possui associações preguiçosas, essas associações não serão carregadas automaticamente. Em vez disso, elas serão carregadas sob demanda, quando você tentar acessá-las pela primeira vez. Isso pode ser útil para evitar o carregamento desnecessário de dados quando não são necessários. Portanto, ao utilizar o `FetchType.LAZY`, significa que a entidade associada será carregada apenas quando você acessá-la pela primeira vez.

   Exemplo:
   ```java
   @ManyToOne(fetch = FetchType.LAZY)
   private Categoria categoria;
   ```

2. **FetchType.EAGER**:
   - Quando uma associação é definida como `FetchType.EAGER`, as entidades associadas são carregadas automaticamente quando você recupera a entidade proprietária (a que possui a anotação `@ManyToOne`). Isso significa que todas as associações marcadas como `EAGER` serão carregadas imediatamente junto com a entidade proprietária. Isso pode ser útil quando você sabe que sempre precisará das entidades associadas quando acessar a entidade proprietária. Portanto, ao utilizar o `FetchType.EAGER`, significa que a entidade associada será carregada automaticamente quando a entidade proprietária (a que possui a anotação @ManyToOne) for carregada.
   Vale ressaltar que o valor padrão é `EAGER`.

   Exemplo:
   ```java
   @ManyToOne(fetch = FetchType.EAGER)
   private Cliente cliente;
   ```

Além desses dois valores principais, é importante observar que o JPA também oferece o valor `FetchType.DEFAULT`, que delega a estratégia de carregamento ao provedor JPA ou ao sistema de configuração. O valor padrão pode variar entre os provedores JPA, mas é frequentemente equivalente a `FetchType.EAGER`.

É importante escolher a estratégia de carregamento apropriada com base nos requisitos do seu aplicativo. Usar `FetchType.LAZY` para associações que raramente são necessárias pode melhorar o desempenho, pois evita o carregamento desnecessário de dados. Por outro lado, o uso de `FetchType.EAGER` para associações que são frequentemente necessárias pode simplificar o código, garantindo que os dados estejam sempre disponíveis.

Você também pode personalizar ainda mais o carregamento de associações usando a anotação `@Fetch` e `@BatchSize`, dependendo do provedor JPA que você está usando. Essas anotações permitem ajustar o carregamento de associações de maneira mais detalhada.

# Propriedade Optional

Propriedade optional (Padrão: true): Essa propriedade controla se a associação é obrigatória ou opcional. Se optional for definido como **`false`**, significa que a associação é obrigatória, e a entidade proprietária não pode ser persistida (inserida no banco de dados) sem uma entidade associada válida. Se optional for definido como **`true`**, a associação é opcional, o que significa que a entidade proprietária pode existir sem uma entidade associada válida.

# Anotação `@JsonProperty`

A anotação `@JsonProperty` faz parte da biblioteca Jackson, que é amplamente usada para serialização (escrita) e desserialização (leitura) de objetos Java para formatos como JSON. Ela é usada para personalizar a serialização e desserialização de propriedades de objetos Java para JSON (e vice-versa). A propriedade `access` na anotação `@JsonProperty` é usada para controlar o acesso a uma propriedade específica durante a serialização e desserialização. Os principais valores possíveis para a propriedade `access` são `Access.READ_ONLY`, `Access.WRITE_ONLY` e `Access.READ_WRITE`. 

Significado de cada um desses valores:

1. **`Access.READ_ONLY`**:
   - Quando uma propriedade é anotada com `@JsonProperty(access = Access.READ_ONLY)`, isso significa que a propriedade será incluída apenas na fase de desserialização (leitura de JSON para um objeto Java) e será excluída durante a serialização (geração de JSON a partir de um objeto Java). Isso é útil quando você deseja que uma propriedade seja apenas lida e não seja escrita para o JSON de saída. Por exemplo, você pode usar isso para ocultar senhas durante a serialização.

   Exemplo:
   ```java
   @JsonProperty(access = Access.READ_ONLY)
   private String senha;
   ```

2. **`Access.WRITE_ONLY`**:
   - Quando uma propriedade é anotada com `@JsonProperty(access = Access.WRITE_ONLY)`, isso significa que a propriedade será incluída apenas na fase de serialização (geração de JSON a partir de um objeto Java) e será ignorada durante a desserialização (leitura de JSON para um objeto Java). Isso é útil quando você deseja que uma propriedade seja apenas escrita no JSON de saída e não seja lida a partir do JSON de entrada. Por exemplo, você pode usar isso para evitar que uma propriedade seja atualizada a partir do JSON.

   Exemplo:
   ```java
   @JsonProperty(access = Access.WRITE_ONLY)
   private String comentario;
   ```

3. **`Access.READ_WRITE` (Padrão)**:
   - Se você não especificar a propriedade `access` ou definir `@JsonProperty` sem um valor de acesso, o valor padrão é `Access.READ_WRITE`. Isso significa que a propriedade será incluída tanto na fase de desserialização quanto na fase de serialização. Ou seja, a propriedade será lida a partir do JSON de entrada e escrita para o JSON de saída.

   Exemplo:
   ```java
   @JsonProperty
   private String nome;
   ```

O uso da anotação `@JsonProperty(access)` é útil para personalizar como propriedades específicas são tratadas durante a conversão entre objetos Java e JSON. Isso permite maior controle sobre quais propriedades são incluídas ou excluídas, dependendo dos requisitos do seu aplicativo.

# Uso da anotação @JsonProperty(access = Access.WRITE_ONLY) em conjunto com FetchType.LAZY

O uso da anotação `@JsonProperty(access = Access.WRITE_ONLY)` em conjunto com `FetchType.LAZY` é uma abordagem comum em sistemas que fazem uso de ORM (Object-Relational Mapping), como o Java Persistence API (JPA), quando deseja evitar erros de serialização em situações em que carregamento preguiçoso (lazy loading) está envolvido.

O carregamento preguiçoso (`FetchType.LAZY`) é uma técnica usada para adiar o carregamento de dados associados a uma entidade até que esses dados sejam acessados pela primeira vez. Isso ajuda a melhorar o desempenho ao evitar a recuperação desnecessária de dados do banco de dados, especialmente quando está lidando com relacionamentos muitos-para-um ou muitos-para-muitos. No entanto, quando você tenta serializar uma entidade com associações preguiçosas diretamente em JSON (ou em outro formato de saída), pode ocorrer uma exceção de carregamento preguiçoso, pois a plataforma de serialização tentará acessar as associações que ainda não foram carregadas.

A anotação `@JsonProperty(access = Access.WRITE_ONLY)` é usada para resolver esse problema. Ela diz ao sistema de serialização que a propriedade em questão só deve ser considerada durante a fase de serialização (de objeto Java para JSON), mas deve ser ignorada durante a fase de desserialização (de JSON para objeto Java). Isso significa que, ao serializar a entidade, a associação preguiçosa não será acessada, evitando assim a exceção de carregamento preguiçoso.

Exemplo prático de como isso pode ser útil:

```java
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Outros campos e métodos

    @JsonProperty(access = Access.WRITE_ONLY)
    public Cliente getCliente() {
        return cliente;
    }
}
```

Neste exemplo, a propriedade `cliente` é marcada com `FetchType.LAZY`, o que significa que o carregamento do cliente será adiado até que ele seja acessado. No entanto, a anotação `@JsonProperty(access = Access.WRITE_ONLY)` é usada no método `getCliente()`, o que indica que a propriedade `cliente` só deve ser considerada durante a serialização (escrita) e não durante a desserialização (leitura).

Essa abordagem permite que evite exceções de carregamento preguiçoso durante a serialização, mantendo o carregamento preguiçoso para obter um melhor desempenho em consultas de banco de dados quando o cliente não é necessário. Isso é particularmente útil em cenários onde deseja otimizar o desempenho e evitar consultas dispendiosas, como carregar dados associados somente quando necessário.

# Relacionamento Unidirecional e Bidirecional entre entidades

## Relacionamento @OneToOne

### 1. **Relacionamento @OneToOne Unidirecional**:

Neste tipo de relacionamento, uma entidade se relaciona com outra, mas a segunda entidade não tem conhecimento do relacionamento. Isso significa que apenas uma das entidades mantém a referência para a outra. Criando um exemplo de relacionamento `@OneToOne` unidirecional entre as entidades `Estudante` e `CartaoEstudante`, onde cada estudante possui um cartão de estudante:

```java
@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "cartao_estudante_id")
    private CartaoEstudante cartaoEstudante;

    // Getters e setters
}
```

```java
@Entity
public class CartaoEstudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    // Getters e setters
}
```

Neste exemplo, a entidade `Estudante` possui uma associação `@OneToOne` com a entidade `CartaoEstudante`. Cada estudante possui um cartão de estudante. A coluna `cartao_estudante_id` na tabela de estudantes é usada para armazenar a chave estrangeira que faz a ligação com a tabela de cartões de estudante. No entanto, a entidade `CartaoEstudante` não tem conhecimento desse relacionamento.

### 2. **Relacionamento @OneToOne Bidirecional**:

Neste tipo de relacionamento, ambas as entidades têm conhecimento uma da outra e mantêm referências mútuas. Criando um exemplo de relacionamento `@OneToOne` bidirecional entre as mesmas entidades `Estudante` e `CartaoEstudante`:

```java
@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(mappedBy = "estudante")
    private CartaoEstudante cartaoEstudante;

    // Getters e setters
}
```

```java
@Entity
public class CartaoEstudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @OneToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    // Getters e setters
}
```

Neste exemplo, a entidade `CartaoEstudante` agora possui uma associação bidirecional com a entidade `Estudante`. Além da associação `@OneToOne` em `Estudante`, a entidade `CartaoEstudante` possui uma associação `@OneToOne` com `Estudante`, usando a propriedade `estudante` e uma coluna `estudante_id`. A entidade `Estudante` possui uma associação `@OneToOne` com `CartaoEstudante` através da propriedade `cartaoEstudante`, usando a propriedade `mappedBy` para indicar que a entidade `CartaoEstudante` é o lado proprietário do relacionamento.

Agora, é possível acessar o cartão de estudante de um estudante a partir de um objeto `Estudante` e também acessar o estudante de um cartão de estudante a partir de um objeto `CartaoEstudante`. Isso é útil quando você precisa navegar em ambos os sentidos do relacionamento `@OneToOne`.

## Relacionamento @OneToMany

### 1. **Relacionamento @OneToMany Unidirecional**:

Neste tipo de relacionamento, uma entidade se relaciona com outra, mas a segunda entidade não tem conhecimento do relacionamento. Isso significa que apenas uma das entidades mantém a referência para a outra. Criando um exemplo de relacionamento `@OneToMany` unidirecional entre as entidades `Classe` e `Aluno`, onde uma classe possui vários alunos:

```java
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    @JoinColumn(name = "classe_id")
    private List<Aluno> alunos;

    // Getters e setters
}
```

```java
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Getters e setters
}
```

Neste exemplo, a entidade `Classe` possui uma associação `@OneToMany` com a entidade `Aluno`. Uma classe pode ter vários alunos, e a coluna `classe_id` na tabela de alunos é usada para armazenar a chave estrangeira que faz a ligação com a tabela de classes. No entanto, a entidade `Aluno` não tem conhecimento desse relacionamento.

### 2. **Relacionamento @OneToMany Bidirecional**:

Neste tipo de relacionamento, ambas as entidades têm conhecimento uma da outra e mantêm referências mútuas. Criando um exemplo de relacionamento `@OneToMany` bidirecional entre as mesmas entidades `Classe` e `Aluno`:

```java
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "classe")
    private List<Aluno> alunos;

    // Getters e setters
}
```

```java
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    // Getters e setters
}
```

Neste exemplo, a entidade `Aluno` agora possui uma associação bidirecional com a entidade `Classe`. Além da associação `@ManyToOne` em `Aluno`, a entidade `Classe` possui uma associação `@OneToMany` com a lista de alunos, usando a propriedade `alunos`. A propriedade `mappedBy` é usada para indicar que a entidade `Classe` é o lado proprietário do relacionamento.

Agora, é possível acessar os alunos de uma classe a partir de um objeto `Classe` e também acessar a classe de um aluno a partir de um objeto `Aluno`. Isso é útil quando você precisa navegar em ambos os sentidos do relacionamento `@OneToMany`.


## Relacionamento @ManyToOne

### 1. **Relacionamento @ManyToOne Unidirecional**:

Neste tipo de relacionamento, uma entidade se relaciona com outra, mas a segunda entidade não tem conhecimento do relacionamento. Isso significa que apenas uma das entidades mantém a referência para a outra. Criando um exemplo de relacionamento `@ManyToOne` unidirecional entre as entidades `Pedido` e `Cliente`, onde um pedido pertence a um único cliente:

```java
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Getters e setters
}
```

```java
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Getters e setters
}
```

Neste exemplo, a entidade `Pedido` possui uma associação `@ManyToOne` com a entidade `Cliente`. Um pedido pertence a um único cliente. A coluna `cliente_id` na tabela de pedidos é usada para armazenar a chave estrangeira que faz a ligação com a tabela de clientes. No entanto, a entidade `Cliente` não tem conhecimento desse relacionamento.

### 2. **Relacionamento @ManyToOne Bidirecional**:

Neste tipo de relacionamento, ambas as entidades têm conhecimento uma da outra e mantêm referências mútuas. Criando um exemplo de relacionamento `@ManyToOne` bidirecional entre as mesmas entidades `Pedido` e `Cliente`:

```java
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Getters e setters
}
```

```java
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    // Getters e setters
}
```

Neste exemplo, a entidade `Cliente` agora possui uma associação bidirecional com a entidade `Pedido`. Além da associação `@ManyToOne` em `Pedido`, a entidade `Cliente` possui uma associação `@OneToMany` com a lista de pedidos, usando a propriedade `pedidos`. O atributo `mappedBy = "cliente"` especifica que a entidade `Cliente` é o lado proprietário do relacionamento, ou seja, o campo `cliente` em `Pedido` é o que mapeia o relacionamento.

Agora, é possível acessar os pedidos de um cliente a partir de um objeto `Cliente` e também acessar o cliente de um pedido a partir de um objeto `Pedido`. Isso é útil quando você precisa navegar em ambos os sentidos do relacionamento.

## Relacionamento @ManyToMany

### 1. **Relacionamento @ManyToMany Unidirecional**:

Neste tipo de relacionamento, uma entidade se relaciona com outra, mas a segunda entidade não tem conhecimento do relacionamento. Isso significa que apenas uma das entidades mantém a referência para a outra. Criando um exemplo de relacionamento `@ManyToMany` unidirecional entre as entidades `Aluno` e `Disciplina`, onde cada aluno pode se inscrever em várias disciplinas:

```java
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name = "aluno_disciplina",
        joinColumns = @JoinColumn(name = "aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas;

    // Getters e setters
}
```

```java
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Getters e setters
}
```

Neste exemplo, a entidade `Aluno` possui uma associação `@ManyToMany` com a entidade `Disciplina`. Um aluno pode se inscrever em várias disciplinas, e isso é representado por uma tabela intermediária chamada "aluno_disciplina". A entidade `Disciplina` não tem conhecimento desse relacionamento.

### 2. **Relacionamento @ManyToMany Bidirecional**:

Neste tipo de relacionamento, ambas as entidades têm conhecimento uma da outra e mantêm referências mútuas. Criando um exemplo de relacionamento `@ManyToMany` bidirecional entre as mesmas entidades `Aluno` e `Disciplina`:

```java
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name = "aluno_disciplina",
        joinColumns = @JoinColumn(name = "aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas;

    // Getters e setters
}
```

```java
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<Aluno> alunos;

    // Getters e setters
}
```

Neste exemplo, a entidade `Disciplina` possui uma associação `@ManyToMany` bidirecional com a entidade `Aluno`. Além da associação `@ManyToMany` em `Aluno`, a entidade `Disciplina` possui uma associação `@ManyToMany` com `Aluno` usando a propriedade `alunos`, e a propriedade `mappedBy` é usada para indicar que a entidade `Aluno` é o lado proprietário do relacionamento.

Agora, é possível acessar as disciplinas de um aluno a partir de um objeto `Aluno` e também acessar os alunos inscritos em uma disciplina a partir de um objeto `Disciplina`. Isso é útil quando você precisa navegar em ambos os sentidos do relacionamento `@ManyToMany`.