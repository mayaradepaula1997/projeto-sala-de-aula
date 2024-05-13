package br.com.turmajava.turmajava.entities;

import jakarta.persistence.*;
import org.apache.juli.logging.Log;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String nome;
    private Integer idade;
    private LocalDate dataNascimento;
    private String sexo;

    private SalaDeAula salaDeAula;

    public Aluno(){

    }

    public Aluno(Long id, String matricula, String nome, Integer idade, LocalDate dataNascimento, String sexo, SalaDeAula salaDeAula) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.salaDeAula = salaDeAula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public SalaDeAula getSalaDeAula() {
        return salaDeAula;
    }

    public void setSalaDeAula(SalaDeAula salaDeAula) {
        this.salaDeAula = salaDeAula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }
}

