package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ml.kelp.nfq.assignment.main.repository.SpecialistRepository;

import java.util.List;

// non-publically accessible page for showing reservations

@Controller
public class HomeController {

    @Autowired
    private SpecialistRepository specialistRepo;

    private List<Specialist> specialistList;

    @GetMapping("/")
    public String home(Model model) {
        specialistList = specialistRepo.findAll();
        model.addAttribute("specialists", specialistRepo.findAll());
        return "home"; //apparently this has to be a template name
    }
}