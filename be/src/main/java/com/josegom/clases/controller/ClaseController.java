package com.josegom.clases.controller;

import com.josegom.clases.logic.ClasesLogic;
import com.josegom.clases.model.Clase;
import com.josegom.clases.model.Leccion;
import com.josegom.clases.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ClaseController {


    @Autowired
    private LeccionRepository repository;


    @PostMapping("/api/clase")
    public void setClase(@RequestBody Clase clase) {
        ClasesLogic cL = new ClasesLogic();

        cL.getDays(clase.getFecha_inicio(), clase.getFecha_fin(),clase.getDia()).map(
            c -> new Leccion(clase.getDia(),clase.getDescripcion(),clase.getMateria(),clase.getHora_inicio(),clase.getHora_fin(),c)
        ).forEach(l -> repository.save(l) );


    }


}

