package HospitalManagementSystem.Backend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HospitalManagementSystem.Backend.exception.ResourceNotFoundException;
import HospitalManagementSystem.Backend.model.Doctor;
import HospitalManagementSystem.Backend.repository.DoctorRepository;

@Service
public class DoctorService{
	
	@Autowired
	DoctorRepository doctorRepository;
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	} 
	
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Doctor getDoctorById(long id) {
		return doctorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found exception"));
	}
	
	public Doctor updateDoctor(long id, Doctor modDoctor) {
		Doctor doctor = getDoctorById(id);
		try {
		doctor.setNumOfPatients(doctor.getNumOfPatients()+1);
		}
		catch(ResourceNotFoundException e) {
			return null;
		}
		return doctorRepository.save(doctor);
	}

}
