package br.com.turmajava.turmajava.config;

import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.repositories.AlunoRepository;
import br.com.turmajava.turmajava.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;


@Configuration //que é para o springBoot entender que vamos usar algum arquivo de configuração
@Profile("test") //procurar nosso arquivo de configuração personalizado
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public void run(String... args) throws Exception {

        Aluno aluno1 = new Aluno(null,"5555","Pedro Andre", LocalDate.parse("2009-09-20"),15,"Masculino");

        alunoRepository.save(aluno1);


    }
}
