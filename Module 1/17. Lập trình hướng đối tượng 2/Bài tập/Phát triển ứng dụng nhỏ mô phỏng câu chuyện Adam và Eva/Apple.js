export class Apple{
    constructor(weight){
        this.weight = weight
    }

    decrease(){
        if(!this.isEmpty())
            this.weight--;
    }

    isEmpty(){
        return (this.weight === 0);
    }

    getWeight(){
        return this.weight;
    }
}