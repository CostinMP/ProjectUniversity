package university.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import university.enitity.Faculty;
import university.repository.DeanRepository;
import university.repository.FacultyRepository;
import university.repository.UserRepository;

import java.util.List;

@Controller

public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DeanRepository deanRepository;


    @PostMapping(value = "/faculty/add")
    public String saveFaculty(@RequestBody Faculty faculty) {
        facultyRepository.save(faculty);
        return "all-faculties";
    }

    @GetMapping(value = "/faculty/save")
    public String saveFacultyForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "add-faculties";
    }

//    @PostMapping(value = "/faculty/save")
//    public String saveFaculty(@ModelAttribute("faculty") @RequestBody Faculty faculty, RedirectAttributes redirectAttributes) {
//        if(faculty.getQuantity() > 0){
//            faculty.setAvailable(true);
//        }else if(faculty.getQuantity() == 0){
//            faculty.setAvailable(false);
//        }
//        facultyRepository.save(faculty);
//        redirectAttributes.addFlashAttribute("message", "The faculty has been saved successfully.");
//        return "redirect:/faculty/save";
//    }

    @PostMapping(value = "/faculty/save")
    public String saveFaculty(@ModelAttribute("faculty") @RequestBody Faculty faculty, RedirectAttributes redirectAttributes) {
        facultyRepository.save(faculty);
        redirectAttributes.addFlashAttribute("message", "The faculty has been successfully saved.");
        return "redirect:/faculty/save";
    }

    @GetMapping(value = "/faculty/all")
    public String getAllFaculties(Model model) {
        model.addAttribute("faculties", facultyRepository.findAll());
        return "all-faculties";
    }

    @DeleteMapping(value = "/faculty/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyRepository.deleteById(id);
    }

    @GetMapping(value = "/faculty/name/{name}")
    public List<Faculty> getFacultyByName(@PathVariable(value = "name") String nameFaculty) {
        return facultyRepository.findAByNameFacultyContaining(nameFaculty);
    }

    @GetMapping("/faculty/delete/{id}")
    public String deleteFaculty(@PathVariable("id") Long id, Model model) {
        facultyRepository.deleteById(id);
        return "redirect:/faculty/all";
    }

    @GetMapping("/faculty/update/{id}")
    public String facultyUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("faculty", facultyRepository.getById(id));
        return "update-faculty";
    }

    @RequestMapping("/faculty/update/{id}")
    public String updateFaculty(@PathVariable("id") Long id, @ModelAttribute Faculty newFaculty, Model model) {
        Faculty oldFaculty = facultyRepository.getById(id);
        try {
            if (newFaculty.getNameFaculty() != null) {
                oldFaculty.setNameFaculty(newFaculty.getNameFaculty());
            }
            if (newFaculty.getDepartment() != null) {
                oldFaculty.setDepartment(newFaculty.getDepartment());
            }
            if (newFaculty.getDean() != null) {
                oldFaculty.setDean(newFaculty.getDean());
            }
            if (newFaculty.getQuantity() != null) {
                if (newFaculty.getQuantity() == 0) {
                    oldFaculty.setAvailable(false);
                } else {
                    oldFaculty.setAvailable(true);
                }
                oldFaculty.setQuantity(newFaculty.getQuantity());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("faculty", oldFaculty);
        facultyRepository.save(oldFaculty);
        return "redirect:/faculty/all";
    }

}
