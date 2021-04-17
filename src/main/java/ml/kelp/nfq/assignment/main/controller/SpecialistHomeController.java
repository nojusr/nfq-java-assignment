package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import ml.kelp.nfq.assignment.main.service.ReservationQueueCountService;
import ml.kelp.nfq.assignment.main.utils.SpecialistUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import java.util.List;

@Controller
public class SpecialistHomeController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationQueueCountService queueCountService;

    // Impossible to access without auth -- configured via WebSecurityConfig
    @RequestMapping("/home")
    public String specialistHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Specialist specialist = ((SpecialistUserDetails)auth.getPrincipal()).getSpecialist();

        // might need to access via repository
        List<Reservation> specialistReservations = reservationRepository.findBySpecialistOrderByTimeAddedDesc(specialist);

        specialistReservations.removeIf(res -> (res.isFinished()));
        
        for (Reservation res : specialistReservations) {



            res.setQueueNumber(queueCountService.getReservationQueueNumber(res));
        }

        model.addAttribute("reservations", specialistReservations);

        return "specialistHome";
    }

}
