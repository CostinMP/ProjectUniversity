package university.enitity;

import lombok.Data;

import javax.persistence.*;


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

    @OneToOne(cascade = CascadeType.ALL)
    private Dean dean;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @Column
    private boolean available;

    @Column(nullable = false, length = 2)
    private Integer quantity;


    @ManyToOne
    private MyUser user;


}
