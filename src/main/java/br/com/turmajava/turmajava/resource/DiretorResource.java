package br.com.turmajava.turmajava.resource;

import br.com.turmajava.turmajava.entities.Diretor;
import br.com.turmajava.turmajava.exception.BadRequestException;
import br.com.turmajava.turmajava.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value ="/diretores")
public class DiretorResource {

    @Autowired
    private DiretorService diretorService;


   @GetMapping
    public ResponseEntity<List<Diretor>> findAll(){
        List<Diretor> list = diretorService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Diretor> findById(@PathVariable Long id){
        Diretor diretor = diretorService.findById(id);
        return ResponseEntity.ok(diretor);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Diretor> updateDiretor (@PathVariable Long id, @RequestBody Diretor diretor){
        try{
            diretor.setId(id);
            Diretor updateDiretor = diretorService.update(id,diretor);
            return ResponseEntity.ok(updateDiretor);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        diretorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity insertDiretor(@RequestBody Map<String, Object> diretorMap){
        Diretor novoDiretor = new Diretor();
        novoDiretor.setNome((String) diretorMap.get("nome"));
        novoDiretor.setSuperUsuario((Boolean) diretorMap.get("superUsuario"));


        List<Diretor> diretores = diretorService.findAll();
        if (!diretores.isEmpty()){

           throw new BadRequestException("Ja temos um diretor");

        }

        Diretor saveDiretor = diretorService.insert(novoDiretor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveDiretor.getId()).toUri();
        return ResponseEntity.created(uri).body(saveDiretor);



    }

}
