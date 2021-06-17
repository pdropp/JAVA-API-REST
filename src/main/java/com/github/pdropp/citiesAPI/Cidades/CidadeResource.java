package com.github.pdropp.citiesAPI.Cidades;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CidadeResource {

    private final CidadeRepository repository;

    public CidadeResource(final CidadeRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public Page<Cidade> cities(final Pageable page) {
        return repository.findAll(page);
    }

}
