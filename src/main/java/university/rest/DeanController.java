package university.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import university.enitity.Dean;
import university.repository.DeanRepository;

import java.util.List;

@RestController

public class DeanController {

    @Autowired
    DeanRepository deanRepository;

    @GetMapping(value = "/dean/all")
    public List<Dean> getAllDeans() {
        return deanRepository.findAll();
    }

    @PostMapping(value = "/dean/add")
    public void saveDean(@RequestBody Dean dean) {
        deanRepository.save(dean);
    }
}
