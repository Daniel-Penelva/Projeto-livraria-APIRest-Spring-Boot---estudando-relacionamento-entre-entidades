package com.apirest.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.livraria.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
    
}
