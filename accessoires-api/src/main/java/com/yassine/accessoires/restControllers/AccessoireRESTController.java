package com.yassine.accessoires.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.accessoires.entities.Accessoire;
import com.yassine.accessoires.service.AccessoireService;

@RestController
@RequestMapping("/api")
public class AccessoireRESTController {

	@Autowired
	AccessoireService accessoireService;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<Accessoire> getAllAccessoires() {
		return accessoireService.getAllAccessoires();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Accessoire getAccessoireById(@PathVariable("id") Long id) {
		return accessoireService.getAccessoire(id);
	}

	@RequestMapping(path = "/addacc", method = RequestMethod.POST)
	public Accessoire createAccessoire(@RequestBody Accessoire accessoire) {
		return accessoireService.saveAccessoire(accessoire);
	}

	@RequestMapping(path = "/updateacc", method = RequestMethod.PUT)
	public Accessoire updateAccessoire(@RequestBody Accessoire accessoire) {
		return accessoireService.updateAccessoire(accessoire);
	}

	@RequestMapping(value = "/delacc/{id}", method = RequestMethod.DELETE)
	public void deleteAccessoire(@PathVariable("id") Long id) {
		accessoireService.deleteAccessoireById(id);
	}

	@RequestMapping(value = "/accsmarque/{idMarque}", method = RequestMethod.GET)
	public List<Accessoire> getAccessoiresByMarqueId(@PathVariable("idMarque") Long idMarque) {
		return accessoireService.findByMarqueIdMarque(idMarque);
	}
}
