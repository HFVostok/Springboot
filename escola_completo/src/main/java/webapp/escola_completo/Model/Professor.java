package webapp.escola_completo.Model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import webapp.escola_completo.Repository.AdministradorRepository;
import webapp.escola_completo.Repository.AlunoRepository;
import webapp.escola_completo.Repository.ProfessorRepository;

@Entity
public class Professor implements Serializable {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String idade;
    private String etnia;
    private String materiaLecionada;

    // Construtores (vazio e com todos os atributos)
    public Professor() {}

    public Professor(String cpf, String nome, String email, String senha, String idade, String etnia,
                     String materiaLecionada) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.etnia = etnia;
        this.materiaLecionada = materiaLecionada;
    }

    // Getters e Setters
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getMateriaLecionada() {
        return materiaLecionada;
    }

    public void setMateriaLecionada(String materiaLecionada) {
        this.materiaLecionada = materiaLecionada;
    }





}
