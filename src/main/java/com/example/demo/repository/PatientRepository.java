package com.example.demo.repository;

import com.example.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
        @Query(value = "SELECT * FROM patient WHERE name = ?1", nativeQuery = true)
        List<Patient> findByName(String name);

        @Query(value = "SELECT * FROM patient WHERE age > 18 ORDER BY name ASC", nativeQuery = true)
        List<Patient> getAllPatients();
}
