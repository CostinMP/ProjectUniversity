package university.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import university.enitity.Faculty;
import university.enitity.Student;
import university.repository.FacultyRepository;
import university.repository.StudentRepository;

import java.util.List;


@Controller

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyRepository facultyRepository;


    @GetMapping(value = "/student/save/{id}")
    public String saveStudent( @PathVariable Long id, Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("faculty",  facultyRepository.getById(id));
        return "add-students";
    }

    @PostMapping(value = "/student/save/{id}")
    public String saveStudent(@ModelAttribute("student") Student student, @PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Faculty faculty = facultyRepository.getById(id);
        student.setFaculty(faculty);
        studentRepository.save(student);
        faculty.setStudents(List.of(student));
        model.addAttribute("student", student);
        model.addAttribute("faculty", faculty);
        redirectAttributes.addFlashAttribute("message", "The student has been successfully saved.");
        return "redirect:/student/save/{id}";
    }


    @GetMapping(value = "/student/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "all-students";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        studentRepository.deleteById(id);
        return "redirect:/student/all";
    }

}
