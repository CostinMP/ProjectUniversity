package university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import university.enitity.Faculty;

import java.util.List;

@Repository

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findAByNameFacultyContaining(String name);
}
