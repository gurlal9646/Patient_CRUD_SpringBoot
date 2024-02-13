package com.example.demo.services;

import com.example.demo.entity.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatients();
    public void addPatient(Patient patient);
    public void updatePatient(Patient patient);
    public void deletePatient(int patientId);
    public Patient getPatientById(int patientId);
    public  List<Patient>  getPatientByName(String patientName);
}
