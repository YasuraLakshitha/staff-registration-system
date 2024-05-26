package edu.icet.hrms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StaffMember {
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
