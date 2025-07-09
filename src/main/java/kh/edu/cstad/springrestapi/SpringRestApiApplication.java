package kh.edu.cstad.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiApplication.class, args);
    }

}

// MVC Pattern (Original)
// Model - application's data, logic, access data from database
// View
//Controller

// Model (Spring Web MVC)
// 1. domain -> store application's data
// 2. repository -> access data from database (communicate with database)
// 3. Service -> implement logical