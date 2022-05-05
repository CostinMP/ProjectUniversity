package university.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data

public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String nameDepartment;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Set<Faculty> faculties;


}
