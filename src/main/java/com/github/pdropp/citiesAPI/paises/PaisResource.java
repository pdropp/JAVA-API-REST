package com.github.pdropp.citiesAPI.paises;


import com.github.pdropp.citiesAPI.paises.Pais;
import com.github.pdropp.citiesAPI.paises.repository.PaisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class PaisResource {


    private PaisRepository repository;


    public PaisResource(PaisRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public Page<Pais> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable Long id) {
        Optional<Pais> opcional = repository.findById(id);


        if(opcional.isPresent()) {
            return ResponseEntity.ok().body(opcional.get());
        } else {
            return ResponseEntity.notFound().build();
        }


    }
}
