package com.TalesBrayan.EcommerceLES.config;

import com.TalesBrayan.EcommerceLES.entities.*;
import com.TalesBrayan.EcommerceLES.entities.enums.OrderStatus;
import com.TalesBrayan.EcommerceLES.repositories.*;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

      /*  Category instruments = new Category(null, "Instruments");
        Category saxCategory = new Category(null, "Saxophone");
        Category guitarCategory = new Category(null, "Guitar");

        categoryRepository.saveAll(Arrays.asList(saxCategory,guitarCategory, instruments));

        Product saxophone = new Product(null, "Saxophone Selmer", "Saxophone Tenor Henry Selmer Paris Super Series II", 30000.00, 1);
        Product guitar = new Product(null, "Guitar Fender", "Guitar Fender American Black edition", 22000.00, 1);

        productRepository.saveAll(Arrays.asList(saxophone, guitar));

        saxophone.getCategories().add(saxCategory);
        saxophone.getCategories().add(instruments);
        guitar.getCategories().add(guitarCategory);
        guitar.getCategories().add(instruments);

        productRepository.saveAll(Arrays.asList(saxophone, guitar));

        Client client1 = new Client(null, "brayan", "328.607.060-20" , "brayan@gmail.com" , "123456", "11996222222", "08743010", "Rua 2", "1", "Casa",  "Mogi das Cruzes", "SP");
        Client client2 = new Client(null, "Tales", "50487372883" , "tales@gmail.com" , "123456", "11996983359", "08743010", "Rua 1", "2", "Apartamento 3",  "Mogi das Cruzes", "SP" );

        clientRepository.saveAll(Arrays.asList(client1, client2));

        Order order1 = new Order(null, Instant.parse("2024-08-14T19:53:08Z"), OrderStatus.PAID, client1);

        orderRepository.saveAll(Arrays.asList(order1));

        OrderItem oi1 = new OrderItem(order1, saxophone, 1, saxophone.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1));

        Payment pay1 = new Payment(null, Instant.parse("2024-08-14T21:53:08Z"), order1);
        order1.setPayment(pay1);

        orderRepository.save(order1);
*/
    }
}
