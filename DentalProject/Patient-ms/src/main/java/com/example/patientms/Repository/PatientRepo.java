package com.example.patientms.Repository;

import com.example.patientms.Dto.Request.PatientRequestDto;
import com.example.patientms.Dto.Response.PatientResponseDto;
import com.example.patientms.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient , Long> {
   Optional<PatientRequestDto> findByEmail(String email);
}
