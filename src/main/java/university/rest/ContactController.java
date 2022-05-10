package university.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import university.enitity.ContactDetails;
import university.repository.ContactRepository;
import university.repository.DeanRepository;
import university.repository.FacultyRepository;

@Controller

public class ContactController {

//    @Autowired
//    private FacultyRepository facultyRepository;
//
//    @Autowired
//    private DeanRepository deanRepository;

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value ={"/contact"})
    public String contact(){
        return "contact";
    }

//    @PostMapping(value = "/contact/save")
//    public String saveContact(@ModelAttribute("contactDetails") @RequestBody ContactDetails contactDetails, RedirectAttributes redirectAttributes) {
//        contactRepository.save(contactDetails);
//        redirectAttributes.addFlashAttribute("message", "The user has been successfully saved.");
//        return "redirect:/contact/all";
//    }
//
//    @GetMapping(value = "/contact/all")
//    public String getAllContacts(Model model) {
//        model.addAttribute("faculties", contactRepository.findAll());
//        return "all-contacts";
//    }

}
