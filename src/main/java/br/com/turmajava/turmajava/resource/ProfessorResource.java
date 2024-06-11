package br.com.turmajava.turmajava.resource;


import br.com.turmajava.turmajava.entities.Professor;
import br.com.turmajava.turmajava.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping (value = "/professores")
public class ProfessorResource {

    @Autowired
    public ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        List<Professor> list = professorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id){
        Professor professor = professorService.findById(id);
        return ResponseEntity.ok(professor);

    }

  @PostMapping
    public ResponseEntity<Professor> insertProfessor(@RequestBody Map< String, Object> professorMap){
        Professor novoProfessor = new Professor();
        novoProfessor.setNome((String) professorMap.get("nome"));
        novoProfessor.setMateria((String) professorMap.get("materia"));
        novoProfessor.setContratacao(LocalDate.parse((String) professorMap.get("contratacao")));



       Professor savedProfessor = professorService.insert(novoProfessor);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(savedProfessor.getId()).toUri();
       return ResponseEntity.created(uri).body(savedProfessor);
   }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor){
        try{
        professor.setId(id);
        Professor updateProfessor = professorService.update(id, professor);
        return ResponseEntity.ok(updateProfessor);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        professorService.delite(id);
        return ResponseEntity.noContent().build();

    }





}
