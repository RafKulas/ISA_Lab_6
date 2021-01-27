package pl.edu.eti.pg.lab.faculty.dto;

import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.BiFunction;

public class UpdateFacultyRequest {
	private String name;

	private String dean;

	private int numberOfStudents;

	public static BiFunction<Faculty, UpdateFacultyRequest, Faculty> dtoToEntityUpdater() {
		return (faculty, request) -> {
			faculty.setName(request.getName());
			faculty.setDean(request.getDean());
			faculty.setAmountOfStudents(request.getNumberOfStudents());
			return faculty;
		};
	}

	public UpdateFacultyRequest(String name, String dean, int numberOfStudents) {
		this.name = name;
		this.dean = dean;
		this.numberOfStudents = numberOfStudents;
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

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
}
