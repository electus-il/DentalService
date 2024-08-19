package com.example.patientms.API;

import com.example.patientms.Dto.Request.PatientRequestDto;
import com.example.patientms.Dto.Response.PatientResponseDto;
import com.example.patientms.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<Long> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        return new ResponseEntity<>(patientService.create(patientRequestDto) , CREATED);
    }

    @GetMapping("/findById")
    public PatientResponseDto findById(@RequestParam Long id){
        return patientService.findById(id);
}

    @GetMapping("/all")
    public Page<PatientResponseDto> getAll(Pageable pageable){
        return patientService.getAllPatient(pageable);
}




}
