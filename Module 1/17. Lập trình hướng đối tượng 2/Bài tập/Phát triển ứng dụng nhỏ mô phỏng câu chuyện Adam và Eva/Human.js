export class Human {
    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }

    isMale() {
        return this.gender;
    }

    setGender(gender) {
        this.gender = gender;
    }

    checkApple(Apple) {
        return Apple.isEmpty();
    }

    eat(Apple) {
        console.log(this.name + " is eating");
        Apple.decrease();
        this.weight++;
    }

    say(String) {
        console.log(String);
    }

    getName() {
        return this.name;
    }

    setName(String) {
        this.name = String;
    }

    getWeight() {
        return this.weight;
    }

    setWeight(int) {
        this.weight = int;
    }


}