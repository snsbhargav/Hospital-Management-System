import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { ShowDoctorDetailsComponent } from './show-doctor-details/show-doctor-details.component';
import { ShowPatientDetailsComponent } from './show-patient-details/show-patient-details.component';

const routes: Routes = [
  {path:"add-doctor",component:AddDoctorComponent},
  {path:"add-patient",component:AddPatientComponent},
  {path:"show-doctor-details",component:ShowDoctorDetailsComponent},
  {path:"show-patient-details",component:ShowPatientDetailsComponent},
  {path:"",redirectTo:"add-doctor",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
