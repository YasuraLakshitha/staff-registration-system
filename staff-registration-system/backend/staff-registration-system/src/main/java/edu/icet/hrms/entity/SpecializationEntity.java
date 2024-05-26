package edu.icet.hrms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Specialization_Area")
@Data
public class SpecializationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
}
