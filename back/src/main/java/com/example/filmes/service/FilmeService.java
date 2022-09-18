package com.example.filmes.service;

import com.example.filmes.domain.Ator;
import com.example.filmes.domain.Filme;
import com.example.filmes.domain.dto.FilmeDTO;
import com.example.filmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmeService {

    FilmeRepository filmeRepository;
    AtorService atorService;


    public List<Filme> getMovies(){
        return filmeRepository.findAll();

    }

//    public FilmeDTO saveMovie(FilmeDTO filmeDTO){
//        Filme filme = filmeRepository.save(new Filme(filmeDTO.getNome(), filmeDTO.getGenero(), filmeDTO.getAnoLancamento()));
//        Set<Ator> atores = filmeDTO.getAtores().stream()
//                .map(atorNome -> new Ator(atorNome))
//                .collect(Collectors.toSet());
//        atores.stream().forEach(ator -> ator.getFilmes().add(filme));
//        List<Ator> atoresResponse = atorService.saveActors(new ArrayList<>(atores));
//        List<String> atoresNomes = atoresResponse.stream().map(ator -> ator.getNome()).collect(Collectors.toList());
//        return new FilmeDTO(filme.getNome(), filme.getGenero(), filme.getAnoLancamento(), atoresNomes);
//    }

    public Filme saveMovie(FilmeDTO filmeDTO){

        List<Ator> atores = atorService.findAllById(filmeDTO.getAtoresId());
        Filme filme = new Filme(filmeDTO.getNome(), filmeDTO.getGenero(), filmeDTO.getAnoLancamento());
        filme.getAtores().addAll(atores);
        atores.forEach(ator -> ator.getFilmes().add(filme));

        return filmeRepository.save(filme);

    }

//    public FilmeDTO getMoviesByNome(String nome) {
//        return filmeRepository.findByNome(nome);
//    }
//
//    public List<FilmeDTO> getMoviesByGenero(String genero) {
//        return filmeRepository.findByGenero(genero);
//    }
//
//    public List<FilmeDTO> getMoviesByAnoLancamento(String ano) {
//        return filmeRepository.findByAnoLancamento(ano);
//    }
//
//    public List<FilmeDTO> getMoviesByAtor(String ator) {
//        return filmeRepository.findByAtores(ator);
//    }

}
