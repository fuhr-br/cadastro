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
   private Long id;

    @Column(name="LOGRADOURO", nullable = false)
    private String logradluro;

    @Column(name="CEP", nullable = false)
    private String cep;

    @Column(name="NUMERO", nullable = false)
    private Integer numero;

    @Column(name="CIDADE", nullable = false)
    private String cidade;

    @Column(name="PRINCIPAL")
    @Builder.Default
    private boolean isPrincipal = false;

    public void setPrincipal(boolean principal) {
        isPrincipal = principal;
    }

}
