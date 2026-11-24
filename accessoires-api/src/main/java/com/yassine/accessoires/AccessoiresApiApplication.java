package com.yassine.accessoires;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yassine.accessoires.entities.Accessoire;
import com.yassine.accessoires.entities.Marque;
import com.yassine.accessoires.repos.AccessoireRepository;
import com.yassine.accessoires.repos.MarqueRepository;

@SpringBootApplication
public class AccessoiresApiApplication implements CommandLineRunner {

	@Autowired
	MarqueRepository marqueRepository;

	@Autowired
	AccessoireRepository accessoireRepository;

	public static void main(String[] args) {
		SpringApplication.run(AccessoiresApiApplication.class, args);
	}

	// Données de départ : seulement si la base est vide
	@Override
	public void run(String... args) throws Exception {
		if (marqueRepository.count() == 0) {
			Marque apple = marqueRepository.save(new Marque(null, "Apple", "Marque américaine d'électronique grand public"));
			Marque samsung = marqueRepository.save(new Marque(null, "Samsung", "Marque sud-coréenne d'électronique"));
			Marque anker = marqueRepository.save(new Marque(null, "Anker", "Marque spécialisée en chargeurs et batteries"));

			accessoireRepository.save(new Accessoire(null, "Casque Bluetooth", 120.5, new Date(), samsung));
			accessoireRepository.save(new Accessoire(null, "Coque iPhone", 25.0, new Date(), apple));
			accessoireRepository.save(new Accessoire(null, "Chargeur USB-C", 45.123, new Date(), anker));
		}
	}
}
