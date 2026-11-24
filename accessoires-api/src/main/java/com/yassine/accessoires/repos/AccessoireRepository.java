package com.yassine.accessoires.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yassine.accessoires.entities.Accessoire;

// exported = false : les accessoires sont exposés par notre contrôleur REST (/api), pas par Spring Data REST
@RepositoryRestResource(exported = false)
public interface AccessoireRepository extends JpaRepository<Accessoire, Long> {

	List<Accessoire> findByMarqueIdMarque(Long idMarque);
}
