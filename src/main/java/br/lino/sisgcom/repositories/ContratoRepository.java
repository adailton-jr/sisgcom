package br.lino.sisgcom.repositories;

import br.lino.sisgcom.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
}