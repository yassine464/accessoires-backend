package com.yassine.accessoires.service;

import java.util.List;

import com.yassine.accessoires.entities.Accessoire;

public interface AccessoireService {

	Accessoire saveAccessoire(Accessoire a);

	Accessoire updateAccessoire(Accessoire a);

	void deleteAccessoireById(Long id);

	Accessoire getAccessoire(Long id);

	List<Accessoire> getAllAccessoires();

	List<Accessoire> findByMarqueIdMarque(Long idMarque);
}
