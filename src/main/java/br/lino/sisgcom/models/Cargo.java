package br.lino.sisgcom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cargoId;
    private String nome;
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(cargoId, cargo.cargoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoId);
    }
}
