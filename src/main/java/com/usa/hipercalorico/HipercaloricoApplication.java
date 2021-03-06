package com.usa.hipercalorico;

import com.usa.hipercalorico.repository.crud.SupplementCrudRepository;
import com.usa.hipercalorico.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HipercaloricoApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private SupplementCrudRepository supplementCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(HipercaloricoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userCrudRepository.deleteAll();
        supplementCrudRepository.deleteAll();
    }
}
