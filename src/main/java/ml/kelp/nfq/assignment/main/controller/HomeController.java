package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SpecialistRepository specialistRepo;

    private List<Specialist> specialistList;

    @GetMapping("/")
    public String home(Model model) {
        return "welcome"; //apparently this has to be a template name
    }
}