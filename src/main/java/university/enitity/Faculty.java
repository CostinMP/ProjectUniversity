package university.enitity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data

public class Faculty {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255)
    private String nameFaculty;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;

    @Column(nullable = false, unique = true)
    private String department;

    @ManyToMany
    @JoinTable(
            name = "faculty_dean",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "dean_id"))
    private Set<Dean> deans;

    @Column(nullable = false)
    private String dean;

    @Column
    private boolean available;

    @Transient
    @Column(nullable = false, length = 2)
    private Integer quantity;


    @ManyToOne
    private MyUser user;


}
