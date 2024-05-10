package webapp.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;
import webapp.escola_completo.Model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String> {

    Object findByCpfAndSenha(String cpf, String senha);
    // Você pode adicionar métodos de consulta personalizados, se necessário
}
