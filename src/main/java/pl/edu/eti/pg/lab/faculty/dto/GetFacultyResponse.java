package pl.edu.eti.pg.lab.faculty.dto;

import pl.edu.eti.pg.lab.faculty.entity.Faculty;

import java.util.function.Function;

public class GetFacultyResponse {
	private String dean;

	private String name;

	private int numberOfStudents;

	public static Function<Faculty, GetFacultyResponse> entityToDtoMapper() {
		return request ->
				new GetFacultyResponse(request.getDean(), request.getName(),
						request.getAmountOfStudents());
	}

	public GetFacultyResponse(String dean, String name, int numberOfStudents) {
		this.dean = dean;
		this.name = name;
		this.numberOfStudents = numberOfStudents;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
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
}
