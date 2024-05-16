package br.com.diogotb.loja_livros.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.diogotb.loja_livros.Model.Livro;

public interface LivrosRepository extends CrudRepository<Livro,Integer>{
    
}
