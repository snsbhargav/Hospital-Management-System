package HospitalManagementSystem.Backend.model;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Name")
	private String name;
	@Column(name="Age")
	private int age;
	@Column(name="Visited_Doctor")
	private String visitedDoctor;
	@Column(name="Date_of_Visit")
	private Date dateOfVisit;
	@Column(name="Doctor_prescription")
	private String prescription;
	
	public Patient() {}
	
	public Patient(String name, int age, String visitedDoctor, Date dateOfVisit, String prescription) {
		super();
		this.name = name;
		this.age = age;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
	}
	
	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVistedDoctor() {
		return visitedDoctor;
	}
	public void setVistedDoctor(String vistedDoctor) {
		this.visitedDoctor = vistedDoctor;
	}
	public Date getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", visitedDoctor=" + visitedDoctor
				+ ", dateOfVisit=" + dateOfVisit + ", prescription=" + prescription + "]";
	}
	
	
	
	
}
