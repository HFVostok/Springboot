package webapp.escola_completo.Repository;

import org.springframework.data.repository.CrudRepository;
import webapp.escola_completo.Model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String> {
    // Você pode adicionar métodos de consulta personalizados, se necessário
}
