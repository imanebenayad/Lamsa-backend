package com.Lamsa.controller;

import com.Lamsa.entity.Reservation;
import com.Lamsa.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation createReservation(
            @RequestParam Long userId,
            @RequestParam Long packageId,
            @RequestParam String date
    ) {
        return reservationService.createReservation(
                userId,
                packageId,
                LocalDate.parse(date)
        );
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
}
