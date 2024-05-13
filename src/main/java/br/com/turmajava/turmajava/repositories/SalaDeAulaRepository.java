package br.com.turmajava.turmajava.repositories;

import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.entities.SalaDeAula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaDeAulaRepository extends JpaRepository<SalaDeAula, Long> {
}
