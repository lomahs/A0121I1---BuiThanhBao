import {Component, OnInit} from '@angular/core';
import {ContractDetail} from "../../model/contract/ContractDetail";
import {ContractService} from "../../service/contract.service";

@Component({
  selector: 'app-list-customer-using-service',
  templateUrl: './list-customer-using-service.component.html',
  styleUrls: ['./list-customer-using-service.component.css']
})
export class ListCustomerUsingServiceComponent implements OnInit {

  listContractDetail: Array<ContractDetail> = [];

  constructor(
    private contractService: ContractService
  ) {
  }

  ngOnInit(): void {
    this.updateList()
  }

  updateList() {
    this.contractService.getAllContractDetail().subscribe(
      data => this.listContractDetail = data
    )
  }
}
