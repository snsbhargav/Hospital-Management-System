package HospitalManagementSystem.Backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import HospitalManagementSystem.Backend.controller.doctorController;
import HospitalManagementSystem.Backend.model.Doctor;
import HospitalManagementSystem.Backend.service.DoctorService;

//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value=doctorController.class)
class BackendApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DoctorService doctorService;
	
	@Test
	public void testCreateDoctor() throws Exception {
		
		Doctor mockDoctor = new Doctor();
		mockDoctor.setId(1);
		mockDoctor.setName("Martin");
		mockDoctor.setAge(22);
		mockDoctor.setGender("M");
		mockDoctor.setSpecialization("Throat");
		
		
		String inputInJson = this.mapToJson(mockDoctor);
		
		String URI = "/doctors";
		
		Mockito.when(doctorService.addDoctor(Mockito.any(Doctor.class))).thenReturn(mockDoctor);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
//		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(outputInJson,inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testGetDoctorById() throws Exception {
		Doctor mockDoctor = new Doctor();
		mockDoctor.setId(100);
		mockDoctor.setName("Martin");
		mockDoctor.setAge(22);
		mockDoctor.setGender("M");
		mockDoctor.setSpecialization("Throat");
		
		Mockito.when(doctorService.getDoctorById(Mockito.anyLong())).thenReturn(mockDoctor);
		
		String URI = "/doctors/100";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(mockDoctor);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson,expectedJson);
	}
	
	@Test
	public void testGetAllDoctors() throws Exception {

		Doctor mockDoctor1 = new Doctor();
		mockDoctor1.setId(100);
		mockDoctor1.setName("Martin");
		mockDoctor1.setAge(22);
		mockDoctor1.setGender("M");
		mockDoctor1.setSpecialization("Throat");
		
		Doctor mockDoctor2 = new Doctor();
		mockDoctor2.setId(100);
		mockDoctor2.setName("Martin");
		mockDoctor2.setAge(22);
		mockDoctor2.setGender("M");
		mockDoctor2.setSpecialization("Throat");
		
		List<Doctor> doctorList = new ArrayList<>();
		doctorList.add(mockDoctor1);
		doctorList.add(mockDoctor2);
		
		Mockito.when(doctorService.getAllDoctors()).thenReturn(doctorList);
		
		String URI = "/doctors";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(doctorList);
		String outputInJson = result.getResponse().getContentAsString();
		assertEquals(outputInJson,expectedJson);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
