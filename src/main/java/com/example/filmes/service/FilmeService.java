package com.example.filmes.service;

import com.example.filmes.domain.Filme;
import com.example.filmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmeService {

    FilmeRepository filmeRepository;


    public List<Filme> getMovies(){
        return filmeRepository.findAll();
    }
    public Filme postMovie(Filme filme){
        return filmeRepository.save(filme);
    }
}
