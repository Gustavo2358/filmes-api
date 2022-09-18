package com.example.filmes.controller;

import com.example.filmes.domain.Ator;
import com.example.filmes.domain.dto.AtorDTO;
import com.example.filmes.service.AtorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
@AllArgsConstructor
public class AtorController {

    AtorService atorService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Ator> postActor(@RequestBody AtorDTO atorDTO){
        Ator atorResponse =  atorService.saveAtor(new Ator(atorDTO.getNome()));
        return new ResponseEntity<>(atorResponse, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Ator>> findAllActors(){
        List<Ator> atores = atorService.findAll();
        return new ResponseEntity<>(atores, HttpStatus.OK);
    }
}
