package university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import university.enitity.MyUser;

@Repository

public interface UserRepository extends JpaRepository<MyUser, Long> {

    MyUser findByUsernameIgnoreCase(String name);

    MyUser findByEmail(String username);

    MyUser findByRandomToken(String randomToken);

}
