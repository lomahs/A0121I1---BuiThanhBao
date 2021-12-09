import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ShowtimeService} from "../showtime.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-add-showtime',
  templateUrl: './add-showtime.component.html',
  styleUrls: ['./add-showtime.component.css']
})
export class AddShowtimeComponent implements OnInit {

  // @ts-ignore
  form: FormGroup;

  constructor(private fb: FormBuilder, private service: ShowtimeService,
              private router: Router, private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.form = this.fb.group({
      name: ['', Validators.required],
      date: ['', [Validators.required, this.isAfterToday]],
      numberOfTickets: [0, [Validators.min(1)]],
      idShow: ['']
    })
  }

  addShowtime() {
    if (this.form.valid) {

      this.service.getAllShowtime().subscribe(
        data => {
          console.log(data)
          this.form.value.idShow = "CI - " + data.length;

          this.service.addShowtime(this.form.value).subscribe(
            () => {
              this.router.navigateByUrl("").then(
                () => this.snackBar.open("Add successful")._dismissAfter(3000)
              )
            }
          )
        }
      )
    }
  }

  isAfterToday(date: AbstractControl) {
    if (new Date(date.value) < new Date()) {
      return {'invalidDate': true}
    }
    return null;
  }
}
