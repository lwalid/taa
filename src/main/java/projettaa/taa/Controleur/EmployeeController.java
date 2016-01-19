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
	@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public class EmployeeController {

		
		@Autowired
		EmployeeService employeeService;

		@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public Employee getEmployee(@PathVariable("id") int id) {
			Employee employee = employeeService.findOne(id);
			return employee;
		}

		@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee object) {

			Employee employee = new Employee();
			employee.setNom(object.getNom());
			 

			employeeService.addEmployee(employee);

			return new ResponseEntity<Employee>(object, HttpStatus.OK);

		}

		@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Employee> findAll() {
			return employeeService.findAll();

		}

		@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
		public void deleteEmployee(@PathVariable int id) {
			employeeService.deleteEmployee(id);
		}

		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public void deleteAllEmployee() {
			employeeService.deleteAllEmployee();
		}

		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public ResponseEntity<Employee> updateEmployee(Employee employee) {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		

		
	}

