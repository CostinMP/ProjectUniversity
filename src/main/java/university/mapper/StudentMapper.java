package university.mapper;

import university.enitity.Student;
import university.rest.model.StudentDTO;

public class StudentMapper {

    public static Student fromDTOToEntity(StudentDTO studentDTO){
        return new Student(studentDTO.getNameStudent(), studentDTO.getEmailStudent(), studentDTO.getAddressStudent(), studentDTO.getPhoneNumberStudent());
    }

    public static StudentDTO fromEntityToDTO(Student student){
        return new StudentDTO(student.getId(), student.getNameStudent());
    }
}
