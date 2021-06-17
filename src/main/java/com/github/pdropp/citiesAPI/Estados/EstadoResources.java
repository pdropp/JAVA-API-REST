package com.github.pdropp.citiesAPI.Estados;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staties")
public class EstadoResources {
    private final EstadoRepository repository;

    public EstadoResources(final EstadoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Estado> staties(){
        return repository.findAll();
    }


}
