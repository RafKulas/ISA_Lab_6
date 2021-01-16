package pl.edu.eti.pg.lab.faculty.dto;

import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

public class CreateFacultyRequest {
	private String name;

	private int numberOfStudents;

	private String dean;

	public static Function<CreateFacultyRequest, Faculty> dtoToEntityMapper() {
		return request -> new Faculty(request.getNumberOfStudents(), request.getName(), request.getDean(), null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}
}
