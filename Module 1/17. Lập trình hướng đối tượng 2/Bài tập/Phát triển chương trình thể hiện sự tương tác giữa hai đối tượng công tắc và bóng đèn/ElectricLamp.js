export class ElectricLamp{
    constructor(status){
        this.status = status;
    }

    turnOn(){
        this.status =1;
    }

    turnOff(){
        this.status = 0;    
    }
}