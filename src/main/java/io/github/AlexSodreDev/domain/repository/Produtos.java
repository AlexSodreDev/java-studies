package io.github.AlexSodreDev.domain.repository;

import io.github.AlexSodreDev.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Pedido, Integer> {
}
