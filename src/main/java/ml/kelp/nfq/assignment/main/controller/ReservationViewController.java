package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// controller that allows user to view and edit a single reservation
@Controller
public class ReservationViewController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservation/view/{secret}")
    public String viewReservation(@PathVariable String secret, Model model) {
        Reservation res = reservationRepository.findByCustomerSecret(secret);
        if (res == null) {
            return "reservationNotFound";
        }

        model.addAttribute("reservation", res);
        return "reservationView";
    }
}
