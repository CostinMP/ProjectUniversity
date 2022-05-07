package university.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString

public class Dean {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String lastNameDean;

    @Column(nullable = false, length = 30)
    private String firstNameDean;

//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = Titles.class)
//    private Set<Titles> titles;

   @OneToOne(cascade = CascadeType.ALL)
   @JsonIgnore
   private ContactDetails contactDetails;


    @ToStringExclude
    @JsonIgnore
    @ManyToMany(mappedBy = "deans")
    private Set<Faculty> faculties;

}
