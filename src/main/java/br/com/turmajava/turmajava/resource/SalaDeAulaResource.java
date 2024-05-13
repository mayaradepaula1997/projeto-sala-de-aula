package br.com.turmajava.turmajava.resource;


import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.entities.SalaDeAula;
import br.com.turmajava.turmajava.repositories.SalaDeAulaRepository;
import br.com.turmajava.turmajava.services.AlunoService;
import br.com.turmajava.turmajava.services.SalaDeAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //sistema entenda que ali será uma classe que controlará as requisições
@RequestMapping(value = "/sala")
public class SalaDeAulaResource {

   @Autowired
   private SalaDeAulaService salaDeAulaService; //injeção de dependência da nossa classe de serviço


    public ResponseEntity<List<SalaDeAula>> findAll() {
        List<SalaDeAula> list = salaDeAulaService.findAll();
        return ResponseEntity.ok().body(list);
    }



}

