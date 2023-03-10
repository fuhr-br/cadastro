package com.attornatus.cadastro.domain;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@EqualsAndHashCode
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME",nullable = false, length = 70)
    private String nome;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ENDERECO_PESSOA", joinColumns = {
            @JoinColumn(name = "PESSOA_ID", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "ENDERECO_ID", referencedColumnName = "id") })
    private List<Endereco> endereco;

}
