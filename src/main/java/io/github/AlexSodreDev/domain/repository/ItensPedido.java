package io.github.AlexSodreDev.domain.repository;

import io.github.AlexSodreDev.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}
