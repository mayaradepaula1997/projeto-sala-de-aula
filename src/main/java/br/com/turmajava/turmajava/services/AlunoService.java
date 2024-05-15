package br.com.turmajava.turmajava.services;

import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service //@Service para indicar que a classe será de serviços para o banco de dados
public class AlunoService {

    @Autowired //@Autowired para fazermos uma injeção de dependência
    private AlunoRepository alunoRepository;

    public List <Aluno> findAll(){ //serviço para listar todos os alunos
        return alunoRepository.findAll(); // findAll() é uma função que o nosso repository

    }

    public Aluno findById (Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.get();
    }

    public void deleteAllAlunos(){
        alunoRepository.deleteAll();
    }

    public void deleteAlunoById(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno insert (Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno (Aluno updateAluno) { //verificar se usuario existe
        Aluno existingAluno = alunoRepository.findById(updateAluno.getId()).orElse(null);
        if (existingAluno == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        existingAluno.setMatricula(updateAluno.getMatricula());
        existingAluno.setNome(updateAluno.getNome());
        existingAluno.setIdade(updateAluno.getIdade());
        existingAluno.setDataNascimento(updateAluno.getDataNascimento());
        existingAluno.setSexo(updateAluno.getSexo());
        existingAluno.setSalaDeAula(updateAluno.getSalaDeAula());

        return alunoRepository.save(existingAluno);

    }





}
