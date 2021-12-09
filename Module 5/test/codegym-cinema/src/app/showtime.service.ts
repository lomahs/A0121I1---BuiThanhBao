import {Injectable} from '@angular/core';
import {Showtime} from "./showtime";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ShowtimeService {

  readonly api = " http://localhost:3000/showtime"

  constructor(private http: HttpClient) {
  }

  addShowtime(showtime: Showtime) {
    return this.http.post(this.api, showtime);
  }

  getAllShowtime(): Observable<Array<Showtime>> {
    return this.http.get<Array<Showtime>>(this.api);
  }

  getShowtimeById(id: any): Observable<Showtime> {
    return this.http.get<Showtime>(this.api + "/" + id);
  }

  deleteShowtimeById(id: any) {
    return this.http.delete(this.api + "/" + id);
  }

}
