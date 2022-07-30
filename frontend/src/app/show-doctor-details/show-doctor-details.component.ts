import { Component, OnInit } from '@angular/core';
import { Doctor } from '../Doctor';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-show-doctor-details',
  templateUrl: './show-doctor-details.component.html',
  styleUrls: ['./show-doctor-details.component.css']
})
export class ShowDoctorDetailsComponent implements OnInit {
  doctors!: Doctor[];
  doctor:Doctor = new Doctor;
  constructor(private service: ServiceService) { }
  update(e:any,numb:string){
    console.log(numb);
    this.service.getDoctorById(Number(numb)).subscribe(data=>{
      this.doctor = data;
      console.log(data);
    });
}
  ngOnInit(): void {
    this.service.getDoctorDetails().subscribe(data=>{
      this.doctors = data;
    });
  }

}
