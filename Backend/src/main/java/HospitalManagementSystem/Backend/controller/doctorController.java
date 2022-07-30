package HospitalManagementSystem.Backend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import HospitalManagementSystem.Backend.model.Doctor;
import HospitalManagementSystem.Backend.service.DoctorService;

@RestController
public class doctorController {
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/doctors")
	public List<Doctor> getDoctors() {
		return doctorService.getAllDoctors();
	}
	
	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	@GetMapping("/doctors/{id}")
	public Doctor getDoctorById(@PathVariable long id) {
		return doctorService.getDoctorById(id);
	}
	@PutMapping("/doctors/{id}")
	public Doctor updateDoctor(@PathVariable long id,@RequestBody Doctor modDoctor) {
		
		return doctorService.updateDoctor(id,modDoctor);
	}
}
