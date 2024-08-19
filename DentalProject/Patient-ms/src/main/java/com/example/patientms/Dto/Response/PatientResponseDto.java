package com.example.patientms.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientResponseDto {
    String name;
    String surname;
    Integer age;
    String gender;
    String phoneNumber;
    LocalDateTime dateOfBirth;
    String email;
}
