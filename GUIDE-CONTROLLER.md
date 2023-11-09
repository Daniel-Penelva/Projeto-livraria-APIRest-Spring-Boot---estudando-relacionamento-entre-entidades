# Classe URI

A classe `URI` (Uniform Resource Identifier) faz parte da biblioteca padrão do Java e é usada para representar e manipular identificadores de recursos uniformes. URIs são strings que identificam recursos, como URLs (Uniform Resource Locators) que especificam a localização de recursos na web. A classe `URI` fornece métodos para criar, analisar, comparar e manipular URIs de forma programática.

Algumas funcionalidades e conceitos importantes relacionados à classe `URI`:

1. **Construção de URIs**:
   - Pode criar uma instância de `URI` de várias maneiras, incluindo fornecendo uma string de URI como argumento para o construtor, ou usando a classe `URI` para construir partes de um URI, como o esquema, autoridade, caminho, consulta e fragmento. Por exemplo:
     ```java
     URI uri1 = new URI("https://www.example.com/resource");
     URI uri2 = new URI("https", "www.example.com", "/resource", null);
     ```

2. **Acesso aos Componentes do URI**:
   - A classe `URI` fornece métodos para acessar os diferentes componentes de um URI, como o esquema, autoridade, caminho, consulta e fragmento. Por exemplo:
     ```java
     String scheme = uri.getScheme();
     String host = uri.getHost();
     String path = uri.getPath();
     String query = uri.getQuery();
     ```

3. **Comparação de URIs**:
   - Você pode comparar duas instâncias de `URI` para determinar se elas representam o mesmo recurso. A classe `URI` fornece métodos de comparação, como `equals`, `hashCode`, `compareTo` e outros.

4. **Manipulação de URIs**:
   - A classe `URI` permite que você crie URIs relativos a outros URIs e resolva URIs em relação a URIs de base. Isso é útil ao criar links relativos ou ao navegar entre recursos relacionados.

5. **Validação de URIs**:
   - Pode usar a classe `URI` para validar se uma string representa um URI válido. O construtor da classe `URI` lançará uma exceção `URISyntaxException` se a string não for um URI válido.

6. **URI Absoluto e Relativo**:
   - Um URI absoluto especifica o recurso de forma completa, incluindo o esquema e a autoridade (por exemplo, "http://www.example.com/resource"). Um URI relativo especifica o recurso em relação a um URI de base e não inclui o esquema e a autoridade (por exemplo, "/resource"). A classe `URI` permite criar e manipular ambos os tipos de URIs.

7. **Exemplos de Uso**:
   - A classe `URI` é comumente usada ao trabalhar com recursos na web, como na construção de URLs, na manipulação de links, na análise de solicitações HTTP, na criação de conexões HTTP e em outros cenários em que a identificação e manipulação de recursos são necessárias.

A classe `URI` é uma parte essencial para trabalhar com identificadores de recursos uniformes em aplicativos Java e é amplamente utilizada em desenvolvimento web, acesso a APIs, comunicações de rede e muito mais. Ela facilita a criação, manipulação e validação de URIs, tornando a interação com recursos na web mais fácil e segura.

# Classe ServletUriComponentsBuilder

A classe `ServletUriComponentsBuilder` faz parte do framework Spring Framework e é usada para construir URIs (Uniform Resource Identifiers) relacionados a servlets. Essa classe é frequentemente usada em aplicativos da web Spring para criar URIs que apontam para recursos da web, como controladores e endpoints.

`ServletUriComponentsBuilder` fornece métodos que facilitam a construção de URIs com base na solicitação atual, incluindo detalhes como o contexto do servlet, o host, a porta e outros componentes do URI. Isso é especialmente útil ao criar URIs dinamicamente para redirecionamentos, links em resposta a solicitações da web e outras situações em que você precisa construir URIs de maneira programática.

Alguns dos métodos comuns fornecidos por `ServletUriComponentsBuilder`:

1. `fromCurrentRequest()`: Cria um `ServletUriComponentsBuilder` com base na solicitação HTTP atual.

2. `fromCurrentContextPath()`: Cria um `ServletUriComponentsBuilder` com base no contexto do servlet atual (o contexto da web em que seu aplicativo está implantado).

3. `fromCurrentContextPath().path(String path)`: Permite adicionar um caminho personalizado ao contexto do servlet atual.

4. `fromCurrentContextPath().pathSegment(String... segments)`: Permite adicionar segmentos de caminho personalizados ao contexto do servlet atual.

5. `fromPath(String path)`: Cria um `ServletUriComponentsBuilder` com base em um caminho personalizado.

6. `fromServletMapping(ServletMapping servletMapping)`: Cria um `ServletUriComponentsBuilder` com base em um mapeamento de servlet específico.

7. `path(String path)`: Permite adicionar um caminho personalizado ao URI.

8. `pathSegment(String... segments)`: Permite adicionar segmentos de caminho personalizados ao URI.

9. `queryParam(String name, Object... values)`: Permite adicionar parâmetros de consulta ao URI.

10. `build()`: Gera o URI final com base nas configurações fornecidas.

Em resumo, o `ServletUriComponentsBuilder` é uma ferramenta útil para construir URIs dinâmicos em aplicativos da web Spring, especialmente ao criar links e redirecionamentos em resposta a solicitações da web. Ele ajuda a criar URIs de maneira programática com base em detalhes da solicitação atual e outras informações relacionadas ao servlet.

# Classe Page e Interface Pageable

A classe `Page` e a interface `Pageable` fazem parte do módulo Spring Data que lida com a paginação de resultados em consultas de banco de dados. Essas classes são amplamente usadas em aplicativos Spring para permitir a recuperação de grandes conjuntos de dados de forma paginada, o que é útil para exibir resultados em partes (páginas) em interfaces de usuário, como tabelas em páginas da web.

Explicação mais detalhada sobre essas classes e interfaces:

1. **Page (org.springframework.data.domain.Page)**:
   - A classe `Page` representa um conjunto de elementos que podem ser paginados. É uma parte do Spring Data e é frequentemente usada em consultas de banco de dados para retornar um subconjunto de resultados de uma consulta maior.
   - Um objeto `Page` contém os elementos (entidades) da página atual, informações sobre a página atual, como número da página, tamanho da página, número total de páginas e elementos totais, e outras informações úteis relacionadas à paginação.
   - Os objetos `Page` são retornados por métodos de repositório Spring Data que usam paginação, como `findAll(Pageable pageable)`.

2. **Pageable (org.springframework.data.domain.Pageable)**:
   - A interface `Pageable` é usada para definir as configurações de paginação, como o número da página, o tamanho da página e opções de ordenação.
   - Implementações típicas dessa interface incluem `PageRequest`, que permite configurar o número da página, o tamanho da página e as opções de ordenação.
   - O `Pageable` é passado como argumento para os métodos de repositório Spring Data que suportam paginação, permitindo que você defina as configurações de paginação para a consulta.

Exemplo simples de uso:

```java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

// Criar um objeto Pageable com número de página, tamanho da página e ordenação
Pageable pageable = PageRequest.of(0, 10, Sort.by("nome").ascending());

// Realizar uma consulta que retorna um Page (por exemplo, consulta de um repositório Spring Data)
Page<Produto> produtosPage = produtoRepository.findAll(pageable);

// Acessar informações sobre a página
int pageNumber = produtosPage.getNumber(); // Número da página atual
int pageSize = produtosPage.getSize();     // Tamanho da página
int totalPages = produtosPage.getTotalPages(); // Número total de páginas
long totalElements = produtosPage.getTotalElements(); // Número total de elementos
List<Produto> content = produtosPage.getContent(); // Elementos da página atual
```

No exemplo acima, criamos um objeto `Pageable` para definir a paginação, incluindo o número da página, o tamanho da página e a ordenação. Em seguida, usamos esse `Pageable` para realizar uma consulta que retorna um objeto `Page` contendo os resultados paginados e informações relacionadas à página.

O uso de `Page` e `Pageable` é comum em aplicativos Spring que precisam lidar com grandes conjuntos de dados e fornecer navegação paginada aos usuários. Eles facilitam a implementação de consultas de banco de dados eficientes e a apresentação de resultados de forma organizada.


# Controller - BibliotecaController

## Método HTTP POST criar Biblioteca - `criarBiblioteca()`
O script lida com a criação de uma entidade `Biblioteca`.

```java
public ResponseEntity<Biblioteca> criarBiblioteca(@Valid @RequestBody Biblioteca biblioteca) {

    // Cria a entidade Biblioteca no repositório
    Biblioteca criarBiblioteca = bibliotecaRepository.save(biblioteca);

    // Gera a URI para o novo recurso criado
    URI criarUri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(criarBiblioteca.getId())
        .toUri();

    // Retorna uma resposta com status "Created" (201) e a URI do novo recurso
    return ResponseEntity.created(localizacao).body(criarBiblioteca);
}
```

Explicação passo a passo:

1. `@Valid` e `@RequestBody`:
   - `@Valid` é uma anotação que indica que o objeto `biblioteca` passado no corpo da solicitação HTTP deve ser validado com base nas anotações de validação, como `@NotNull`, `@Size`, entre outras, que podem estar presentes nos campos da classe `Biblioteca`. Isso garante que os dados da solicitação sejam válidos.
   - `@RequestBody` é uma anotação que indica que o objeto `biblioteca` é obtido do corpo da solicitação HTTP.

2. `Biblioteca criarBiblioteca = bibliotecaRepository.save(biblioteca)`:
   - Este trecho de código salva a instância da classe `Biblioteca` no repositório de dados. Isso efetivamente persiste a nova `Biblioteca` no banco de dados.

3. `URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()...`:
   - `ServletUriComponentsBuilder.fromCurrentRequest()` cria um `ServletUriComponentsBuilder` com base na solicitação HTTP atual. Isso é útil para construir URIs que apontam para recursos relacionados ao contexto da solicitação atual.
   - `.path("/{id}")` adiciona o segmento de caminho `/{id}` à URI atual, indicando que o próximo valor será o ID do recurso criado. Isso é uma convenção comum para URIs de recursos que representam entidades individuais.
   - `.buildAndExpand(criarBiblioteca.getId())` substitui `/{id}` pelo ID real da entidade `Biblioteca` recém-criada. Isso completa a construção da URI.
   - `.toUri()` converte o `ServletUriComponentsBuilder` em uma instância de `URI`.

4. `return ResponseEntity.created(localizacao).body(criarBiblioteca)`:
   - `ResponseEntity.created(localizacao)` cria uma resposta HTTP com o status "Created" (código 201) e a URI do novo recurso no cabeçalho `Location`. Isso indica que a operação de criação foi bem-sucedida e fornece a URI para o novo recurso.
   - `.body(criarBiblioteca)` define o corpo da resposta como a entidade `Biblioteca` que foi criada. Isso permite que o cliente tenha acesso aos dados da entidade recém-criada.

No geral, esse script trata a criação de uma nova instância da classe `Biblioteca`, a persistência dela no banco de dados, e retorna uma resposta com o status "Created" contendo a URI do novo recurso e os dados da entidade recém-criada. Isso é uma prática comum ao implementar operações de criação em APIs RESTful.

## Método HTTP PUT alterar Biblioteca - `alterarBiblioteca()`

O script lida com uma solicitação HTTP do tipo PUT para atualizar uma entidade `Biblioteca`.

```java
@PutMapping("replace/{id}")
public ResponseEntity<Biblioteca> alterarBiblioteca(@Valid @PathVariable Integer id, @RequestBody Biblioteca biblioteca) {

    // Verifique se a Biblioteca com o ID especificado existe
    Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(id);

    if (!buscarBiblioteca.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Atualize a entidade com os dados fornecidos no corpo da solicitação
    biblioteca.setId(buscarBiblioteca.get().getId());
    bibliotecaRepository.save(biblioteca);

    // Responda com um status "No Content" (204) para indicar que a atualização foi bem-sucedida
    return ResponseEntity.noContent().build();
}
```

Explicação passo a passo:

1. `@PutMapping("replace/{id}")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo PUT com um caminho relativo que inclui `replace/{id}`. Isso significa que essa ação é acionada quando você faz uma solicitação PUT para um URL como `/replace/1`, onde `1` é o valor do ID da Biblioteca que deseja atualizar.

2. `@Valid` e `@PathVariable`:
   - `@Valid` é usado para indicar que o objeto `biblioteca` deve ser validado com base nas anotações de validação presentes na classe `Biblioteca`. Isso garante que os dados fornecidos na solicitação sejam válidos.
   - `@PathVariable` é usado para extrair o valor do parâmetro `{id}` da URL da solicitação e vinculá-lo à variável `id` no método.

3. `Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(id)`:
   - Isso busca uma entidade `Biblioteca` no repositório de dados com base no ID fornecido na URL. O uso de `Optional` permite verificar se a entidade foi encontrada ou não.

4. `if (!buscarBiblioteca.isPresent())`:
   - Isso verifica se a entidade `Biblioteca` com o ID especificado não foi encontrada. Se não foi encontrada, a resposta é construída com o status "Unprocessable Entity" (422), que é um código HTTP que indica uma solicitação malformada ou inválida.

5. `biblioteca.setId(buscarBiblioteca.get().getId())`:
   - O ID da entidade `biblioteca` é configurado com o mesmo ID da entidade encontrada no repositório. Isso é importante para garantir que a atualização seja aplicada à entidade correta.

6. `bibliotecaRepository.save(biblioteca)`:
   - Isso salva a entidade `biblioteca` atualizada no repositório de dados. A atualização dos campos da entidade é baseada nos dados fornecidos no corpo da solicitação.

7. `return ResponseEntity.noContent().build()`:
   - Após a atualização bem-sucedida, uma resposta HTTP com status "No Content" (204) é retornada. Isso indica que a solicitação de atualização foi processada com sucesso e que não há conteúdo adicional a ser retornado na resposta.

Esse script trata a atualização de uma entidade `Biblioteca` com base no ID fornecido na URL da solicitação PUT. Ele verifica se a entidade com o ID especificado existe, atualiza seus campos com os dados fornecidos no corpo da solicitação e retorna um status "No Content" para indicar que a atualização foi concluída com sucesso.

## Método HTTP DELETE deletar Biblioteca - `deletarBiblioteca()`
O script lida com uma solicitação HTTP do tipo DELETE para excluir uma entidade `Biblioteca`.

```java
@DeleteMapping("/delete/{id}")
public ResponseEntity<Biblioteca> deletarBiblioteca(@PathVariable Integer id) {

    // Verifique se a Biblioteca com o ID especificado existe
    Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(id);

    if (!buscarBiblioteca.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Exclua a entidade encontrada
    bibliotecaRepository.delete(buscarBiblioteca.get());

    // Responda com um status "No Content" (204) para indicar que a exclusão foi bem-sucedida
    return ResponseEntity.noContent().build();
}
```

Explicação passo a passo:

1. `@DeleteMapping("/delete/{id}")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo DELETE com um caminho relativo que inclui `/delete/{id}`. Isso significa que essa ação é acionada quando você faz uma solicitação DELETE para um URL como `/delete/1`, onde `1` é o valor do ID da Biblioteca que deseja excluir.

2. `@PathVariable`:
   - `@PathVariable` é usado para extrair o valor do parâmetro `{id}` da URL da solicitação e vinculá-lo à variável `id` no método.

3. `Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(id)`:
   - Isso busca uma entidade `Biblioteca` no repositório de dados com base no ID fornecido na URL. O uso de `Optional` permite verificar se a entidade foi encontrada ou não.

4. `if (!buscarBiblioteca.isPresent())`:
   - Isso verifica se a entidade `Biblioteca` com o ID especificado não foi encontrada. Se não foi encontrada, a resposta é construída com o status "Unprocessable Entity" (422), que é um código HTTP que indica que a solicitação é inválida ou que a entidade não existe.

5. `bibliotecaRepository.delete(buscarBiblioteca.get())`:
   - Isso exclui a entidade `Biblioteca` encontrada no repositório de dados. A entidade a ser excluída é obtida do `Optional` com `buscarBiblioteca.get()`.

6. `return ResponseEntity.noContent().build()`:
   - Após a exclusão bem-sucedida, uma resposta HTTP com status "No Content" (204) é retornada. Isso indica que a solicitação de exclusão foi processada com sucesso e que não há conteúdo adicional a ser retornado na resposta.

Esse script trata a exclusão de uma entidade `Biblioteca` com base no ID fornecido na URL da solicitação DELETE. Ele verifica se a entidade com o ID especificado existe, exclui a entidade e retorna um status "No Content" para indicar que a exclusão foi bem-sucedida.

## Método HTTP GET buscar Biblioteca por id - `buscarBibliotecaPorId()`

O script lida com uma solicitação HTTP do tipo GET para buscar uma entidade `Biblioteca` com base em seu ID.

```java
@GetMapping("/search/{id}")
public ResponseEntity<Biblioteca> buscarBibliotecaPorId(@PathVariable Integer id) {

    // Verifique se a Biblioteca com o ID especificado existe
    Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(id);

    if (!buscarBiblioteca.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Retorna a entidade encontrada com status "OK" (200)
    return ResponseEntity.ok(buscarBiblioteca.get());
}
```

Explicação passo a passo:

1. `@GetMapping("/search/{id}")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo GET com um caminho relativo que inclui `/search/{id}`. Isso significa que essa ação é acionada quando você faz uma solicitação GET para um URL como `/search/1`, onde `1` é o valor do ID da Biblioteca que deseja buscar.

2. `@PathVariable`:
   - `@PathVariable` é usado para extrair o valor do parâmetro `{id}` da URL da solicitação e vinculá-lo à variável `id` no método.

3. `Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(id)`:
   - Isso busca uma entidade `Biblioteca` no repositório de dados com base no ID fornecido na URL. O uso de `Optional` permite verificar se a entidade foi encontrada ou não.

4. `if (!buscarBiblioteca.isPresent())`:
   - Isso verifica se a entidade `Biblioteca` com o ID especificado não foi encontrada. Se não foi encontrada, a resposta é construída com o status "Unprocessable Entity" (422), que é um código HTTP que indica que a solicitação é inválida ou que a entidade não existe.

5. `return ResponseEntity.ok(buscarBiblioteca.get())`:
   - Se a entidade foi encontrada com sucesso, a resposta é construída com status "OK" (200) e o corpo da resposta é a própria entidade `Biblioteca` encontrada. Isso é feito com `ResponseEntity.ok(buscarBiblioteca.get())`, onde `buscarBiblioteca.get()` é a entidade recuperada do `Optional`.

Esse script trata a busca de uma entidade `Biblioteca` com base no ID fornecido na URL da solicitação GET. Se a entidade com o ID especificado for encontrada, ela é retornada com status "OK" (200). Se a entidade não for encontrada, uma resposta com status "Unprocessable Entity" (422) é retornada para indicar que a solicitação não foi bem-sucedida.


## Método HTTP GET buscar todos da Biblioteca - `buscarTodosBiblioteca()`
O script lida com uma solicitação HTTP do tipo GET para buscar todos os registros de entidades `Biblioteca` de forma paginada. 

```java
@GetMapping("/all")
public ResponseEntity<Page<Biblioteca>> buscarTodosBiblioteca(Pageable pageable) {
    return ResponseEntity.ok(bibliotecaRepository.findAll(pageable));
}
```

Explicação passo a passo:

1. `@GetMapping("/all")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo GET com um caminho relativo que inclui `/all`. Isso significa que essa ação é acionada quando você faz uma solicitação GET para o URL `/all`.

2. `Pageable pageable`:
   - O parâmetro `pageable` é do tipo `Pageable` e é injetado automaticamente pelo Spring Framework. Ele é usado para configurar as opções de paginação da consulta. Você pode especificar o número da página, o tamanho da página e as opções de ordenação na solicitação.

3. `bibliotecaRepository.findAll(pageable)`:
   - Aqui, o método `findAll` do repositório `bibliotecaRepository` é chamado e passa o objeto `pageable` como argumento. Esse método é fornecido pelo Spring Data e é usado para recuperar todos os registros da entidade `Biblioteca` de acordo com as configurações de paginação definidas em `pageable`.

4. `ResponseEntity.ok(...)`:
   - O método `ResponseEntity.ok(...)` cria uma resposta HTTP com o status "OK" (200). Neste caso, ele está sendo usado para encapsular o resultado da consulta ao banco de dados.

5. `return ResponseEntity.ok(bibliotecaRepository.findAll(pageable))`:
   - A resposta HTTP com status "OK" é retornada, e o corpo da resposta contém o resultado da consulta, que é um objeto do tipo `Page<Biblioteca>`. Esse objeto contém os registros da página atual, bem como informações sobre a paginação, como o número da página, o tamanho da página, o número total de páginas e o número total de elementos.

Em resumo, este script trata uma solicitação GET que busca todos os registros da entidade `Biblioteca` de forma paginada. O objeto `Pageable` é usado para configurar a paginação e as informações da página são incluídas na resposta. Isso permite ao cliente da API navegar pelos resultados em partes, em vez de receber todos os registros de uma vez.

# Controller - LivroController

## Método HTTP POST criar Livro - `criarLivro()`

O script lida com uma solicitação HTTP do tipo POST para criar um novo registro de livro (`Livro`). 

```java
@PostMapping("/create")
public ResponseEntity<Livro> criarLivro(@Valid @RequestBody Livro livro) {

    // Verifique se a Biblioteca associada ao livro existe
    Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(livro.getBiblioteca().getId());

    if (!buscarBiblioteca.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Defina a Biblioteca associada ao livro
    livro.setBiblioteca(buscarBiblioteca.get());

    // Salve o novo livro no banco de dados
    Livro criarLivro = livroRepository.save(livro);

    // Crie a URI para o novo livro
    URI criarUri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(criarLivro.getId())
            .toUri();

    // Retorne uma resposta com status "Created" (201) e o novo livro
    return ResponseEntity.created(criarUri).body(criarLivro);
}
```

Explicação passo a passo:

1. `@PostMapping("/create")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo POST com um caminho relativo que inclui `/create`. Isso significa que essa ação é acionada quando você faz uma solicitação POST para o URL `/create`.

2. `public ResponseEntity<Livro> criarLivro(@Valid @RequestBody Livro livro)`:
   - Este é o método que lida com a solicitação POST. Ele recebe um objeto `Livro` no corpo da solicitação (usando a anotação `@RequestBody`) e valida o objeto usando a anotação `@Valid`. O método retorna uma resposta do tipo `ResponseEntity` que encapsula um objeto `Livro`.

3. `Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(livro.getBiblioteca().getId())`:
   - Aqui, é feita uma busca no repositório de `Biblioteca` para verificar se a `Biblioteca` associada ao livro existe. Isso é feito com base no ID da `Biblioteca` fornecido no livro.

4. `if (!buscarBiblioteca.isPresent())`:
   - Isso verifica se a `Biblioteca` associada ao livro não foi encontrada. Se não foi encontrada, uma resposta com status "Unprocessable Entity" (422) é retornada para indicar que a solicitação é inválida.

5. `livro.setBiblioteca(buscarBiblioteca.get())`:
   - Se a `Biblioteca` foi encontrada, ela é definida no objeto `livro` para estabelecer a associação entre o livro e a biblioteca.

6. `Livro criarLivro = livroRepository.save(livro)`:
   - O novo livro é salvo no banco de dados usando o método `save` do repositório de `Livro`. O livro agora tem uma identificação única (ID) atribuída pelo banco de dados.

7. `URI criarUri = ServletUriComponentsBuilder.fromCurrentRequest()...`:
   - Aqui, uma URI é construída para o novo livro criado. Ela é criada com base na solicitação atual e inclui o ID do livro.

8. `return ResponseEntity.created(criarUri).body(criarLivro)`:
   - Por fim, uma resposta com status "Created" (201) é retornada, indicando que o livro foi criado com sucesso. A resposta também inclui a URI para acessar o novo livro e o próprio objeto `Livro` no corpo da resposta.

Em resumo, este script cria um novo registro de livro associado a uma biblioteca no banco de dados. Ele verifica se a biblioteca associada ao livro existe, estabelece a associação entre o livro e a biblioteca, salva o livro no banco de dados, cria uma URI para o novo livro e retorna uma resposta com status "Created" contendo o novo livro criado.

## Método HTTP PUT alterar Livro - `alterarLivro()`

O script lida com uma solicitação HTTP do tipo PUT para alterar um registro existente de livro (`Livro`). 

```java
@PutMapping("/replace/{id}")
public ResponseEntity<Livro> alterarLivro(@Valid @PathVariable Integer id, @RequestBody Livro livro) {
 
    // Verifique se a Biblioteca associada ao livro existe
    Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(livro.getBiblioteca().getId());

    if (!buscarBiblioteca.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Verifique se o livro com o ID especificado existe
    Optional<Livro> buscarLivro = livroRepository.findById(id);

    if (!buscarLivro.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Configure a Biblioteca associada ao livro e ID do livro
    livro.setBiblioteca(buscarBiblioteca.get());
    livro.setId(buscarLivro.get().getId());

    // Salve as alterações no livro
    livroRepository.save(livro);

    // Retorne uma resposta com status "No Content" (204)
    return ResponseEntity.noContent().build();
}
```

Explicação passo a passo:

1. `@PutMapping("/replace/{id}")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo PUT com um caminho relativo que inclui `/replace/{id}`. Isso significa que essa ação é acionada quando você faz uma solicitação PUT para um URL como `/replace/1`, onde `1` é o valor do ID do livro que deseja alterar.

2. `public ResponseEntity<Livro> alterarLivro(@Valid @PathVariable Integer id, @RequestBody Livro livro)`:
   - Este é o método que lida com a solicitação PUT. Ele recebe o ID do livro a ser alterado como parte do caminho da URL (usando a anotação `@PathVariable`) e recebe o objeto `Livro` com as alterações desejadas no corpo da solicitação (usando a anotação `@RequestBody`). O método retorna uma resposta do tipo `ResponseEntity` que encapsula um objeto `Livro`.

3. `Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(livro.getBiblioteca().getId())`:
   - Aqui, é feita uma busca no repositório de `Biblioteca` para verificar se a `Biblioteca` associada ao livro existe com base no ID fornecido no livro.

4. `if (!buscarBiblioteca.isPresent())`:
   - Isso verifica se a `Biblioteca` associada ao livro não foi encontrada. Se não foi encontrada, uma resposta com status "Unprocessable Entity" (422) é retornada para indicar que a solicitação é inválida.

5. `Optional<Livro> buscarLivro = livroRepository.findById(id)`:
   - Em seguida, é feita uma busca no repositório de `Livro` para verificar se o livro com o ID especificado existe.

6. `if (!buscarLivro.isPresent())`:
   - Isso verifica se o livro com o ID especificado não foi encontrado. Se não foi encontrado, uma resposta com status "Unprocessable Entity" (422) é retornada para indicar que a solicitação é inválida.

7. `livro.setBiblioteca(buscarBiblioteca.get())`:
   - Se a `Biblioteca` e o livro foram encontrados, a `Biblioteca` é configurada no objeto `livro` para estabelecer a associação entre o livro e a biblioteca. Além disso, o ID do livro é configurado com base no ID especificado na URL.

8. `livroRepository.save(livro)`:
   - As alterações no livro são salvas no banco de dados usando o método `save` do repositório de `Livro`.

9. `return ResponseEntity.noContent().build()`:
   - Por fim, uma resposta com status "No Content" (204) é retornada, indicando que a operação de atualização foi bem-sucedida, mas não há conteúdo a ser retornado no corpo da resposta.

Em resumo, este script trata uma solicitação PUT que altera um registro de livro existente no banco de dados. Ele verifica se a biblioteca associada ao livro e o próprio livro existem, configura a associação entre eles, salva as alterações e retorna uma resposta com status "No Content".


## Método HTTP DELETE deletar Livro - `deletarLivro()`

O script lida com uma solicitação HTTP do tipo DELETE para excluir um registro de livro (`Livro`). 

```java
@DeleteMapping("/delete/{id}")
public ResponseEntity<Livro> deletarLivro(@PathVariable Integer id) {

    // Verifique se o livro com o ID especificado existe
    Optional<Livro> buscarLivro = livroRepository.findById(id);

    if (!buscarLivro.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Exclua o livro
    livroRepository.delete(buscarLivro.get());

    // Retorne uma resposta com status "No Content" (204)
    return ResponseEntity.noContent().build();
}
```

Explicação passo a passo:

1. `@DeleteMapping("/delete/{id")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo DELETE com um caminho relativo que inclui `/delete/{id}`. Isso significa que essa ação é acionada quando você faz uma solicitação DELETE para um URL como `/delete/1`, onde `1` é o valor do ID do livro que deseja excluir.

2. `public ResponseEntity<Livro> deletarLivro(@PathVariable Integer id)`:
   - Este é o método que lida com a solicitação DELETE. Ele recebe o ID do livro a ser excluído como parte do caminho da URL (usando a anotação `@PathVariable`). O método retorna uma resposta do tipo `ResponseEntity` que encapsula um objeto `Livro`.

3. `Optional<Livro> buscarLivro = livroRepository.findById(id)`:
   - Aqui, é feita uma busca no repositório de `Livro` para verificar se o livro com o ID especificado existe.

4. `if (!buscarLivro.isPresent())`:
   - Isso verifica se o livro com o ID especificado não foi encontrado. Se não foi encontrado, uma resposta com status "Unprocessable Entity" (422) é retornada para indicar que a solicitação é inválida.

5. `livroRepository.delete(buscarLivro.get())`:
   - Se o livro foi encontrado, o livro é excluído do banco de dados usando o método `delete` do repositório de `Livro`. O livro a ser excluído é obtido usando `buscarLivro.get()`.

6. `return ResponseEntity.noContent().build()`:
   - Por fim, uma resposta com status "No Content" (204) é retornada, indicando que o livro foi excluído com sucesso. Não há conteúdo a ser retornado no corpo da resposta.

Em resumo, este script trata uma solicitação DELETE que exclui um registro de livro existente no banco de dados. Ele verifica se o livro com o ID especificado existe, exclui o livro e retorna uma resposta com status "No Content" para indicar que a operação de exclusão foi bem-sucedida.


## Método HTTP GET buscar Livro por id - `buscarLivroPorId()`

O script lida com uma solicitação HTTP do tipo GET para buscar um único registro de livro (`Livro`) com base no seu ID. 

```java
@GetMapping("/search/{id}")
public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Integer id) {

    // Verifique se o livro com o ID especificado existe
    Optional<Livro> buscarLivro = livroRepository.findById(id);

    if (!buscarLivro.isPresent()) {
        return ResponseEntity.unprocessableEntity().build();
    }

    // Retorne o livro encontrado
    return ResponseEntity.ok(buscarLivro.get());
}
```

Explicação passo a passo:

1. `@GetMapping("/search/{id}")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo GET com um caminho relativo que inclui `/search/{id}`. Isso significa que essa ação é acionada quando você faz uma solicitação GET para um URL como `/search/1`, onde `1` é o valor do ID do livro que deseja buscar.

2. `public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Integer id)`:
   - Este é o método que lida com a solicitação GET. Ele recebe o ID do livro a ser buscado como parte do caminho da URL (usando a anotação `@PathVariable`). O método retorna uma resposta do tipo `ResponseEntity` que encapsula um objeto `Livro`.

3. `Optional<Livro> buscarLivro = livroRepository.findById(id)`:
   - Aqui, é feita uma busca no repositório de `Livro` para verificar se o livro com o ID especificado existe.

4. `if (!buscarLivro.isPresent())`:
   - Isso verifica se o livro com o ID especificado não foi encontrado. Se não foi encontrado, uma resposta com status "Unprocessable Entity" (422) é retornada para indicar que a solicitação é inválida.

5. `return ResponseEntity.ok(buscarLivro.get())`:
   - Se o livro foi encontrado, uma resposta com status "OK" (200) é retornada, e o corpo da resposta contém o livro encontrado, que é obtido usando `buscarLivro.get()`.

Em resumo, este script trata uma solicitação GET que busca um registro de livro com base no ID fornecido na URL. Se o livro é encontrado, ele é retornado na resposta com status "OK". Se o livro não é encontrado, uma resposta com status "Unprocessable Entity" é retornada para indicar que o livro não existe.

## Método HTTP GET buscar todos os Livros - `buscarTodosLivros()`

O script lida com uma solicitação HTTP do tipo GET para buscar todos os registros de livros (`Livro`) de forma paginada. 

```java
@GetMapping("/all")
public ResponseEntity<Page<Livro>> buscarTodosLivros(Pageable pageable) {

    // Consulta o repositório de livros para recuperar os registros paginados
    return ResponseEntity.ok(livroRepository.findAll(pageable));
}
```

Explicação passo a passo:

1. `@GetMapping("/all")`:
   - Esta é uma anotação que mapeia essa ação do controlador para solicitações HTTP do tipo GET com um caminho relativo que inclui `/all`. Isso significa que essa ação é acionada quando você faz uma solicitação GET para o URL `/all`.

2. `public ResponseEntity<Page<Livro>> buscarTodosLivros(Pageable pageable)`:
   - Este é o método que lida com a solicitação GET. Ele recebe um objeto `Pageable` no parâmetro `pageable`. O `Pageable` é usado para configurar as opções de paginação da consulta. O método retorna uma resposta do tipo `ResponseEntity` que encapsula um objeto `Page<Livro>`.

3. `return ResponseEntity.ok(livroRepository.findAll(pageable))`:
   - Dentro do método, o repositório de `Livro` (`livroRepository`) é consultado usando o método `findAll(pageable)`. Este método é fornecido pelo Spring Data e é usado para recuperar todos os registros de `Livro` de acordo com as configurações de paginação definidas em `pageable`.

4. `ResponseEntity.ok(...)`:
   - O método `ResponseEntity.ok(...)` cria uma resposta HTTP com o status "OK" (200). Neste caso, ele está sendo usado para encapsular o resultado da consulta ao banco de dados.

5. `return ResponseEntity.ok(livroRepository.findAll(pageable))`:
   - A resposta HTTP com status "OK" é retornada, e o corpo da resposta contém o resultado da consulta, que é um objeto do tipo `Page<Livro>`. Este objeto contém os registros da página atual, bem como informações sobre a paginação, como o número da página, o tamanho da página, o número total de páginas e o número total de elementos.

Em resumo, este script trata uma solicitação GET que busca todos os registros de livros de forma paginada. O objeto `Pageable` é usado para configurar a paginação, e as informações da página são incluídas na resposta. Isso permite ao cliente da API navegar pelos resultados em partes, em vez de receber todos os registros de uma vez.