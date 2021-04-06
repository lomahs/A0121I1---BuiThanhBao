function showInfo() {

    let nameDiv = createInfo("name", "Name", name);
    let emailDiv = createInfo("email", "Email", email);
    let idDiv = createInfo("id", "Id", id);
    let birthdayDiv = createInfo("birthday", "Birthday", birthday);
    let addressDiv = createInfo("address", "Address", address);
    let typeDiv = createInfo("type", "Type Customer", type);
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

    let div = document.createElement("div");
    div.appendChild(infoLabel);
    div.appendChild(infoInput);
    div.appendChild(editButton);

    return div;
}

function createInput(){
    let input = document.createElement("input");
    input.setAttribute("type", "text");
    input.id = "newCus";
    input.placeholder = "Enter name of new customer";

    document.body.appendChild(input);
}

function addCustomer(){
    createInput();

    let name = document.getElementById("newCus");

}