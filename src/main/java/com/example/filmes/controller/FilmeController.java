package com.example.filmes.controller;

import com.example.filmes.domain.Filme;
import com.example.filmes.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@AllArgsConstructor
public class FilmeController {

    FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<Filme>> listMovies(){
        return new ResponseEntity<>(filmeService.getMovies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Filme> postMovie(@RequestBody Filme filme){
        Filme filmeResponse =  filmeService.postMovie(filme);
        return new ResponseEntity<>(filmeResponse, HttpStatus.CREATED);
    }

}
