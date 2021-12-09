import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contract} from "../model/contract/Contract";
import {Observable} from "rxjs";
import {ContractDetail} from "../model/contract/ContractDetail";

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  readonly api_contract = "http://localhost:3000/contract";
  readonly api_contractDetail = "http://localhost:3000/contractDetail";

  constructor(
    private http: HttpClient
  ) {
  }

  addContract(contract: Contract) {
    return this.http.post(this.api_contract, contract);
  }

  getAllContracts(): Observable<Array<Contract>> {
    return this.http.get<Array<Contract>>(this.api_contract);
  }

  addContractDetail(contractDetail: ContractDetail) {
    return this.http.post(this.api_contractDetail, contractDetail);
  }

  getAllContractDetail(): Observable<Array<ContractDetail>> {
    return this.http.get<Array<ContractDetail>>(this.api_contractDetail);
  }
}
