package com.api.seamhealth.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doctor", uniqueConstraints = {
        @UniqueConstraint(
                name = "email_and_phone_constraint",
                columnNames = {"email", "phone"}
        )
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//@ToString(exclude = "address")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

}
