package app_escola.crud_escola.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Administrador implements Serializable{
    //atributos (colunas da Tabela)
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    //métodos
    public String setCpf(){
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
    

}
