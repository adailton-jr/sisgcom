package br.lino.sisgcom.repositories;

import br.lino.sisgcom.models.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SetorRepository extends JpaRepository<Setor, UUID> {
}