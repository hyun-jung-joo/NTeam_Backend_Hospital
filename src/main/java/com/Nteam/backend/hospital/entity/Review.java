package com.Nteam.backend.hospital.entity;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity(name = "Review")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;
}