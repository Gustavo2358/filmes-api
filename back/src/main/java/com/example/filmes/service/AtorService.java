package com.example.filmes.service;

import com.example.filmes.domain.Ator;
import com.example.filmes.repository.AtorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AtorService {

    AtorRepository atorRepository;

    public Ator saveAtor(Ator ator) {
        return atorRepository.save(ator);
    }

    public List<Ator> findAllById(List<Long> atoresId) {
        return atorRepository.findAllById(atoresId);
    }

    public List<Ator> findAll() {
        return atorRepository.findAll();
    }
}
