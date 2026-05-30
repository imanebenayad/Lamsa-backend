package com.Lamsa.service;

import com.Lamsa.entity.Reservation;
import com.Lamsa.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // add reservation
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    // get all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
