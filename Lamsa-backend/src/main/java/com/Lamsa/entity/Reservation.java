package com.Lamsa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package pkg;

    public void setUser(User user) {
    }

    public void setPkg(Package pkg) {
    }

    public void setDate(LocalDate date) {
    }

    public void setStatus(String pending) {
    }
}