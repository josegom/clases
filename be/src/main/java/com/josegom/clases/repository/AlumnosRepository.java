package com.josegom.clases.repository;


import com.josegom.clases.model.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "alumnos", path = "alumnos")
public interface AlumnosRepository extends CrudRepository<Alumno, Long> {


}