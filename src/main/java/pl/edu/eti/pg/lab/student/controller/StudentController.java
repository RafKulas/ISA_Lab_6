package pl.edu.eti.pg.lab.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.eti.pg.lab.faculty.service.FacultyService;
import pl.edu.eti.pg.lab.student.dto.*;
import pl.edu.eti.pg.lab.student.entity.Student;
import pl.edu.eti.pg.lab.student.services.StudentService;

import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentController {

	private final StudentService studentService;
	private final FacultyService facultyService;

	public StudentController(StudentService studentService, FacultyService facultyService) {
		this.studentService = studentService;
		this.facultyService = facultyService;
	}

	@Autowired

	@GetMapping
	public ResponseEntity<GetStudentsResponse> getStudents() {
		return ResponseEntity.ok(GetStudentsResponse.entityToDtoMapper().apply(studentService.findAll()));
	}

	@GetMapping("{index}")
	public ResponseEntity<GetStudentResponse> getStudent(@PathVariable("index") int index) {
		Optional<Student> student = studentService.find(index);
		return student.map(s -> ResponseEntity.ok(GetStudentResponse.entityToDtoMapper().apply(s)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Void> createStudent(@RequestBody CreateStudentRequest request,
											  UriComponentsBuilder builder) {
		Student student = CreateStudentRequest
				.dtoToEntityMapper(name -> facultyService.find(name).orElseThrow()).apply(request);
		student = studentService.create(student);
		return  ResponseEntity.created(
				builder.pathSegment("api", "students", "{index}")
						.buildAndExpand(student.getIndexNumber()).toUri()).build();
	}

	@DeleteMapping("{index}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("index") int index) {
		Optional<Student> student = studentService.find(index);
		if (student.isPresent()) {
			studentService.delete(student.get());
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("{index}")
	public ResponseEntity<Void> updateStudent(@RequestBody UpdateStudentRequest request,
											  @PathVariable("index") int index) {
		Optional<Student> student = studentService.find(index);
		if (student.isPresent()) {
			UpdateStudentRequest.dtoToEntityUpdater().apply(student.get(), request);
			studentService.update(student.get());
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.notFound().build();
	}



	@GetMapping("fieldOfStudies")
	public ResponseEntity<GetFieldsOfStudyResponse> getFieldsOfStudy() {
		return ResponseEntity.ok(GetFieldsOfStudyResponse.entityToDtoMapper().apply(studentService.findAll()));
	}
}
