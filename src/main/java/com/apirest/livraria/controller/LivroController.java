package com.apirest.livraria.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apirest.livraria.entities.Biblioteca;
import com.apirest.livraria.entities.Livro;
import com.apirest.livraria.repository.BibliotecaRepository;
import com.apirest.livraria.repository.LivroRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/livro")
@AllArgsConstructor
public class LivroController {

    
    private LivroRepository livroRepository;

    private BibliotecaRepository bibliotecaRepository;

    // http://localhost:8080/api/livro/create
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

    // http://localhost:8080/api/livro/replace/{id}
    @PutMapping("/replace/{id}")
    public ResponseEntity<Livro> alterarLivro(@Valid @PathVariable Integer id,
            @RequestBody Livro livro) {

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

    // http://localhost:8080/api/livro/delete/{id}
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


    // http://localhost:8080/api/livro/search/{id}
    @GetMapping("/search/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Integer id) {
        
        Optional<Livro> buscarLivro = livroRepository.findById(id);

        if (!buscarLivro.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(buscarLivro.get());
    }


    // http://localhost:8080/api/livro/all
    @GetMapping("/all")
    public ResponseEntity<Page<Livro>> buscarTodosLivros(Pageable pageable){

        // Consulta o repositório de livros para recuperar os registros paginados
        return ResponseEntity.ok(livroRepository.findAll(pageable));
    }


}
