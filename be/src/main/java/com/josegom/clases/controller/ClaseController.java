package com.josegom.clases.controller;

import com.josegom.clases.logic.ClasesLogic;
import com.josegom.clases.model.Clase;
import com.josegom.clases.model.Leccion;
import com.josegom.clases.repository.LeccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ClaseController {


    @Autowired
    private LeccionRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClaseController.class);

    @PostMapping("/api/clase")
    public void setClase(@RequestBody Clase clase) {
        ClasesLogic cL = new ClasesLogic();
        LOGGER.info("Entrando {}",clase);
        cL.getDays(clase.getFecha_inicio(), clase.getFecha_fin(),clase.getDia()).map(
            c -> new Leccion(clase.getDia(),clase.getDescripcion(),clase.getMateria(),clase.getHora_inicio(),clase.getHora_fin(),c)
        ).forEach(l -> {
            LOGGER.info("Guardando {}",l);
            repository.save(l);
        } );
        LOGGER.info("Saliendo");


    }


    @GetMapping("api/clase")
    public Iterable<Leccion> getClase(){
        return repository.findAll();
        /*return new Clase(DayOfWeek.MONDAY,"una descripcion", "una mataris",LocalTime.of(19,00,00,00),
            LocalTime.of(20,00,00,00), LocalDate.of(2017,9,1),
            LocalDate.of(2018,6,30));*/
    }


}

