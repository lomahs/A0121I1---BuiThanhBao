import {Customer} from '../Entity/Customer.js';
import {Validation} from './Validation.js';

let name, email, id, birthday, address, typeCustomer, discount, quantityIncluded, typeRoom, rentDays, typeService;
let listCustomers = [];

function menu(){
    let addButton = document.createElement("button");
    addButton.innerHTML = "Add New Customer";
    addButton.onclick = () => {
        document.body.innerHTML = "";
        addCustomer();
    }

    let editButton = document.createElement("button");
    editButton.innerHTML = "Edit Customer";
    editButton.onclick = () => {
        document.body.innerHTML= "";
        manageCustomers();
    }

    let exitButton = document.createElement("button");
    exitButton.innerHTML = "Exit";
    exitButton.onclick = function(){
        document.write("Thanks for using");
    };

    document.body.innerHTML = "";
    document.body.append(addButton, editButton, exitButton);
}

export function main(){
    menu();
}

function editInfo(customer) {

    let nameDiv = createInfo("name", "Name", "display", customer.getName());
    let emailDiv = createInfo("email", "Email", "display", customer.getEmail());
    let idDiv = createInfo("id", "Id", "display", customer.getId());
    let birthdayDiv = createInfo("birthday", "Birthday", "display", customer.getBirthday());
    let addressDiv = createInfo("address", "Address", "display", customer.getAddress());
    let typeCusDiv = createSelection("typeCustomer", "Member", "Silver", "Gold", "Platinum", "Diamond");
    let discountDiv = createInfo("discount", "Discount", "display", customer.getDiscount());
    let quantityIncludedDiv = createInfo("quantityIncluded", "Quantity", "display", customer.getQuantityIncluded());
    let rentDaysDiv = createInfo("rentDays", "Rent Days", "display", customer.getRentDays());
    let typeServiceDiv = createSelection("typeService", "Room","House","Villa");
    let typeRoomDiv = createSelection("typeRoom", "Normal","Business","Vip");

    let button = document.createElement("button");
    button.innerHTML = "Ok";
    button.onclick = () => {
        getInfo();
        customer.setName(name.value);
        customer.setEmail(email.value);
        customer.setId(id.value);
        customer.setBirthday(birthday.value);
        customer.setAddress(address.value);
        customer.setTypeCustomer(typeCustomer.value);
        customer.setDiscount(discount.value);
        customer.setQuantityIncluded(quantityIncluded.value);
        customer.setRentDays(rentDays.value);
        customer.setTypeService(typeService.value);
        customer.setTypeRoom(typeRoom.value);
        manageCustomers();
    }

    document.body.append(nameDiv, idDiv, birthdayDiv, emailDiv,
        addressDiv, typeCusDiv, discountDiv, quantityIncludedDiv, rentDaysDiv, typeServiceDiv, typeRoomDiv,button);
}

function createInfo(labelFor, nameLabel, className, inputValue) {
    let infoLabel = document.createElement("label");
    infoLabel.htmlFor = labelFor;
    infoLabel.innerHTML = nameLabel;
    infoLabel.className = className;

    let infoInput = document.createElement("input");
    infoInput.type = "text";
    infoInput.id = labelFor;
    infoInput.className = className;

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

function addCustomer(){
    let form = document.createElement("form");

    let nameDiv = createInfo("name", "Name", "form_addCustomer");
    let idDiv = createInfo("id", "Id", "form_addCustomer");
    let birthdayDiv = createInfo("birthday", "Birthday", "form_addCustomer");
    let emailDiv = createInfo("email", "Email", "form_addCustomer");
    let addressDiv = createInfo("address", "Address", "form_addCustomer");
    let typeCusDiv = createSelection("typeCustomer", "Member", "Silver", "Gold", "Platinum", "Diamond");
    let discountDiv = createInfo("discount", "Discount", "form_addCustomer");
    let quantityIncludedDiv = createInfo("quantityIncluded", "Quantity", "form_addCustomer");
    let rentDaysDiv = createInfo("rentDays", "Rent Days", "form_addCustomer");
    let typeServiceDiv = createSelection("typeService", "Room","House","Villa");
    let typeRoomDiv = createSelection("typeRoom", "Normal","Business","Vip");
    let button = document.createElement("button");
    button.setAttribute("type", "button");
    button.innerHTML = "Submit";
    button.id = "submitForm"
    button.onclick = function () {
        getInfo();
        if(checkValidInput()) {
            let newCus = new Customer(name.value, id.value, birthday.value, email.value
                , address.value, typeCustomer.value, discount.value, quantityIncluded.value, typeRoom.value, rentDays.value, typeService.value);

            listCustomers.push(newCus);
            menu();
        }else alert("Invalid Information");
    }

    form.append(nameDiv,idDiv, birthdayDiv,emailDiv, addressDiv,typeCusDiv,discountDiv,quantityIncludedDiv,rentDaysDiv, typeServiceDiv, typeRoomDiv,button);

    document.body.appendChild(form);
}

function getInfo(){
    name = document.getElementById("name");
    id = document.getElementById("id");
    birthday = document.getElementById("birthday");
    email = document.getElementById("email");
    address = document.getElementById("address");
    typeCustomer = document.getElementById("typeCustomer");
    discount = document.getElementById("discount");
    quantityIncluded = document.getElementById("quantityIncluded");
    rentDays = document.getElementById("rentDays");
    typeService = document.getElementById("typeService");
    typeRoom = document.getElementById("typeRoom");
}

function checkValidInput(){

    getInfo();
    let inputs = document.getElementsByTagName("input");
    for (const input of inputs) {
        input.style.border = "none";
    }

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

function manageCustomers(){
    let list = document.createElement("table");
    for (let i = 0; i <listCustomers.length; i++) {
        let row = list.insertRow(i);

        let tdName = row.insertCell(0);
        tdName.innerHTML = listCustomers[i].getName();

        let editButton = document.createElement("button");
        editButton.innerHTML = "Edit";
        editButton.onclick = () => {
            document.body.innerHTML = "";
            editInfo(listCustomers[i])
        };


        let delButton = document.createElement("button");
        delButton.innerHTML = "Delete";
        delButton.onclick = () => {
            deleteCustomer(listCustomers[i].getId());
            manageCustomers();
            alert("Delete Successfully");
        };


        let showTotalButton = document.createElement("button");
        showTotalButton.innerHTML = "Show Total Payment";
        showTotalButton.onclick = () => {
            let total = row.insertCell(1);
            total.innerHTML = "<span id=\"showTotalPayment\">Total Payment: "+listCustomers[i].totalPay()+"</span>";
        };
        row.appendChild(showTotalButton);
        row.appendChild(delButton);
        row.appendChild(editButton);
    }

    let exitButton = document.createElement("button");
    exitButton.innerHTML = "Back";
    exitButton.onclick = ()=>menu();

    document.body.innerHTML = "";
    document.body.append(list, exitButton);
}

function deleteCustomer(id){
    for(let i = 0; i <listCustomers.length; i++){
        if (listCustomers[i].getId() === id)
            listCustomers.splice(i,1);
    }
}

