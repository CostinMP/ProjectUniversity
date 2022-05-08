package university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import university.enitity.ContactDetails;

public interface ContactRepository extends JpaRepository<ContactDetails, Long> {
}
