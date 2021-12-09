import {Component, OnInit} from '@angular/core';
import {AttachService} from "../../../model/service/AttachService";
import {ServiceService} from "../../../service/service.service";
import {ContractService} from "../../../service/contract.service";
import {Contract} from "../../../model/contract/Contract";
import {ContractDetail} from "../../../model/contract/ContractDetail";
import * as $ from 'jquery';

@Component({
  selector: 'app-form-add-contract-detail',
  templateUrl: './form-add-contract-detail.component.html',
  styleUrls: ['./form-add-contract-detail.component.css']
})
export class FormAddContractDetailComponent implements OnInit {

  listContract: Array<Contract>
  listAttachService: Array<AttachService>;
  contractDetail: ContractDetail = new class implements ContractDetail {
    attachService: AttachService;
    contract: Contract;
    id: number;
    quantity: number;
  };

  constructor(
    private serviceService: ServiceService,
    private contractService: ContractService,
  ) {
  }

  ngOnInit(): void {
    this.contractService.getAllContracts().subscribe(
      data => this.listContract = data
    )
    this.serviceService.getAllAttachService().subscribe(
      data => this.listAttachService = data
    );

    $(document).ready(function () {
      $("tr.contractRow").click(function () {
        $("tr.contractRow").not(this).hide();
      })

      $("#showHiddenContract").click(function () {
        $("#listContracts tr:hidden").show();
      });

      $("tr.asRow").click(function () {
        $("tr.asRow").not(this).hide();
      });

      $("#showHiddenAttachService").click(function () {
        $("#listAttachServices tr:hidden").show();
      });
    })
  }

  getContract(contract: Contract) {
    this.contractDetail.contract = contract;
  }

  getAttachService(attachService: AttachService) {
    this.contractDetail.attachService = attachService;
  }


  addContractDetail() {
    this.contractDetail.contract.totalMoney = this.contractDetail.attachService.cost * this.contractDetail.attachService.unit + this.contractDetail.contract.service.cost;
    this.contractService.addContractDetail(this.contractDetail).subscribe();
  }
}
