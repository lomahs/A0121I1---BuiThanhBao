import {Customer} from './Customer.js';
import {Validation} from './Validation.js';

let name, email, id, birthday, address, typeCustomer, discount, quantityIncluded, typeRoom, rentDays, typeService;
let listCustomers = [];

function showInfo() {

    let nameDiv = createInfo("name", "Name", name);
    let emailDiv = createInfo("email", "Email", email);
    let idDiv = createInfo("id", "Id", id);
    let birthdayDiv = createInfo("birthday", "Birthday", birthday);
    let addressDiv = createInfo("address", "Address", address);
    let typeDiv = createInfo("type", "Type Customer", typeCustomer);
    let discountDiv = createInfo("discount", "Discount", discount);
    let quantityIncludedDiv = createInfo("quantityIncluded", "Quantity", quantityIncluded);
    let typeRoomDiv = createInfo("typeRoom", "Type Room", typeRoom);
    let rentDaysDiv = createInfo("rentDays", "Rent Days", rentDays);
    let typeServiceDiv = createInfo("typeService", "Type Services", typeService);

    document.body.append(nameDiv, emailDiv, idDiv, birthdayDiv,
        addressDiv, typeDiv, discountDiv, quantityIncludedDiv, typeRoomDiv, rentDaysDiv, typeServiceDiv);
}

function createInfo(labelFor, nameLabel, inputValue) {
    let infoLabel = document.createElement("label");
    infoLabel.htmlFor = labelFor;
    infoLabel.innerHTML = nameLabel;

    let infoInput = document.createElement("input");
    infoInput.type = "text";
    infoInput.id = nameLabel;

    let div = document.createElement("div");
    div.appendChild(infoLabel);
    div.appendChild(infoInput);

    if(inputValue !== undefined){
        infoInput.value = inputValue;
        infoInput.disabled = true;

        let editButton = document.createElement("button");
        editButton.type = "button";
        editButton.innerHTML = "Edit";
        editButton.onclick = function () {
            infoInput.disabled = infoInput.disabled !== true;

            if (editButton.innerHTML === "Edit")
                editButton.innerHTML = "OK";
            else editButton.innerHTML = "Edit";
        }

        div.appendChild(editButton);
    }

    return div;
}

function createSelection(idSelect){
    let div = document.createElement("div");
    let select = document.createElement("select");
    select.id = idSelect;

    let option = [];
    for (let i = 1; i < arguments.length; i++){
        option[i] = document.createElement("option");
        option[i].value = arguments[i];
        option[i].text = arguments[i];
        select.appendChild(option[i]);
    }

    div.appendChild(select);

    return div;
}

function createAddCustomerForm(){
    let form = document.createElement("form");

    let nameDiv = createInfo("name", "Name");
    let idDiv = createInfo("id", "Id", id);
    let birthdayDiv = createInfo("birthday", "Birthday");
    let emailDiv = createInfo("email", "Email");
    let addressDiv = createInfo("address", "Address");
    let typeCusDiv = createSelection("typeCus", "Member", "Silver", "Gold", "Platinum", "Diamond");
    let discountDiv = createInfo("discount", "Discount");
    let quantityIncludedDiv = createInfo("quantityIncluded", "Quantity");
    let rentDaysDiv = createInfo("rentDays", "Rent Days");
    let typeServiceDiv = createSelection("typeRoom", "Room","House","Villa");
    let typeRoomDiv = createSelection("typeService", "Normal","Business","Vip");
    let button = document.createElement("button");
    button.setAttribute("type", "button");
    button.innerHTML = "Submit";
    button.setAttribute("onclick","addCustomer()");

    form.append(nameDiv,idDiv, birthdayDiv,emailDiv, addressDiv,typeCusDiv,discountDiv,quantityIncludedDiv,rentDaysDiv, typeServiceDiv, typeRoomDiv,button);

    document.body.appendChild(form);
}

function addCustomer(){

    getInfo();

    let newCus = new Customer(name, email, id, birthday, address, typeCustomer, discount, quantityIncluded, typeRoom, rentDays, typeService);

    listCustomers.push(newCus);
}

function getInfo(){
    name = document.getElementById("name");
    id = document.getElementById("identifyNum");
    birthday = document.getElementById("birthday");
    email = document.getElementById("email");
    address = document.getElementById("address");
    typeCustomer = document.getElementById("typeCus");
    discount = document.getElementById("discount");
    quantityIncluded = document.getElementById("quantityIncluded");
    rentDays = document.getElementById("rentDays");
    typeService = document.getElementById("typeService");
    typeRoom = document.getElementById("typeRoom");
}

function checkValidInput(){

    getInfo();

    let valid = new Validation();
    let check = true;
    let invalidInput = [];

    if (valid.checkStringEmpty(name.value)) {
        check = false;
        invalidInput.push(name);
    }
    if (!valid.checkEmail(email.value)) {
        check = false;
        invalidInput.push(email);
    }

    if (!valid.checkID(id.value)) {
        check = false;
        invalidInput.push(id);
    }

    if (valid.checkStringEmpty(address.value)) {
        check = false;
        invalidInput.push(address);
    }

    if (!valid.checkDated(birthday.value)) {
        check = false;
        invalidInput.push(birthday);
    }

    if (valid.checkStringEmpty(discount.value)) {
        check = false;
        invalidInput.push(discount);
    }

    if (!valid.checkPositiveNumber(rentDays.value)) {
        check = false;
        invalidInput.push(rentDays);
    }

    if (!valid.checkPositiveNumber(quantityIncluded.value)) {
        check = false;
        invalidInput.push(quantityIncluded);
    }

    for (const invalidInputElement of invalidInput) {
        invalidInputElement.style.border = "1px solid red";
    }
    return check;
}

export function main(){
    createAddCustomerForm();

    console.log(listCustomers);
}