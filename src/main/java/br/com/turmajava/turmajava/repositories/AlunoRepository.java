package br.com.turmajava.turmajava.repositories;

import br.com.turmajava.turmajava.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
