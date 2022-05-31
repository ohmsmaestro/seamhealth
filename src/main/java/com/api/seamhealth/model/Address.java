package com.api.seamhealth.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "doctor")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "home_address")
    private String address;

    @Column(name = "state")
    private String state;

    @Column(name = "lga")
    private String lga;

    @OneToOne(mappedBy = "address")
    private Doctor doctor;
}
