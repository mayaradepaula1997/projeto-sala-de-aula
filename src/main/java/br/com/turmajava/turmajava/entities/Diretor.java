package br.com.turmajava.turmajava.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "td_diretores")
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean superUsuario;

    public Diretor(){

    }

    public Diretor(Long id, String nome, Boolean superUsuario) {
        this.id = id;
        this.nome = nome;
        this.superUsuario = superUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuperUsuario() {
        return superUsuario;
    }

    public void setSuperUsuario(Boolean superUsuario) {
        this.superUsuario = superUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diretor diretor = (Diretor) o;
        return Objects.equals(id, diretor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
