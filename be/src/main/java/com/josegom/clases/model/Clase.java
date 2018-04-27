package com.josegom.clases.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clase")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DayOfWeek dia;

    private String descripcion = "";

    private String materia = "";

    private LocalTime hora_inicio ;

    private LocalTime hora_fin ;

    private LocalDate fecha_inicio = null;

    private LocalDate fecha_fin = null;

    public void setClasesApuntado(List<Alumno> clasesApuntado) {
        this.clasesApuntado = clasesApuntado;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "clase_alumno",
            joinColumns = @JoinColumn(name = "clase_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    private List<Alumno> clasesApuntado = new ArrayList<>();

    protected Clase() {


    }

    public Clase(DayOfWeek dia, String descripcion, String materia, LocalTime horaInicio, LocalTime horaFin, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.dia = dia;
        this.descripcion = descripcion;
        this.materia = materia;
        this.hora_inicio = horaInicio;
        this.hora_fin = horaFin;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) { this.fecha_inicio = fecha_inicio; }

    public void setFecha_fin(LocalDate fecha_fin) { this.fecha_fin = fecha_fin; }




    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public Long getId() {
        return id;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMateria() {
        return materia;
    }
    public LocalDate getFecha_inicio() {      return fecha_inicio;  }

    public LocalDate getFecha_fin() {   return fecha_fin;  }

    public List<Alumno> getClasesApuntado() {    return clasesApuntado; }


    @Override
    public String toString() {
        return String.format(
            "Clase[id=%d, dia='%s' descripcion='%s', materia='%s', hora_inicio='%s', hora_fin='%s', fecha_inicio='%s', fecha_fin='%s']",
            id, dia, descripcion,materia, hora_inicio, hora_fin,fecha_inicio,fecha_fin);
    }


}
