package ml.kelp.nfq.assignment.main.controller;


import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.exceptions.ReservationNotFoundException;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ReservationRestController { // read-only, as all other interactions with reservations are form-powered

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    List<Reservation> all() {

        List<Reservation> raw = reservationRepository.findAll();
        List<Reservation> redacted = new ArrayList<Reservation>();

        for (Reservation res : raw) {

            Specialist spec = res.getSpecialist();
            //spec.setEmail("");
            spec.setPassword("");
            spec.setReservations(null);
            spec.setRoles(null);

            res.setCustomer(null);
            res.setSpecialist(spec);
            res.setCustomerSecret("");
            redacted.add(res);
        };

        return redacted;
    }

    @GetMapping("/reservations/{id}")
    Reservation getById(@PathVariable int id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }
}
