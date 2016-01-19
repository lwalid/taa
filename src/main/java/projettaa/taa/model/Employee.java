package projettaa.taa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
public class Employee implements Serializable{

	private int id;

	private Equipe equipe;

	private String nom;
	private String prenom;

	private Set<Tache> taches;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public Employee() {

	}

	public Employee(String nom, String prenom) {
		this.nom = nom;
		this.prenom= prenom;
	}



	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public Equipe getEquipe(){
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	@Column
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@OneToMany(mappedBy = "employee")
	public Set<Tache> getTaches() {
		return taches;
	}


	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

}



