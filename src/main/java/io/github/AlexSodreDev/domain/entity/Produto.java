package io.github.AlexSodreDev.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String descricao;

    @Column(name = "preco_unitario", length = 20, precision = 2)
    private BigDecimal preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getpreco() {
        return preco;
    }

    public void setpreco(BigDecimal preco) {
        this.preco = preco;
    }
}
