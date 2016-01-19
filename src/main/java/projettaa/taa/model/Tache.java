package projettaa.taa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonBackReference;


@EnableAutoConfiguration
@Entity
public class Tache {


	private int id;
	private Employee employee;

	private String nom;
	private Date debut;
	private Date fin;
	private String commentaire;
	private String etat;


	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public Tache() {

	}

	public Tache(String nom, Date debut, Date fin, String commentaire ) {
		this.nom = nom;
		this.debut = debut;
		this.fin = fin;
		this.commentaire = commentaire;

	}



	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JsonBackReference("dev")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column
	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Column
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	@Column
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Column
	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}
}
