package ml.kelp.nfq.assignment.main.controller;


import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.exceptions.ReservationNotFoundException;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import ml.kelp.nfq.assignment.main.service.ReservationQueueCountService;
import ml.kelp.nfq.assignment.main.service.SpecialistAppointmentTimeService;
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

    @Autowired
    ReservationQueueCountService queueCountService;

    @Autowired
    SpecialistAppointmentTimeService timeService;

    @GetMapping("/reservations")
    List<Reservation> getAll() {
        List<Reservation> raw = reservationRepository.findAll();
        List<Reservation> sanitized = new ArrayList<Reservation>();

        for (Reservation res : raw) {
            if (res.isFinished()) {
                continue;
            }
            res.setQueueNumber(queueCountService.getReservationQueueNumber(res));
            res.setWaitTime(timeService.getAverageAppointmentTimeOfSpecialist(res.getSpecialist(),10)*(double)res.getQueueNumber());
            sanitized.add(sanitizeReservationForPublicAccess(res));
        }
        return sanitized;
    }

    @GetMapping("/reservations/{id}")
    Reservation getById(@PathVariable int id) {
        Reservation raw = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
        return sanitizeReservationForPublicAccess(raw);
    }

    private Reservation sanitizeReservationForPublicAccess(Reservation input) {
        Specialist spec = input.getSpecialist();
        spec.setPassword("");
        spec.setReservations(null);
        spec.setRoles(null);

        input.setCustomer(null);
        input.setSpecialist(spec);
        input.setCustomerSecret("");
        return input;
    }


}
