export class Employee{
    constructor(name, birthday, id, phoneNumber, email,level, position) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.position = position;
    }


    getNameEmployee() {
        return this.name;
    }

    setNameEmployee(value) {
        this.name = value;
    }

    getBirthday() {
        return this.birthday;
    }

    setBirthday(value) {
        this.birthday = value;
    }

    getId() {
        return this.id;
    }

    setId(value) {
        this.id = value;
    }

    getPhoneNumber() {
        return this.phoneNumber;
    }

    setPhoneNumber(value) {
        this.phoneNumber = value;
    }

    getEmail() {
        return this.email;
    }

    setEmail(value) {
        this.email = value;
    }

    getLevel() {
        return this.level;
    }

    setLevel(value) {
        this.level = value;
    }

    getPosition() {
        return this.position;
    }

    setPosition(value) {
        this.position = value;
    }

    setSalary(){
        if (this.position ==="Manager") this.salary = 500;
        else if (this.position ==="Sale") this.salary =300;
        else this.salary = 200;
    }

    getSalary(){
        this.setSalary();
        return this.salary;
    }
}