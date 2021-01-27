package pl.edu.eti.pg.lab.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.eti.pg.lab.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
