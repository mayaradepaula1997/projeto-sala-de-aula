package br.com.turmajava.turmajava.resource;


import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //sistema entenda que ali será uma classe que controlará as requisições
@RequestMapping(value = "/alunos")
public class AlunoResource {

    private AlunoService service; //injeção de dependência da nossa classe de serviço


    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }



}