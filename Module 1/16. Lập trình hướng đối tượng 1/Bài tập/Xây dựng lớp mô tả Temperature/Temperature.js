class Temperature {
  constructor(celsius) {
    this.celsius = celsius;
  }

  getCelsius() {
    return this.celsius;
  }

  convertCtoF() {
    return this.celsius * 1.8 + 32;
  }

  convertCtoK() {
    return this.celsius + 273.15;
  }
}
