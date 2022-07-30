import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { FormsModule } from '@angular/forms';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { ShowDoctorDetailsComponent } from './show-doctor-details/show-doctor-details.component';
import { ShowPatientDetailsComponent } from './show-patient-details/show-patient-details.component';
@NgModule({
  declarations: [
    AppComponent,
    AddDoctorComponent,
    AddPatientComponent,
    ShowDoctorDetailsComponent,
    ShowPatientDetailsComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
