class FlashLamp {
  constructor(battery, status) {
    this.battery = battery;
    this.status = status;
  }

  setBattery(battery) {
    this.battery = battery;
  }

  getBatteryInfo() {
    return this.battery.getEnergy();
  }

  light() {
    if (this.status) alert("Lighting");
    else alert("Not lighting");
  }

  turnOn() {
    this.status = true;
  }

  turnOff() {
    this.status = false;
  }
}
