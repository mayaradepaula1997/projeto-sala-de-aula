package br.com.turmajava.turmajava.services;

import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.entities.SalaDeAula;
import br.com.turmajava.turmajava.repositories.SalaDeAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service //@Service para indicar que a classe será de serviços para o banco de dados
public class SalaDeAulaService {

    @Autowired //@Autowired para fazermos uma injeção de dependência
    private SalaDeAulaRepository salaDeAulaRepository;

    public List <SalaDeAula> findAll(){ //serviço para listar todos os alunos
        return salaDeAulaRepository.findAll(); // findAll() é uma função que o nosso repository
    }


    public SalaDeAula findById (Long id){
        Optional<SalaDeAula>salaDeAula = salaDeAulaRepository.findById(id);
        return salaDeAula.get();
    }


    public void deleteSalaDeAulaById(Long id){
        salaDeAulaRepository.deleteById(id);
    }


    public SalaDeAula insert (SalaDeAula salaDeAula) {
        return salaDeAulaRepository.save(salaDeAula);

    }


    public SalaDeAula updateSalaDeAula (SalaDeAula updateSalaDeAula) { //verificar se usuario existe
        SalaDeAula existingSalaDeAula = salaDeAulaRepository.findById(updateSalaDeAula.getId()).orElse(null);
        if (existingSalaDeAula == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        existingSalaDeAula.setNumero(updateSalaDeAula.getNumero());
        existingSalaDeAula.setProfessor(updateSalaDeAula.getProfessor());
        existingSalaDeAula.setHorario(updateSalaDeAula.getHorario());
        existingSalaDeAula.setAlunos(updateSalaDeAula.getAlunos());

        return salaDeAulaRepository.save(existingSalaDeAula);

    }
}
