package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.services.PatientImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private final PatientImpl patientImpl;

    public PatientController( PatientImpl patientImpl) {
        this.patientImpl = patientImpl;
    }

    @GetMapping("/")
    public String getAllPatients(Model model) {
        model.addAttribute("patientList", patientImpl.getAllPatients());
        return "index";
    }


    @GetMapping("/showAddPatient")
    public String showAddPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatientForm";
    }

    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult) {
        System.out.println(bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println("Contains error");
            return "addPatientForm";
        }
        patientImpl.addPatient(patient);
        return "redirect:/";
    }

    @GetMapping("/showUpdatePatient/{id}")
    public String showUpdateEmployee(@PathVariable(value = "id") int id, Model model) {
        Patient patient = patientImpl.getPatientById(id);
        patient.setDateOfBirth(patient.getDateOfBirth().toString());
        model.addAttribute("patient", patient);
        return "updatePatientForm";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute("patient") Patient patient) {
        patientImpl.updatePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") int id, Model model) {
        patientImpl.deletePatient(id);
        return "redirect:/";
    }

    @GetMapping("/searchPatient")
    public String searchEmployee(@RequestParam String patientName, Model model) {
        model.addAttribute("patientList", patientImpl.getPatientByName(patientName));
        return "index";
    }
}
