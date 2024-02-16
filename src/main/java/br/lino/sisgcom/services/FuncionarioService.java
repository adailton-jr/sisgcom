package br.lino.sisgcom.services;

import br.lino.sisgcom.models.Funcionario;
import br.lino.sisgcom.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public <S extends Funcionario> S save(S entity) {
        return funcionarioRepository.save(entity);
    }

    public Funcionario findById(UUID uuid) {
        Optional<Funcionario> optional = funcionarioRepository.findById(uuid);
        Funcionario funcionario = null;
        if (optional.isPresent()) {
            funcionario = optional.get();
        } else {
            throw new RuntimeException("Funcionário não encontrado com o ID: " + uuid);
        }
        return funcionario;
    }


    public void deleteById(UUID uuid) {
        funcionarioRepository.deleteById(uuid);
    }
}
