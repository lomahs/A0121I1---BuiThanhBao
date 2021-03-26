export class SwitchButton{
    constructor(status, lamp){
        this.status = status;
        this.lamp = lamp;
    }

    connectToLamp(lamp){
        this.lamp = lamp;
    }

    switchOff(){
        this.status = 0;
        console.log("Lamp is off");
    }

    switchOn() {
        this.status = 1;
        console.log("Lamp is on");
    }
}