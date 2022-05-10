package university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import university.enitity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
