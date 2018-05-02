package com.josegom.clases.repository;


import com.josegom.clases.model.Leccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "leccion", path = "leccion")
public interface LeccionRepository extends CrudRepository<Leccion, Long> {

}
