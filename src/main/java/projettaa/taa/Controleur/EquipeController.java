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
import projettaa.taa.service.EmployeeService;



@RestController
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)

public class EquipeController {



	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getDeveloper(@PathVariable("id") int id) {
		Employee emplyee = employeeService.findOne(id);
		return emplyee;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee object) {

		Employee emplyee = new Employee();
		emplyee.setNom(object.getNom());
		 

		employeeService.addEmployee(emplyee);

		return new ResponseEntity<Employee>(object, HttpStatus.OK);

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findAll() {
		return employeeService.findAll();

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteDeveloper(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteAllDeveloper() {
		employeeService.deleteAllEmployee();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updatedeveloper(Employee developer) {
		employeeService.updateEmployee(developer);
		return new ResponseEntity<Employee>(developer, HttpStatus.OK);
	}
	

	
}
