package br.com.turmajava.turmajava.services;

import br.com.turmajava.turmajava.entities.Professor;
import br.com.turmajava.turmajava.exception.ResourceNotFoundException;
import br.com.turmajava.turmajava.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    public ProfessorRepository professorRepository;


    // listar todos os professores
    public List<Professor> findAll (){
       return professorRepository.findAll();

    }

    //trazer o professor pelo id
    public Professor findById(Long id){
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isPresent()){
            return professor.get();
        }else{
            throw new ResourceNotFoundException("Professor não encontrado");
        }


    }

    //deletar professor
    public void delite(Long id) {
        Professor professor = findById(id);
        if (professor != null) {
            professorRepository.deleteById(professor.getId());
        }else{
            throw new ResourceNotFoundException("Id não existe");
        }

    }

    //inserir professor
    public Professor insert (Professor professor){
        return professorRepository.save(professor);
    }



    //atualizar o professor
    public Professor update (Long id, Professor professor) {
        Professor professorExiste = findById(id);
        if (professorExiste == null) {
            throw new ResourceNotFoundException("Professor não encontrado");
        }else{
            professorExiste.setNome(professor.getNome());
            professorExiste.setMateria(professor.getMateria());
            professorExiste.setContratacao(professor.getContratacao());
            return professorRepository.save(professorExiste);
        }
    }

}
