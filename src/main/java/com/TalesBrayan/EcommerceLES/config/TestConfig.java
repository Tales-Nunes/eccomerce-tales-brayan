package com.TalesBrayan.EcommerceLES.config;

import com.TalesBrayan.EcommerceLES.entities.Category;
import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.entities.Order;
import com.TalesBrayan.EcommerceLES.entities.Product;
import com.TalesBrayan.EcommerceLES.entities.enums.OrderStatus;
import com.TalesBrayan.EcommerceLES.repositories.CategoryRepository;
import com.TalesBrayan.EcommerceLES.repositories.ClientRepository;
import com.TalesBrayan.EcommerceLES.repositories.OrderRepository;
import com.TalesBrayan.EcommerceLES.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category instruments = new Category(null, "Instruments");
        Category saxCategory = new Category(null, "Saxophone");
        Category guitarCategory = new Category(null, "Guitar");

        categoryRepository.saveAll(Arrays.asList(saxCategory,guitarCategory, instruments));

        Product saxophone = new Product(null, "Saxophone Selmer", "Saxophone Tenor Henry Selmer Paris Super Series II", 30000.00, "img1");
        Product guitar = new Product(null, "Guitar Fender", "Guitar Fender American Black edition", 22000.00, "img2");

        productRepository.saveAll(Arrays.asList(saxophone, guitar));

        saxophone.getCategories().add(saxCategory);
        saxophone.getCategories().add(instruments);
        guitar.getCategories().add(guitarCategory);
        guitar.getCategories().add(instruments);

        productRepository.saveAll(Arrays.asList(saxophone, guitar));

        Client client1 = new Client(null, "brayan", "328.607.060-20" , "brayan@gmail.com" , "123456", "11996222222", "Rua 2", "Mogi das Cruzes", "SP", "08743010");
        Client client2 = new Client(null, "Tales", "50487372883" , "tales@gmail.com" , "123456", "11996983359", "Rua 1", "Mogi das Cruzes", "SP", "08743010");

        clientRepository.saveAll(Arrays.asList(client1, client2));

        Order order1 = new Order(null, Instant.parse("2024-08-14T19:53:08Z"), OrderStatus.PAID, client1);

        orderRepository.saveAll(Arrays.asList(order1));



    }
}
