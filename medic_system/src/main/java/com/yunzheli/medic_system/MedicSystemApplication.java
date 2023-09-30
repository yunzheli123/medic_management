package com.yunzheli.medic_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yunzheli.medic_system.dao")
@SpringBootApplication
public class MedicSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicSystemApplication.class, args);
    }
}
