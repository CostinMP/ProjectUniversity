package university.enitity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class ContactDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 10, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @OneToOne(mappedBy = "contactDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private Dean dean;

    @OneToOne(mappedBy = "contactDetails")
    @JsonIgnore
    private Faculty faculty;

    @OneToOne(mappedBy = "contactDetails")
    @JsonIgnore
    private MyUser user;
}
