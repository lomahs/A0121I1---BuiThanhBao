export class Customer {
    constructor(name, id, birthday, email, address, typeCustomer, discount, quantityIncluded, typeRoom, rentDays, typeService) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.birthday = birthday;
        this.address = address;
        this.typeCustomer = typeCustomer;
        this.discount = discount;
        this.quantityIncluded = quantityIncluded;
        this.typeRoom = typeRoom;
        this.rentDays = rentDays;
        this.typeService = typeService;
    }

    setName(name) {
        this.name = name;
    }

    getName() {
        return this.name;
    }

    setId(id) {
        this.id = id;
    }

    getId() {
        return this.id;
    }

    setBirthday(birthday) {
        this.birthday = birthday;
    }

    getBirthday() {
        return this.birthday;
    }

    setEmail(email) {
        this.email = email;
    }

    getEmail() {
        return this.email;
    }

    setAddress(address){
        this.address = address;
    }

    getAddress() {
        return this.address;
    }

    setTypeCustomer(typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    getTypeCustomer() {
        return this.typeCustomer;
    }

    setDiscount(discount) {
        this.discount = discount;
    }

    getDiscount() {
        return this.discount;
    }

    setQuantityIncluded(quantityIncluded) {
        this.quantityIncluded = quantityIncluded;
    }

    getQuantityIncluded() {
        return this.quantityIncluded;
    }

    setRentDays(rentDays) {
        this.rentDays = rentDays;
    }

    getRentDays() {
        return this.rentDays;
    }

    setTypeService(typeService) {
        this.typeService = typeService;
    }

    getTypeService() {
        return this.typeService;
    }

    setTypeRoom(typeRoom) {
        this.typeRoom = typeRoom;
    }

    getTypeRoom() {
        return this.typeRoom;
    }

    totalPay() {
        let servicePay;
        if (this.typeService === "Room") servicePay = 100;
        else if (this.typeService === "House") servicePay = 300;
        else servicePay = 500;
        return servicePay * this.rentDays * (1 - this.discount / 100);
    }
}