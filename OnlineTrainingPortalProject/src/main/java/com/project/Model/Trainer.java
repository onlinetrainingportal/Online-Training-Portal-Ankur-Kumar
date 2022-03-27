package com.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Trainer {
	@Id
@Column(name="TRAINERID")
	@NotNull
	private String trainerId;
	@Column(name="NAME",nullable=false)
	@NotEmpty
	@Size(min=2, message="name must have atleast two character")
	private String name;
	@Column(name="TECHNOLOGY")
	@NotNull
	private String technology;
	@Column(name="LOCATION")
	@NotNull
	@Size(min=2, message="location must have atleast two character")
	private String location;
	@Column(name="CONTACT")
	@NotNull
	@Size( min=1, max=10, message="contact size must be betwwen 1 to 10")
	private String contact;
	@Column(name="EMAIL")
	@NotNull(message="email should not be empty")
	@Email(message="email should be in proper format")
	private String email;
	
	public Trainer() {
		super();
		
	}
	
	
	public Trainer( String trainerId, String name, String technology, String location, String contact,
			String email) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.technology = technology;
		this.location = location;
		this.contact = contact;
		this.email = email;
	}
	
	
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", name=" + name + ", technology=" + technology + ", location="
				+ location + ", contact=" + contact + ", email=" + email + "]";
	}
	
	
	
	
	
}
