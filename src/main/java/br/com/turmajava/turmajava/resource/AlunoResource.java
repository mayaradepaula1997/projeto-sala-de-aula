package br.com.turmajava.turmajava.resource;


import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //sistema entenda que ali será uma classe que controlará as requisições
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService service; //injeção de dependência da nossa classe de serviço

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById (@PathVariable Long id){
        Aluno aluno = service.findById(id);
        return ResponseEntity.ok(aluno);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllAlunos (){
        service.deleteAllAlunos();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAlunoById (@PathVariable Long id){
        service.deleteAlunoById(id);
        return ResponseEntity.noContent().build();
    }



}
