import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../Doctor';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {
  doctor:Doctor = new Doctor();
  constructor(private service:ServiceService,private router:Router) { }

  ngOnInit(): void {
  }
  addDoctor(){
    this.service.addDoctorDetails(this.doctor).subscribe(data=>{
      console.log(data);
      this.router.navigate(["show-doctor-details"]);
    })
  }

}
