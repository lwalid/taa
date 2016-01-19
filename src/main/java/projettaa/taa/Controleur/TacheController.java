package projettaa.taa.Controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projettaa.taa.model.Employee;
import projettaa.taa.model.Tache;
import projettaa.taa.service.EmployeeService;
import projettaa.taa.service.TacheService;

@RestController
@RequestMapping(value = "/tache", produces = MediaType.APPLICATION_JSON_VALUE)
public class TacheController {

	@Autowired
	TacheService tacheService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Tache getTache(@PathVariable("id") int id) {
		Tache tache = tacheService.findOne(id);
		return tache;
	}



	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tache> findAll() {
		return tacheService.findAll();

	}

	@RequestMapping(value = "/add/{idEmployee}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tache> addTache(@RequestBody Tache tache, @PathVariable("idEmployee") int idEmployee) {

		Employee employee= employeeService.findOne(idEmployee);
		tache.setEmployee(employee);
		tacheService.addTache(tache);
		return new ResponseEntity<Tache>(tache, HttpStatus.OK);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteTache(@PathVariable int id) {
		tacheService.deleteTache(id);
	}


	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tache> findAllTaches(@PathVariable("id") int id) {
		return tacheService.findTache(id);

	}


	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteAllTache() {
		tacheService.deleteAllTaches();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tache> updateTache(@RequestBody Tache tache) {
		tacheService.updateTache(tache);
		return new ResponseEntity<Tache>(tache, HttpStatus.OK);
	}
}

