import { DatePipe } from "@angular/common";

export class Patient{
    id!:number;
    age!:number;
    name!:string;
    vistedDoctor!:string;
    dateOfVisit!:Date;
    prescription!:string;
}