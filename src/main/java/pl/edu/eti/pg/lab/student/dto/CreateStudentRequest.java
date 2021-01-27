package pl.edu.eti.pg.lab.student.dto;

import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.function.Function;

public class CreateStudentRequest {
	private String name;

	private String surname;

	private String faculty;

	private String fieldOfStudies;

	private int indexNumber;

	public static Function<CreateStudentRequest, Student> dtoToEntityMapper(
			Function<String, Faculty> facultyFunction
	) {
		return request -> new Student(request.getName(),
				request.getSurname(), facultyFunction.apply(request.getFaculty()),
				request.getFieldOfStudies(), request.getIndexNumber());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getFieldOfStudies() {
		return fieldOfStudies;
	}

	public void setFieldOfStudies(String fieldOfStudies) {
		this.fieldOfStudies = fieldOfStudies;
	}

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}
}
