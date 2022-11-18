package com.latihan.postgres.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Students implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "place_of_birth")
    private String place_of_birth;

    @Column(name = "date_of_birth")
    private String date_of_birth;

    @Column(name = "month_of_birth")
    private String month_of_birth;

    @Column(name = "year_of_birth")
    private String year_of_birth;

    @Column(name = "address")
    private String address;
}

