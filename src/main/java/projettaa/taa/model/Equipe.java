package projettaa.taa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonBackReference;

@EnableAutoConfiguration
@Entity
public class Equipe {


	private int id;
	private String name;


	private Set<Employee> employees;    


	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public Equipe() {
	}

	public Equipe(String name) {
		this.name = name;
	}



	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "equipe")
	@JsonBackReference("equipe")
	public Set<Employee> getemployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
