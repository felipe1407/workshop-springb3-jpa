package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration  //classe específica de Configuração
@Profile("test") //Definir que só vai rodar no test
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria brwon", "mar@gmail.com", "98888898", "123456");
        User u2 = new User(null, " Felipe Red", "fer@gmail.com", "99988898", "1234567");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
