package br.lino.sisgcom.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID contratoId;
    //atributos funcionario
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String cargo;
    private String setor;

    //atributos contrato
    private Date criadoEm;
    private Integer cargaHoraria;
    private String Dotação;








    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(contratoId, contrato.contratoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contratoId);
    }
}
