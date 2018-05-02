package com.josegom.clases.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="leccion")
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="clase_id")
    private Clase clase;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",locale="es_ES")
    private LocalDate fecha = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm",locale="es_ES")
    private LocalDate fecha_inicio = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm",locale="es_ES")
    private LocalDate fecha_fin = null;


    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "leccion_alumno",
        joinColumns = @JoinColumn(name = "leccion_id"),
        inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    private List<Alumno> clasesApuntado = new ArrayList<>();

    public Leccion(){}
    public Leccion(Clase clase, LocalDate fecha) {
        this.clase = clase;
        this.fecha = fecha;
    }



    public void setClasesApuntado(List<Alumno> clasesApuntado) {this.clasesApuntado = clasesApuntado;}
    public void setId(Long id) {
        this.id = id;
    }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalDate getFecha() {      return fecha;  }
    public List<Alumno> getClasesApuntado() {    return clasesApuntado; }
    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return String.format(
            "Leccion[id=%d, fecha='%s','%s]",
            id, fecha,clase);
    }
}
