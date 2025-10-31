package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration  //classe específica de Configuração
@Profile("test") //Definir que só vai rodar no test
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria brown", "mar@gmail.com", "98888898", "123456");
        User u2 = new User(null, " Felipe Red", "fer@gmail.com", "99988898", "1234567");


        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"),u1);
        Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10z"), u2);
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));
    }
}
