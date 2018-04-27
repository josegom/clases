package com.josegom.clases.repository;

import com.josegom.clases.model.Clase;
import com.josegom.clases.model.Leccion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "leccion", path = "leccion")
public interface LeccionRepository extends PagingAndSortingRepository<Leccion, Long> {

}
