package university.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nameStudent;

    @Column(nullable = false, unique = true)
    private String emailStudent;

    @Column(nullable = false, unique = true)
    private String phoneNumberStudent;

    @Column(nullable = false)
    private String addressStudent;


    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Student(String nameStudent, String emailStudent, String addressStudent, String phoneNumberStudent) {
    }
}
