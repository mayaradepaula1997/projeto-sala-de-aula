package br.com.turmajava.turmajava.config;

import br.com.turmajava.turmajava.entities.Aluno;
import br.com.turmajava.turmajava.entities.SalaDeAula;
import br.com.turmajava.turmajava.repositories.AlunoRepository;
import br.com.turmajava.turmajava.repositories.SalaDeAulaRepository;
import br.com.turmajava.turmajava.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


@Configuration //que é para o springBoot entender que vamos usar algum arquivo de configuração
@Profile("test") //procurar nosso arquivo de configuração personalizado
public class TestConfig implements CommandLineRunner {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalTime horaEspecifica = LocalTime.of(19, 00, 0);
    LocalTime horaEspecifica2 = LocalTime.of(18, 00, 0);

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private SalaDeAulaRepository salaDeAulaRepository;


    @Override
    public void run(String... args) throws Exception {

        SalaDeAula salaDeAula1 = new SalaDeAula(null,1,"Maria",horaEspecifica,null);
        SalaDeAula salaDeAula2 = new SalaDeAula(null,2,"José",horaEspecifica2,null);

        Aluno aluno1 = new Aluno(null,"5555","Pedro Andre",15,LocalDate.parse("22/05/2005", formatter),"Masculino",salaDeAula2);

        salaDeAulaRepository.saveAll(Arrays.asList(salaDeAula1,salaDeAula2));

        alunoRepository.save(aluno1);


    }
}
