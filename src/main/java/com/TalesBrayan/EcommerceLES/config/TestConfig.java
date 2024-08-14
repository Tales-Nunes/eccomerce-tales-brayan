package com.TalesBrayan.EcommerceLES.config;

import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client1 = new Client(null, "brayan", "328.607.060-20" , "brayan@gmail.com" , "123456", "11996222222", "Rua 2", "Mogi das Cruzes", "SP", "08743010");
        Client client2 = new Client(null, "Tales", "50487372883" , "tales@gmail.com" , "123456", "11996983359", "Rua 1", "Mogi das Cruzes", "SP", "08743010");
        clientRepository.saveAll(Arrays.asList(client1, client2));
    }
}
