package projettaa.taa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projettaa.taa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query( "DELET t FROM Employee t WHERE t.id=:t_id")
	void delete(int id);

}
