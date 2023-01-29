package com.attornatus.cadastro.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@EqualsAndHashCode
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="LOGRADOURO", nullable = false)
    String logradluro;

    @Column(name="CEP", nullable = false)
    String cep;

    @Column(name="NUMERO", nullable = false)
    Integer numero;

    @Column(name="CIDADE", nullable = false)
    String cidade;

    @Column(name="PRINCIPAL")
    @Builder.Default
    boolean isPrincipal = false;
}
