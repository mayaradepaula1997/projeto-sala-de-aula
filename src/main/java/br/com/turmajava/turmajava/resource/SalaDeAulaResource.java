package br.com.turmajava.turmajava.resource;


import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.entities.SalaDeAula;
import br.com.turmajava.turmajava.exception.ResourceNotFoundException;
import br.com.turmajava.turmajava.repositories.AlunoRepository;
import br.com.turmajava.turmajava.services.SalaDeAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController //sistema entenda que ali será uma classe que controlará as requisições
@RequestMapping(value = "/sala")
public class SalaDeAulaResource {

   @Autowired
   private SalaDeAulaService salaDeAulaService; //injeção de dependência da nossa classe de serviço

    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping
    public ResponseEntity<List<SalaDeAula>> findAll() {
        List<SalaDeAula> list = salaDeAulaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SalaDeAula> findById (@PathVariable Long id){
        SalaDeAula salaDeAula = salaDeAulaService.findById(id);
        return ResponseEntity.ok(salaDeAula);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllSalaDeAula(){
        salaDeAulaService.deleteAllSalaDeAula();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSalaDeAulaById (@PathVariable Long id){
        salaDeAulaService.deleteSalaDeAulaById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<SalaDeAula> insertSalaDeAula(@RequestBody Map<String, Object> salaDeAulaMap) {
        SalaDeAula salaDeAula = new SalaDeAula();
        salaDeAula.setNumero((Integer) salaDeAulaMap.get("numero"));
        salaDeAula.setProfessor((String) salaDeAulaMap.get("professor"));
        salaDeAula.setHorario(LocalTime.parse((String) salaDeAulaMap.get("horario"), DateTimeFormatter.ofPattern("HH:mm:ss")));


            salaDeAula.setAlunos(new ArrayList<>());


        SalaDeAula insertSala = salaDeAulaService.insert(salaDeAula);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertSala.getId()).toUri();
        return ResponseEntity.created(uri).body(insertSala);
    }



    @PutMapping(value = "/{id}")
    public ResponseEntity<SalaDeAula> updateSalaDeAula (@PathVariable Long id ,@RequestBody SalaDeAula updateSalaDeAula){
        try {
            updateSalaDeAula.setId(id); //certificar dedefinir o Id do usuario atualizado
            SalaDeAula salaDeAula = salaDeAulaService.updateSalaDeAula(updateSalaDeAula);
            return ResponseEntity.ok(salaDeAula);
        }catch (RuntimeException e){
            return  ResponseEntity.notFound().build();

        }
    }



}

