import {Contract} from "./Contract";
import {AttachService} from "../service/AttachService";

export interface ContractDetail {
  id: number,
  contract: Contract,
  attachService: AttachService,
  quantity: number
}
