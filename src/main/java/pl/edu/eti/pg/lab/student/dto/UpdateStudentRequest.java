package pl.edu.eti.pg.lab.student.dto;

import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.function.BiFunction;

public class UpdateStudentRequest {
	private String name;

	private String surname;

	private String fieldOfStudies;

	public static BiFunction<Student, UpdateStudentRequest, Student> dtoToEntityUpdater() {
		return (student, request) -> {
			student.setName(request.getName());
			student.setSurname(request.getSurname());
			student.setFieldOfStudies(request.getFieldOfStudies());
			return student;
		};
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

	public String getFieldOfStudies() {
		return fieldOfStudies;
	}

	public void setFieldOfStudies(String fieldOfStudies) {
		this.fieldOfStudies = fieldOfStudies;
	}
}
