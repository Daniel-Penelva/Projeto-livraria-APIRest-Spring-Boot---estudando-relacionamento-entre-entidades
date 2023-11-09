package com.apirest.livraria.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "biblioteca")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome;

    // Uma biblioteca contém vários livros
    @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
    private Set<Livro> livros = new HashSet<>();

    
    public void setLivros(Set<Livro> livros) {
        this.livros = livros;

        for (Livro livro : livros) {
            livro.setBiblioteca(this);
        }
    }

}
