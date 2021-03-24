class MyDate {
  constructor(day, month, year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  getDay() {
    return this.day;
  }

  getMonth() {
    return this.month;
  }

  getYear() {
    return this.year;
  }

  setDay(day) {
    this.day = day;
  }

  setMonth(month) {
    this.month = month;
  }

  setYear(year) {
    this.year = year;
  }
}

var date1 = new MyDate(10, 12, 1999);
date1.setDay(30);
console.log(date1.getDay(), date1.getMonth(), date1.getYear());
