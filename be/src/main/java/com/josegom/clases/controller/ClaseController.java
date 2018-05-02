package com.josegom.clases.controller;

import com.google.common.collect.Lists;
import com.josegom.clases.logic.ClasesLogic;
import com.josegom.clases.model.Alumno;
import com.josegom.clases.model.Clase;
import com.josegom.clases.model.Leccion;
import com.josegom.clases.repository.AlumnosRepository;
import com.josegom.clases.repository.ClasesRepository;
import com.josegom.clases.repository.LeccionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ClaseController {


    @Autowired
    private LeccionRepository leccionRepository;
    @Autowired
    private ClasesRepository clasesRepository;

    @Autowired
    private AlumnosRepository alumnosRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(ClaseController.class);

    @PostMapping("/api/clase")
    public void setClase(@RequestBody Clase clase) {
        LOGGER.info("Entrando {}",clase);
        Clase claseGuardada = clasesRepository.save(clase);

        Iterable<Alumno> alumnos = alumnosRepository.findAllById(clase.getIdAlumnos());
        crearLecciones(claseGuardada, alumnos);
        LOGGER.info("Saliendo");
    }



    @GetMapping("/api/clase")
    public Iterable<Clase> getClase(){

        return clasesRepository.findAll();
    }


    private void crearLecciones(Clase claseGuardada, Iterable<Alumno> alumnos) {
        ClasesLogic cL = new ClasesLogic();
       DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
       DateFormat horaFormat = new SimpleDateFormat("HH:mm");
        cL.getDays(claseGuardada.getFecha_inicio(), claseGuardada.getFecha_fin(),claseGuardada.getDia()).map(
            dia -> new Leccion(claseGuardada,dia)
        ).forEach(l -> {
            LOGGER.info("Guardando {}",l);
            l.setClasesApuntado(Lists.newArrayList(alumnos));
            String fecha = fechaFormat.format(l.getFecha());

            leccionRepository.save(l);
        } );
    }




}

