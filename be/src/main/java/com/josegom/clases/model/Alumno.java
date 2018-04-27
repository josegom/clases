package com.josegom.clases.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre = "";
    private String email = "";
    private String telefono = "";

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "clase_alumno",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "clase_id")
    )
    private List<Clase>  clasesApuntado = new ArrayList<>();

    protected Alumno() {

    }

    public Alumno(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format(
                "com.josegom.clases.model.Alumno[id=%d, nombre='%s' email='%s', telefono='%s']",
                id, nombre, email, telefono);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

}