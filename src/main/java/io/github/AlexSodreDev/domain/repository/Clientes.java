package io.github.AlexSodreDev.domain.repository;

import io.github.AlexSodreDev.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Clientes {

    private static final String INSERT = "insert into cliente (nome) values (?)";
    private static final String SELECT_ALL = "select * from cliente";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            return new Cliente(id, nome);
        });
    }
}
