package io.github.AlexSodreDev;

import io.github.AlexSodreDev.domain.entity.Cliente;
import io.github.AlexSodreDev.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente("Alexandre"));
            clientes.save(new Cliente("Cliente 2"));

            List<Cliente> existe = clientes.encontrarPorNome("Alexandre");
            System.out.println("O cliente Alexandre existe? " + existe);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
