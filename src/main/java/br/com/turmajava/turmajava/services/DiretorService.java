package br.com.turmajava.turmajava.services;

import br.com.turmajava.turmajava.entities.Diretor;
import br.com.turmajava.turmajava.exception.ResourceNotFoundException;
import br.com.turmajava.turmajava.repositories.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;


    public List<Diretor> findAll(){
        return diretorRepository.findAll();
    }


    public Diretor findById(Long id) {
        Optional<Diretor> diretor = diretorRepository.findById(id);
        if (diretor.isPresent()) {
            return diretor.get();
        } else {
            throw new ResourceNotFoundException("Diretor não existe");
        }
    }

    public Diretor insert (Diretor diretor){
        return diretorRepository.save(diretor);
    }

    public Diretor update (Long id, Diretor diretor){
        Diretor diretorExiste = findById(id);
        if(diretorExiste == null) {
            throw new ResourceNotFoundException("Diretor não existe");

        }else{
            diretorExiste.setNome(diretor.getNome());
            diretorExiste.setSuperUsuario(diretor.getSuperUsuario());
            return diretorRepository.save(diretorExiste);
        }
    }

    public void delete(Long id) {
        Diretor diretor = findById(id);
        if (diretor != null) {
            diretorRepository.deleteById(diretor.getId());
        } else {
            throw new ResourceNotFoundException("Id não existe");
        }
    }
}




