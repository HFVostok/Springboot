package webapp.escola_completo.Repository;
import org.springframework.data.repository.CrudRepository;
import webapp.escola_completo.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    // Você pode adicionar métodos de consulta personalizados, se necessário
}
