package com.example.patientms.Config;

import com.example.patientms.Dto.Request.PatientRequestDto;
import com.example.patientms.Dto.Response.PatientResponseDto;
import com.example.patientms.Model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Configuration;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE , componentModel = "spring")
@Configuration
public interface PatientMapper {

    Patient RequestDtoToPatient (PatientRequestDto patientRequestDto);
    Patient ResponseDtoToPatient(PatientResponseDto patientResponseDto);
    PatientRequestDto PatientToRequestDto(Patient patient);
    PatientResponseDto PatientToResponseDto(Patient patient);

}
