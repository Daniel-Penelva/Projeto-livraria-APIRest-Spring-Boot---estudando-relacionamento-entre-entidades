package com.apirest.livraria.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livros", uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome;

    //Muitos livros pode pertencer a uma biblioteca.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="biblioteca_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Biblioteca biblioteca;
    
}
