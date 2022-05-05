package university.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data

public class Dean {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String lastNameDean;

    @Column(nullable = false, length = 30)
    private String firstNameDean;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Titles.class)
    private Set<Titles> titles;

   @OneToOne(cascade = CascadeType.ALL)
   @JsonIgnore
   private ContactDetails contactDetails;


    @OneToOne(mappedBy = "dean", cascade = CascadeType.ALL)
    @JsonIgnore
    private Faculty faculty;

}
