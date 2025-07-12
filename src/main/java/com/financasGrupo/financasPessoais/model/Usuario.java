package com.financasGrupo.financasPessoais.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Transacao> transacoes;

    public Usuario() {
    }

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId(){
      return id;
    }

    public String getUsername(){
      return username;
    }
    
    public String getEmail(){
      return email;
    }

    public String getPassword(){
      return password;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setUsername(String username){
      this.username = username;
    }
    
    public void setEmail(String email){
      this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
