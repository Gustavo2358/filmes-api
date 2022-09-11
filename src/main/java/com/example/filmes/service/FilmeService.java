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

    public Filme getMoviesByNome(String nome) {
        return filmeRepository.findByNome(nome);
    }

    public List<Filme> getMoviesByGenero(String genero) {
        return filmeRepository.findByGenero(genero);
    }

    public List<Filme> getMoviesByAnoLancamento(String ano) {
        return filmeRepository.findByAnoLancamento(ano);
    }

    public List<Filme> getMoviesByAtor(String ator) {
        return filmeRepository.findByAtores(ator);
    }

}
