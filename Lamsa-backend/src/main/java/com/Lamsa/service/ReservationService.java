package com.Lamsa.service;

import com.Lamsa.entity.Package;
import com.Lamsa.entity.Reservation;
import com.Lamsa.entity.User;
import com.Lamsa.repository.PackageRepository;
import com.Lamsa.repository.ReservationRepository;
import com.Lamsa.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final PackageRepository packageRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              UserRepository userRepository,
                              PackageRepository packageRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.packageRepository = packageRepository;
    }

    public Reservation createReservation(Long userId, Long packageId, LocalDate date) {

        User user = userRepository.findById(userId).orElseThrow();
        Package pkg = packageRepository.findById(packageId).orElseThrow();

        Reservation r = new Reservation();
        r.setUser(user);
        r.setPkg(pkg);
        r.setDate(date);
        r.setStatus("PENDING");

        return reservationRepository.save(r);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}