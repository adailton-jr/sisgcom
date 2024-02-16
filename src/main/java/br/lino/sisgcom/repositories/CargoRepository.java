package br.lino.sisgcom.repositories;

import br.lino.sisgcom.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CargoRepository extends JpaRepository<Cargo, UUID> {
}