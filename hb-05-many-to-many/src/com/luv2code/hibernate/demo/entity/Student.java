package com.luv2code.hibernate.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; //use this always
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name ="course_student", //name of the join table
			joinColumns = @JoinColumn(name ="student_id"), //this is the foreign key column in the join_table(course_student) table who reference to the primary key of the student table
			inverseJoinColumns = @JoinColumn(name="course_id")//this is the foreign key column in the join_table(course_id) table who reference to the primary key of the course table
			                                                    //we apply inverse here because it is the column in the other side table of the relationship
			)
	private List<Student> courses;
	
	
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

	

	public List<Student> getCourses() {
		return courses;
	}

	public void setCourses(List<Student> courses) {
		this.courses = courses;
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
