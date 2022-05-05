package university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import university.enitity.Dean;

@Repository

public interface DeanRepository extends JpaRepository<Dean, Long> {

}
