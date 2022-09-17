//package com.example.filmes.domain;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//public class Ator {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nome;
//
//    @JsonBackReference
//    @ManyToMany
//    @JoinTable(
//            name = "atores_filmes",
//            joinColumns = @JoinColumn(name = "ator_id"),
//            inverseJoinColumns = @JoinColumn(name = "filme_id"))
//    private Set<Filme> filmes = new HashSet<>();
//
//    public Ator(String nome) {
//        this.nome = nome;
//    }
//}
