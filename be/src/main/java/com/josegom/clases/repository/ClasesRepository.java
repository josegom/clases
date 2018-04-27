package com.josegom.clases.repository;

import com.josegom.clases.model.Clase;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(collectionResourceRel = "clases", path = "clases")
public interface ClasesRepository extends PagingAndSortingRepository<Clase, Long> {
}
