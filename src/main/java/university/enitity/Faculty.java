package university.enitity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString

public class Faculty {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255)
    private String nameFaculty;

//    @OneToOne(cascade = CascadeType.ALL)
//    private ContactDetails contactDetails;

    @Column(nullable = false)
    private String department;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private final LocalDate dateFaculty = LocalDate.now();

    @ManyToMany
    @JoinTable(
            name = "faculty_dean",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "dean_id"))
    private Set<Dean> deans;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Student> students;

    @Column(nullable = false)
    private String dean;

    @Column
    private boolean available;

    @Column
    private Integer quantity = 0;

    @ManyToOne
    private MyUser user;

}
