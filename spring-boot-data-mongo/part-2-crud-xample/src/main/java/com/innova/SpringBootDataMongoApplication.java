package com.innova;

import com.innova.model.Users;
import com.innova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootDataMongoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMongoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("######USERS LIST AT BEGINNING######");
        System.out.println(userRepository.findAll());
        System.out.println("###################################\n\n");

        System.out.println("######ADDING 2 USERS######");
        Users u1 = new Users("test1", "test1-pass", 1);
        Users u2 = new Users("test2", "test2-pass", 1);
        List<Users> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userRepository.save(userList);
        System.out.println("###################################\n\n");

        System.out.println("######USERS LIST AFTER ADDING######");
        System.out.println(userRepository.findAll());
        System.out.println("###################################\n\n");

        System.out.println("######SEARCH USER BY A FIELD######");
        System.out.println(userRepository.findByUsernameEquals("test1"));
        System.out.println("###################################\n\n");

        System.out.println("######SEARCH AND THEN UPDATE######");
        Users u3 = userRepository.findByUsernameEquals("test1");
        u3.setPassword("test1-newpass");
        userRepository.save(u3);
        System.out.println("###################################\n\n");

        System.out.println("######USERS LIST AFTER UPDATE######");
        System.out.println(userRepository.findAll());
        System.out.println("###################################\n\n");

        System.out.println("######SEARCH AND THEN DELETE######");
        u3 = userRepository.findByUsernameEquals("test1");
        userRepository.delete(u3);
        System.out.println("###################################\n\n");

        System.out.println("######USERS LIST AFTER DELETE######");
        System.out.println(userRepository.findAll());
        System.out.println("###################################\n\n");

    }
}
