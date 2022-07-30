package HospitalManagementSystem.Backend.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import HospitalManagementSystem.Backend.model.Patient;
import HospitalManagementSystem.Backend.service.PatientService;

@RestController
public class patientController {
	@Autowired
	private PatientService patientService;
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		
		return patientService.createPatient(patient);
	}
	@GetMapping("/patients/{id}")
	public Optional<Patient> getPatientById(@PathVariable long id) {
		return patientService.getPatientById(id);
	}
}
