package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Customer;
import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.repository.CustomerRepository;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import ml.kelp.nfq.assignment.main.repository.SpecialistRepository;
import ml.kelp.nfq.assignment.main.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

// reservation add page controller -- used for adding reservations
// user should be able to: select reservation, select specialist, enter their name,
@Controller
public class ReservationAddController {

    @Autowired
    SpecialistRepository specialistRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    CustomerRepository customerRepository;

    RandomString rString = new RandomString(16);

    Random r = new Random();

    @GetMapping(value = "/reservation/add")
    public String reservationAddGet(Model model) {

        List<Specialist> specialists = specialistRepository.findAll();

        Reservation res = new Reservation();
        res.setSpecialist(new Specialist());
        res.setCustomer(new Customer());

        model.addAttribute("specialists", specialists);
        model.addAttribute("reservation", res);
        return "reservationAdd";
    }

    @PostMapping(value = "/reservation/add")
    public String reservationAddPost(@ModelAttribute Reservation reservation, Model model) {
        String rand = rString.nextString();
        reservation.setCustomerSecret(rand);
        reservation.setIsVisiting(false);
        reservation.setShortId(r.nextInt(999));
        reservation.setSpecialist(specialistRepository.findById(reservation.getSpecialist().getId()));

        customerRepository.save(reservation.getCustomer());
        reservationRepository.save(reservation);
        reservationRepository.flush();
        return "temp";
    }

}
