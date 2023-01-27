package com.attornatus.cadastro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="LOGRADOURO", nullable = false)
    String logradluro;

    @Column(name="CEP", nullable = false)
    String CEP;

    @Column(name="NUMERO", nullable = false)
    Integer numero;

    @Column(name="CIDADE", nullable = false)
    String cidade;

}
