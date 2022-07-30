package HospitalManagementSystem.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import HospitalManagementSystem.Backend.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
