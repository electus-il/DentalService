package com.example.patientms.Service;

import com.example.patientms.Dto.Request.PatientRequestDto;
import com.example.patientms.Dto.Response.PatientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {
    Long create(PatientRequestDto patientRequestDto);

    PatientResponseDto findById(Long id);

    Page<PatientResponseDto> getAllPatient(Pageable pageable);
}
