package com.example.demo.services;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientImpl implements  PatientService{


    private final PatientRepository patientRepository;

    public PatientImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    @Override
    public void addPatient(Patient patient) {
       patientRepository.save(patient);

    }


    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);

    }
    @Override
    public void deletePatient(int patientId) {
      patientRepository.deleteById(patientId);
    }

    @Override
    public Patient getPatientById(int patientId) {
      return patientRepository.getReferenceById(patientId);
    }

    @Override
    public List<Patient> getPatientByName(String patientName) {
      return  patientRepository.findByName(patientName);
    }
}
