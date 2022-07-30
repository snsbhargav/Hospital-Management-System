import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../Doctor';
import { Patient } from '../Patient';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {
  patient:Patient = new Patient();
  doctors!:Doctor[];
  condition!:Boolean;
  constructor(private service:ServiceService,private router:Router) { }
  ngOnInit(): void {
    this.service.getDoctorDetails().subscribe(data=>{
      this.doctors = data;
    })
    this.condition = false;
  }
  splitted: Array<string> = [];
  update(e:any,ab:String){
      this.splitted=ab.split(",");
    console.log(this.splitted);
  }
  addPatient(){

    this.patient.vistedDoctor=this.splitted[1];
    this.service.addPatientDetails(this.patient).subscribe(data=>{
      console.log(data);
      this.updateDoctorCount();
      this.addPrescription();
      this.router.navigate(["show-doctor-details"]);
    })
  }
  doctor:Doctor = new Doctor();
  updateDoctorCount(){
    const num = Number(this.splitted[0].split(':')[0]);
    this.service.updateDoctorById(num,this.doctor).subscribe(data=>{
    })
  }
  addPrescription(){
    console.log(this.patient.id);    
  }
}
