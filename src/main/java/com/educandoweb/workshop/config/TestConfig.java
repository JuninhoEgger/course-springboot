package com.educandoweb.workshop.config;

import com.educandoweb.workshop.entities.Order;
import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repositories.OrderRepository;
import com.educandoweb.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static com.educandoweb.workshop.entities.enums.OrderStatus.PAID;
import static com.educandoweb.workshop.entities.enums.OrderStatus.WAITING_PAYMENT;
import static java.time.Instant.parse;
import static java.util.Arrays.asList;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, parse("2019-06-20T19:53:07Z"), PAID, u1);
        Order o2 = new Order(null, parse("2019-07-21T03:42:10Z"), WAITING_PAYMENT, u2);
        Order o3 = new Order(null, parse("2019-07-22T15:21:22Z"), WAITING_PAYMENT, u1);

        userRepository.saveAll(asList(u1, u2));
        orderRepository.saveAll(asList(o1, o2, o3));
    }

}
