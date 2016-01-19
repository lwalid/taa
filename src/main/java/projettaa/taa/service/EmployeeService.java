package projettaa.taa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projettaa.taa.model.Employee;
import projettaa.taa.repository.EmployeeRepository;



@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository; 


	public List<Employee>  findAll( ) {
		return employeeRepository.findAll();
	}

	public Employee findOne(int id) {
		return employeeRepository.findOne(id);
	}

	public void addEmployee(Employee Employee) {
		employeeRepository.save(Employee);
	}

	public void deleteEmployee( int id) {
		employeeRepository.delete(id);
	}

	public void deleteAllEmployee() {
		employeeRepository.deleteAllInBatch();
	}

	public  void updateEmployee(Employee Employee){
		employeeRepository.saveAndFlush(Employee); 
	}
}




