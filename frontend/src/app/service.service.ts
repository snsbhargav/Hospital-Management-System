import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { Doctor } from './Doctor';
import { HttpClient } from '@angular/common/http'
import { Patient } from './Patient';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private HttpOptions = {};
  constructor(private httpClient:HttpClient) { }
  docURL:string = "http://localhost:8080/doctors";
  patURL:string = "http://localhost:8080/patients"
  getDoctorDetails():Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(`${this.docURL}`);
  }
  addDoctorDetails(doctor:Doctor):Observable<Doctor>{
    return this.httpClient.post<Doctor>(`${this.docURL}`,doctor);
  }
  addPatientDetails(patient:Patient):Observable<Patient>{
    return this.httpClient.post<Patient>(`${this.patURL}`,patient);
  }
  getDoctorById(id:number):Observable<Doctor>{
    return this.httpClient.get<Doctor>(`${this.docURL}/${id}`);
  }
  updateDoctorById(id:number,doctor:Doctor):Observable<Doctor>{
    return this.httpClient.put<Doctor>(`${this.docURL}/${id}`,doctor);
  }
  getPatientById(id:number):Observable<Patient>{
    return this.httpClient.get<Patient>(`${this.patURL}/${id}`);
  }
}
