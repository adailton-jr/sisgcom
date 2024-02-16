package br.lino.sisgcom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID setorId;
    private String nome;
    private String descricao;
    private Date createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setor setor = (Setor) o;
        return Objects.equals(setorId, setor.setorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setorId);
    }
}
