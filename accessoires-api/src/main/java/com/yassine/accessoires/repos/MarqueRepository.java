package com.yassine.accessoires.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yassine.accessoires.entities.Marque;

// Spring Data REST expose les marques sur /marque  (liste dans _embedded.marques)
@RepositoryRestResource(path = "marque", collectionResourceRel = "marques")
public interface MarqueRepository extends JpaRepository<Marque, Long> {
}
