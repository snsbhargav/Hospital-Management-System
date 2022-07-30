import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../Patient';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-show-patient-details',
  templateUrl: './show-patient-details.component.html',
  styleUrls: ['./show-patient-details.component.css']
})
export class ShowPatientDetailsComponent implements OnInit {
  data!:number;
  patient:Patient = new Patient();
  constructor(private service:ServiceService,private router:Router) { }
  
  ngOnInit(): void {
    
  }
  patientData(e:any){
    console.log(this.data);
    this.service.getPatientById(this.data).subscribe(pat=>{
      if(pat==null){
        this.router.navigate(["show-patient-details"]);
        alert("No such Patient with Id: "+ this.data +" found in database!!");
      }
      else
        this.patient = pat;
    });
  }

}
