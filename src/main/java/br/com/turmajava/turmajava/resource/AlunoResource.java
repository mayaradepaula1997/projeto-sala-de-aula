package br.com.turmajava.turmajava.resource;


import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.entities.Diretor;
import br.com.turmajava.turmajava.entities.SalaDeAula;
import br.com.turmajava.turmajava.exception.ResourceNotFoundException;
import br.com.turmajava.turmajava.repositories.SalaDeAulaRepository;
import br.com.turmajava.turmajava.services.AlunoService;
import br.com.turmajava.turmajava.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController //sistema entenda que ali será uma classe que controlará as requisições
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService service; //injeção de dependência da nossa classe de serviço

    @Autowired //@Autowired para fazermos uma injeção de dependência
    private SalaDeAulaRepository salaDeAulaRepository;

    @Autowired
    private DiretorService diretorService;


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


    @PostMapping
    public ResponseEntity<Aluno> insertAluno(@RequestBody Map<String, Object> alunoMap) {
        Aluno aluno = new Aluno();
        aluno.setMatricula((String) alunoMap.get("matricula"));
        aluno.setNome((String) alunoMap.get("nome"));
        aluno.setIdade((Integer) alunoMap.get("idade"));
        aluno.setDataNascimento(LocalDate.parse((String) alunoMap.get("dataNascimento")));
        aluno.setSexo((String) alunoMap.get("sexo"));


        if(alunoMap.get("diretorId") == null){
            return new ResponseEntity("Precisa ser um diretor, para criar" , HttpStatus.BAD_REQUEST);
        }


        if(alunoMap.get("diretorId") != null){
            Long diretorId = Long.valueOf((Integer) alunoMap.get("diretorId"));
            Diretor diretor = diretorService.findById(diretorId);

            if (!diretor.getSuperUsuario()){
                return new ResponseEntity("Precisa ser um diretor, para criar" , HttpStatus.BAD_REQUEST);

            }

        }


        if (alunoMap.get("sala_de_aula") != null) {
            Long salaDeAulaId = Long.valueOf((Integer) alunoMap.get("sala_de_aula"));
            SalaDeAula salaDeAula = salaDeAulaRepository.findById(salaDeAulaId)
                    .orElseThrow(() -> new ResourceNotFoundException("SalaDeAula not found with id " + salaDeAulaId));
            aluno.setSalaDeAula(salaDeAula);
        }

        Aluno insertAluno = service.insert(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertAluno.getId()).toUri();
        return ResponseEntity.created(uri).body(insertAluno);
    }


   @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> updateAluno (@PathVariable Long id ,@RequestBody Aluno updateAluno){
        try {
            updateAluno.setId(id); //certificar dedefinir o Id do usuario atualizado
            Aluno aluno = service.updateAluno(updateAluno);
            return ResponseEntity.ok(aluno);
        }catch (RuntimeException e){
            return  ResponseEntity.notFound().build();

        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAlunoById (@PathVariable Long id){
        service.deleteAlunoById(id);
        return ResponseEntity.noContent().build();
    }

}
