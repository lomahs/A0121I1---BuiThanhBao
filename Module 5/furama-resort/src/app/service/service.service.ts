import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Service} from "../model/service/Service";
import {HttpClient} from "@angular/common/http";
import {RentType} from "../model/service/RentType";
import {AttachService} from "../model/service/AttachService";

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  readonly api_service = "http://localhost:3000/service";
  readonly api_rentType = "http://localhost:3000/rentType";
  readonly api_attachService = "http://localhost:3000/attachService";

  constructor(
    private http: HttpClient
  ) {
  }

  getAllServices(): Observable<Array<Service>> {
    return this.http.get<Array<Service>>(this.api_service);
  }

  getAllRentTypes(): Observable<Array<RentType>> {
    return this.http.get<Array<RentType>>(this.api_rentType);
  }

  addService(service: Service) {
    return this.http.post(this.api_service, service);
  }

  getAllAttachService(): Observable<Array<AttachService>> {
    return this.http.get<Array<AttachService>>(this.api_attachService);
  }

  getServiceById(id: number): Observable<Service> {
    return this.http.get<Service>(this.api_service + "/" + id);
  }

  editService(service: Service) {
    return this.http.put(this.api_service + "/" + service.id, service);
  }

  deleteServiceById(id: any) {
    return this.http.delete(this.api_service + "/" + id);
  }
}
