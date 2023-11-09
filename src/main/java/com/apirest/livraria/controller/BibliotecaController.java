package com.apirest.livraria.controller;

import java.net.URI;
import java.util.Optional;

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
import com.apirest.livraria.repository.BibliotecaRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/biblioteca")
@AllArgsConstructor
public class BibliotecaController {

    
    private BibliotecaRepository bibliotecaRepository;

    // http://localhost:8080/api/biblioteca/create
    @PostMapping("/create")
    public ResponseEntity<Biblioteca> criarBiblioteca(@Valid @RequestBody Biblioteca biblioteca) {

        // Cria a entidade Biblioteca no repositório
        Biblioteca criarBiblioteca = bibliotecaRepository.save(biblioteca);

        // Gera a URI para o novo recurso criado
        URI criarUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(criarBiblioteca.getId())
                .toUri();

        // Retorna uma resposta com status "Created" (201) e a URI do novo recurso
        return ResponseEntity.created(criarUri).body(criarBiblioteca);
    }

    // http://localhost:8080/api/biblioteca/replace/{id}
    @PutMapping("/replace/{id}")
    public ResponseEntity<Biblioteca> alterarBiblioteca(@Valid @PathVariable Integer id,
            @RequestBody Biblioteca biblioteca) {

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

    // http://localhost:8080/api/biblioteca/delete/{id}
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

    // http://localhost:8080/api/biblioteca/search/{id}
    @GetMapping("/search/{id}")
    public ResponseEntity<Biblioteca> buscarBibliotecaPorId(@PathVariable Integer id) {
        Optional<Biblioteca> buscarBiblioteca = bibliotecaRepository.findById(id);

        if (!buscarBiblioteca.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(buscarBiblioteca.get());
    }

    // http://localhost:8080/api/biblioteca/all
    @GetMapping("/all")
    public ResponseEntity<Page<Biblioteca>> buscarTodosBiblioteca(Pageable pageable){

        // Consulta o repositório de bibliotecas para recuperar os registros paginados
        return ResponseEntity.ok(bibliotecaRepository.findAll(pageable));
    }

}
