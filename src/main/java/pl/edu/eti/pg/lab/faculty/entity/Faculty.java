package pl.edu.eti.pg.lab.faculty.entity;

import pl.edu.eti.pg.lab.student.entity.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "faculties")
public class Faculty implements Serializable {
	private int amountOfStudents;

	@Id
	private String name; //PK

	@Column(unique = true)
	private String dean;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "faculty")
	private List<Student> studentList;

	@Column(unique = true)
	private String filename;

	public Faculty(int amountOfStudents, String name, String dean, String filename) {
		this.amountOfStudents = amountOfStudents;
		this.name = name;
		this.dean = dean;
		this.filename = filename;
	}

	public Faculty() {

	}

	public int getAmountOfStudents() {
		return amountOfStudents;
	}

	public void setAmountOfStudents(int amountOfStudents) {
		this.amountOfStudents = amountOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountOfStudents, name, dean);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return name.equals(other.name) && amountOfStudents == other.amountOfStudents && dean.equals(other.dean);
	}

	@Override
	public String toString() {
		return String.format("%s, %s: %d", name, dean, amountOfStudents);
	}
}
