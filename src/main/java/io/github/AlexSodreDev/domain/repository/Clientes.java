package io.github.AlexSodreDev.domain.repository;

import io.github.AlexSodreDev.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = " select c from Cliente c where c.nome like :nome ")
    List<Cliente> encontrarPorNomeConsultaJpql ( @Param("nome") String nome );

    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNomeConsultaNativa ( @Param("nome") String nome );

    List<Cliente> findByNomeLike(String nome);

    boolean existsByNome(String nome);
}
