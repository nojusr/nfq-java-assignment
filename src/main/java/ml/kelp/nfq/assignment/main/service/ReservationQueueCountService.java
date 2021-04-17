package ml.kelp.nfq.assignment.main.service;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import ml.kelp.nfq.assignment.main.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationQueueCountService {

    @Autowired
    ReservationRepository reservationRepository;

    public int getReservationQueueNumber(Reservation reservation) {

        //Long specialistID = reservation.getSpecialist().getId();

        List<Reservation> specialistReservations = reservationRepository
                .findBySpecialistOrderByTimeAddedDesc(reservation.getSpecialist());

        if (specialistReservations == null) {
            return 0;
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(specialistReservations);
        System.out.println("-----------------------------------------------------------------------------------------");

        specialistReservations.removeIf(res -> (res.isFinished()));

        for (Reservation res : specialistReservations) {
            System.out.println(res);
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(specialistReservations.size());
        System.out.println("-----------------------------------------------------------------------------------------");


        for (int i = 0; i < specialistReservations.size(); i++) {
            if (specialistReservations.get(i).getId() == reservation.getId()) {
                return specialistReservations.size()-i;
            }
        }

        return 0;
    }

}
