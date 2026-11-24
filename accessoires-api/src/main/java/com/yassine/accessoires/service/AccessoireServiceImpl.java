package com.yassine.accessoires.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.accessoires.entities.Accessoire;
import com.yassine.accessoires.repos.AccessoireRepository;

@Service
public class AccessoireServiceImpl implements AccessoireService {

	@Autowired
	AccessoireRepository accessoireRepository;

	@Override
	public Accessoire saveAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public Accessoire updateAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public void deleteAccessoireById(Long id) {
		accessoireRepository.deleteById(id);
	}

	@Override
	public Accessoire getAccessoire(Long id) {
		return accessoireRepository.findById(id).get();
	}

	@Override
	public List<Accessoire> getAllAccessoires() {
		return accessoireRepository.findAll();
	}

	@Override
	public List<Accessoire> findByMarqueIdMarque(Long idMarque) {
		return accessoireRepository.findByMarqueIdMarque(idMarque);
	}
}
