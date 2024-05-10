package webapp.escola_completo.Model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import webapp.escola_completo.Repository.AdministradorRepository;
import webapp.escola_completo.Repository.AlunoRepository;
import webapp.escola_completo.Repository.ProfessorRepository;

@Entity
public class Administrador implements Serializable{
    //atributos
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    //métodos
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    

// Em algum serviço
public class UserService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public String verificarTipoUsuario(String cpf, String senha) {
        if (administradorRepository.findByCpf(cpf) != null) {
            return "ADM";
        } else if (alunoRepository.findByCpfAndSenha(cpf, senha) != null) {
            return "ALUNO";
        } else if (professorRepository.findByCpfAndSenha(cpf, senha) != null) {
            return "PROFESSOR";
        } else {
            return "INVALIDO";
        }
    }
}



}
