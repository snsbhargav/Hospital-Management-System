package HospitalManagementSystem.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HospitalManagementSystem.Backend.model.Patient;
import HospitalManagementSystem.Backend.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	public Patient createPatient(Patient patient) {
		
		return patientRepository.save(patient);
	}
	
	public Optional<Patient> getPatientById(long id) {
		return patientRepository.findById(id);
	}
}
