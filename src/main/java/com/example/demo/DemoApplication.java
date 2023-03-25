package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = userRepository.upsert(new User(4L,"John", "Doe", "doe@gmail", 32));
//        System.out.println(user);

        userRepository.delete(1L);
        userRepository.getAll().stream().forEach(user -> System.out.println(user));

        //System.out.println(userRepository.getById(1L));
    }
}
