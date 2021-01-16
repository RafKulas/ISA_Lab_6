package pl.edu.eti.pg.lab.student.dto;

import pl.edu.eti.pg.lab.student.entity.Student;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class GetFieldsOfStudyResponse {
	Set<String> fieldsOfStudy;

	public static Function<Collection<Student>, GetFieldsOfStudyResponse> entityToDtoMapper() {
		return students -> {
			Set<String> fields = new HashSet<>();
			students.stream()
					.map(Student::getFieldOfStudies)
					.forEach(fields::add);
			return new GetFieldsOfStudyResponse(fields);
		};
	}

	public GetFieldsOfStudyResponse(Set<String> fieldsOfStudy) {
		this.fieldsOfStudy = fieldsOfStudy;
	}

	public Set<String> getFieldsOfStudy() {
		return fieldsOfStudy;
	}

	public void setFieldsOfStudy(Set<String> fieldsOfStudy) {
		this.fieldsOfStudy = fieldsOfStudy;
	}
}
