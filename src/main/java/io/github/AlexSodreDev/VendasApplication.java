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
            clientes.save(new Cliente("Cliente 1"));
            clientes.save(new Cliente("Cliente 2"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando Clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + ", atualizado.");
                clientes.save(c);
            });

            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando Clientes por Nome");
            clientes.findByNomeLike("2").forEach(System.out::println);

            System.out.println("Deletando Clientes");
            clientes.findAll().forEach(clientes::delete);

            todosClientes = clientes.findAll();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum Cliente encontrado");
            } else {
                todosClientes.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
