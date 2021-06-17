package com.github.pdropp.citiesAPI.Distancia;


import com.github.pdropp.citiesAPI.Cidades.Cidade;
import com.github.pdropp.citiesAPI.Cidades.CidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanciaService {
    private final CidadeRepository cidadeRepository;
    Logger log = LoggerFactory.getLogger(DistanciaService.class);

    public DistanciaService(final CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }


    public Double distanceUsingPoints(final Long city1, final Long city2 ){
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        return cidadeRepository.distanceByPoints(city1,city2);

    }

    public Double distanceByCubeInMeters(Long city1, Long city2) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<Cidade> cities = cidadeRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cidadeRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
