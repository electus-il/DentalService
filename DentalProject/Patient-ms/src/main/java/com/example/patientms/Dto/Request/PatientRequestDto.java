package com.example.patientms.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientRequestDto {
    Long id;
    String name;
    String surname;
    Integer age;
    String gender;
    String phoneNumber;
    LocalDateTime dateOfBirth;
    String email;
    LocalDateTime createDate;
    LocalDateTime updateDate;
}
