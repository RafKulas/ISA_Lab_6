package pl.edu.eti.pg.lab.faculty.dto;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class GetFacultiesResponse {

	private static class Faculty {
		private int numberOfStudents;

		private String name;

		private String dean;

		public Faculty(int numberOfStudents, String name, String dean) {
			this.numberOfStudents = numberOfStudents;
			this.name = name;
			this.dean = dean;
		}

		public int getNumberOfStudents() {
			return numberOfStudents;
		}

		public void setNumberOfStudents(int numberOfStudents) {
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
	}

	List<Faculty> facultiesResponse;

	public GetFacultiesResponse(List<Faculty> facultiesResponse) {
		this.facultiesResponse = facultiesResponse;
	}

	public static Function<Collection<pl.edu.eti.pg.lab.faculty.entity.Faculty>, GetFacultiesResponse> entityToDtoMapper() {
		return faculties -> {
			List<Faculty> facultiesResponse = new LinkedList<>();
			faculties.stream()
					.map(faculty ->
							new Faculty(faculty.getAmountOfStudents(), faculty.getName(),
									faculty.getDean()))
					.forEach(facultiesResponse::add);
			return new GetFacultiesResponse(facultiesResponse);
		};
	}

	public List<Faculty> getFacultiesResponse() {
		return facultiesResponse;
	}

	public void setFacultiesResponse(List<Faculty> facultiesResponse) {
		this.facultiesResponse = facultiesResponse;
	}
}
