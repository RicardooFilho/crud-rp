package com.rp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rp.domain.Pessoa;
import com.rp.repository.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public List<Pessoa> findAll() {

        return repository.findAll();
    }

    public Pessoa findById(Long id) {

        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Pessoa create(Pessoa newPessoa) {

        return repository.save(newPessoa);
    }

    public Pessoa update(Long id, Pessoa newPessoa) {

        return repository.findById(id)
                .map(pessoa -> repository.save(newPessoa))
                .orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
