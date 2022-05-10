package university.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.enitity.Faculty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor

public class StudentDTO {


    private Long id;


    private String nameStudent;


    private String emailStudent;


    private String phoneNumberStudent;


    private String addressStudent;


    private Faculty faculty;



    public StudentDTO(Long id, String nameStudent) {
    }
}
