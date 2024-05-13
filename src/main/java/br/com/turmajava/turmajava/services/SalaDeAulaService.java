package br.com.turmajava.turmajava.services;

import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.entities.SalaDeAula;
import br.com.turmajava.turmajava.repositories.AlunoRepository;
import br.com.turmajava.turmajava.repositories.SalaDeAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service //@Service para indicar que a classe será de serviços para o banco de dados
public class SalaDeAulaService {

    @Autowired //@Autowired para fazermos uma injeção de dependência
    private SalaDeAulaRepository salaDeAulaRepository;

    public List <SalaDeAula> findAll(){ //serviço para listar todos os alunos
        return salaDeAulaRepository.findAll(); // findAll() é uma função que o nosso repository


    }
}
