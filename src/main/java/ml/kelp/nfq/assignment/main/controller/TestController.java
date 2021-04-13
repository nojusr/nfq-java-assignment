package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ml.kelp.nfq.assignment.main.repository.SpecialistRepository;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private SpecialistRepository specialistRepo;

    private List<Specialist> specialistList;

    @GetMapping("/")
    public String test(Model model) {

        specialistList = specialistRepo.findAll();

        model.addAttribute("specialists", specialistRepo.findAll());
        return "test"; //apparently this has to be a template name
    }
}