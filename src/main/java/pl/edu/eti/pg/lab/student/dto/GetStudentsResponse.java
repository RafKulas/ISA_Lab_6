package pl.edu.eti.pg.lab.student.dto;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class GetStudentsResponse {

	private static class Student {
		private int indexNumber;

		private String name;

		private String surname;

		public Student(int indexNumber, String name, String surname) {
			this.indexNumber = indexNumber;
			this.name = name;
			this.surname = surname;
		}

		public int getIndexNumber() {
			return indexNumber;
		}

		public void setIndexNumber(int indexNumber) {
			this.indexNumber = indexNumber;
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
	}

	private List<Student> studentsResponse;

	public GetStudentsResponse(List<Student> studentsResponse) {
		this.studentsResponse = studentsResponse;
	}

	public static Function<Collection<pl.edu.eti.pg.lab.student.entity.Student>, GetStudentsResponse> entityToDtoMapper() {
		return students -> {
			List<Student> studentsResponse = new LinkedList<>();
			students.stream()
					.map(student ->
							new Student(student.getIndexNumber(), student.getName(),
									student.getSurname()))
					.forEach(studentsResponse::add);
			return new GetStudentsResponse(studentsResponse);
		};
	}

	public List<Student> getStudentsResponse() {
		return studentsResponse;
	}

	public void setStudentsResponse(List<Student> studentsResponse) {
		this.studentsResponse = studentsResponse;
	}
}
