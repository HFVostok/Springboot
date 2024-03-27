package app_escola.crud_escola.Repository;

import org.springframework.data.repository.CrudRepository;

import app_escola.crud_escola.Model.VerificaCadastroAdm;


public interface VerificaCadastroAdmrepository extends CrudRepository<VerificaCadastroAdm, String>{

    VerificaCadastroAdm findByCpf (String cpf);
    
    VerificaCadastroAdm findByNome (String nome);
    
}
