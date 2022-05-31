package com.api.seamhealth.controller;

import com.api.seamhealth.dto.request.AddAddressRequest;
import com.api.seamhealth.dto.request.RegisterDoctorRequest;
import com.api.seamhealth.dto.response.AddressResponse;
import com.api.seamhealth.dto.response.DoctorResponse;
import com.api.seamhealth.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> registerDoctor(@RequestBody @Validated RegisterDoctorRequest request){
        return ResponseEntity.ok().body(doctorService.registerDoctor(request));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllDoctors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size){
        Map<String, Object> response = doctorService.getDoctors(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/{doctor_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorResponse> deleteDoctorById(@PathVariable(value = "doctor_id") Long doctor_id){
        DoctorResponse response = doctorService.deleteDoctor(doctor_id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    @GetMapping(value = "/{doctor_id}/doctor",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable(value = "doctor_id") Long doctor_id){
        DoctorResponse response = doctorService.getDoctorById(doctor_id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/{doctor_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorResponse> editDoctor(@PathVariable(value = "doctor_id") Long doctor_id,  @RequestBody RegisterDoctorRequest request){
        DoctorResponse response = doctorService.editDoctor(doctor_id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
