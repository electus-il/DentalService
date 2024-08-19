package com.example.patientms.Service.Iml;

import com.example.commonms.Exception.ErrorMessage;
import com.example.commonms.Exception.PatientAlreadyException;
import com.example.commonms.Exception.PatientNotFoundException;
import com.example.patientms.Config.PatientMapper;
import com.example.patientms.Dto.Request.PatientRequestDto;
import com.example.patientms.Dto.Response.PatientResponseDto;
import com.example.patientms.Model.Patient;
import com.example.patientms.Repository.PatientRepo;
import com.example.patientms.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final PatientMapper patientMapper;

    @Override
    public Long create(PatientRequestDto patientRequestDto) {
        Optional<PatientRequestDto> byEmail = patientRepo.findByEmail(patientRequestDto.getEmail());
        if (byEmail.isPresent()) {
            throw new PatientAlreadyException(ErrorMessage.PATIENT_ALREADY_EXCEPTION);
        }

        Patient patient = patientMapper.RequestDtoToPatient(patientRequestDto);
        Patient savedPatient = patientRepo.save(patient);

        return savedPatient.getId();

    }

    @Override
    public PatientResponseDto findById(Long id) {
        Patient patient = patientRepo.findById(id).orElseThrow(() ->
                new PatientNotFoundException(ErrorMessage.PATIENT_NOT_FOUND_EXCEPTION));
        return patientMapper.PatientToResponseDto(patient);


    }

    @Override
    public Page<PatientResponseDto> getAllPatient(Pageable pageable) {
        Page<Patient> findAll = patientRepo.findAll(pageable);
        if (findAll.isEmpty()){
            throw new PatientNotFoundException(ErrorMessage.PATIENT_NOT_FOUND_EXCEPTION);
        }
        List<PatientResponseDto> responseDtos = findAll.getContent().stream()
                .map(patient -> PatientResponseDto.builder()
                        .name(patient.getName())
                        .surname(patient.getSurname())
                        .age(patient.getAge())
                        .email(patient.getEmail())
                        .dateOfBirth(patient.getDateOfBirth())
                        .gender(patient.getGender())
                        .build()).toList();

        return new PageImpl<>(responseDtos, pageable, findAll.getTotalElements());
    }
}
