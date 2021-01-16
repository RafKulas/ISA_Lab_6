package pl.edu.eti.pg.lab.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.eti.pg.lab.student.entity.Student;
import pl.edu.eti.pg.lab.student.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	private final StudentRepository repository;

	@Autowired
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public Optional<Student> find(Integer primaryKey) {
		return repository.findById(primaryKey);
	}

	public List<Student> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void delete(Student entity) {
		repository.delete(entity);
	}

	@Transactional
	public Student create(Student entity) {
		return repository.save(entity);
	}

	@Transactional
	public void update(Student entity) {
		repository.save(entity);
	}
}
