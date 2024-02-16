package br.lino.sisgcom.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID funcionarioId;
    @CreationTimestamp
    @Column(updatable = false)
    private Date criadoEm;
    @UpdateTimestamp
    private Date alteradoEm;

    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private String cpf;
    private String endereco;

    @OneToOne
    private Cargo cargo;
    @OneToOne
    private Setor setor;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contratos = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(funcionarioId, that.funcionarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funcionarioId);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "funcionarioId=" + funcionarioId +
                ", criadoEm=" + criadoEm +
                ", alteradoEm=" + alteradoEm +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cargo=" + cargo +
                ", setor=" + setor +
                ", contratos=" + contratos +
                '}';
    }
}
