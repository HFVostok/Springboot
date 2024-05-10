package webapp.escola_completo.Model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import webapp.escola_completo.Repository.AdministradorRepository;
import webapp.escola_completo.Repository.AlunoRepository;
import webapp.escola_completo.Repository.ProfessorRepository;

@Entity
public class VerificaCadastroAdm implements Serializable {
    // atributos
    @Id
    private String cpf;
    private String nome;

    // métodos
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
