import {Component, OnInit} from '@angular/core';
import {RentType} from "../../model/service/RentType";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-form-add-service',
  templateUrl: './form-add-service.component.html',
  styleUrls: ['./form-add-service.component.css']
})
export class FormAddServiceComponent implements OnInit {

  listRentType: Array<RentType> = new Array<RentType>();
  formAddService: FormGroup;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
  }

  createForm() {
    this.formAddService = this.formBuilder.group({
      name: [],
      area: [],
      numberOfFloors: [],
      maxPeople: [],
      cost: [],
      rentType: [],
      status: []
    })
  }


  addService() {

  }
}
