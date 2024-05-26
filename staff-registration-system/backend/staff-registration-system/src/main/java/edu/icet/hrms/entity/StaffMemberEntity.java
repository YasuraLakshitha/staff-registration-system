package edu.icet.hrms.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Staff_Members")
public class StaffMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String email;
    private String address;
    private String dateOfBirth;
    private Long contactNumber;
    private String spacializationArea;
    @JsonProperty
    private boolean isActive;
}
