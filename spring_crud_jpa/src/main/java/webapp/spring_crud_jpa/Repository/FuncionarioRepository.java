package webapp.spring_crud_jpa.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webapp.spring_crud_jpa.Model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    // criado para a busca Funcionario por id ou chave primária
    Funcionario findById(long id);

    // criado para a busca Funcionario por nome
    Funcionario findByNome(String nome);

    // Busca para vários nomes Funcionários
    @Query(value = "select u from Funcionario u where u.nome like %?1%")
    List<Funcionario> findByNomes(String nome);
}