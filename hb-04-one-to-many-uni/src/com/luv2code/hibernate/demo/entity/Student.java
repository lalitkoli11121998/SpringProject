package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity; //use this always
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.IDENTITY) //we tell spring that this column value is autoincreament
	private int id;
	
	@Column(name="first_name")
	private String firsname;
	
	@Column(name="last_name")
    private String lastname;
    
	@Column(name="email")
    private String email;
    
	public Student(){
		
	}

	public Student(String firsname, String lastname, String email) {
		super();
		this.firsname = firsname;
		this.lastname = lastname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirsname() {
		return firsname;
	}

	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firsname=" + firsname + ", lastname=" + lastname + ", email=" + email + "]";
	}



}
