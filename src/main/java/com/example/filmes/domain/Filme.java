package com.example.filmes.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private String anoLancamento;

//    @JsonManagedReference
//    @ManyToMany(mappedBy = "filmes")
//    private Set<Ator> atores = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ator", joinColumns = @JoinColumn(name = "filme_id"))
    private Set<String> atores = new HashSet<>();

    public Filme(String nome, String genero, String anoLancamento) {
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
}
