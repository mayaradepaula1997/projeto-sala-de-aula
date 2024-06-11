package br.com.turmajava.turmajava.repositories;

import br.com.turmajava.turmajava.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
