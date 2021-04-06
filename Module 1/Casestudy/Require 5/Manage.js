let arrListCustomers = [];

function displayMainMenu() {
    let menu = "1. Add new customer \n" +
        "2. Display information customer \n" +
        "3. Edit information customer \n" +
        "4. Delete customer \n" +
        "5. Exit \n";

    return prompt(menu + "Your option ") * 1;
}

function addCustomer() {
    let name = prompt("Enter name");
    let id = prompt("Enter id");
    let birthday = prompt("Enter birthday");
    let email = prompt("Enter email");
    let address = prompt("Enter address");
    let typeCus = prompt("Enter type customer");
    let discount = prompt("Enter discount");
    let quantityIncluded = prompt("Enter quantity included");
    let rentDays = prompt("Enter rent days");
    let typeService = prompt("Enter type service");
    let typeRoom = prompt("Enter type room");

    let cusInfo = [];
    cusInfo.push(name);
    cusInfo.push(id);
    cusInfo.push(birthday);
    cusInfo.push(email);
    cusInfo.push(address);
    cusInfo.push(typeCus);
    cusInfo.push(discount);
    cusInfo.push(quantityIncluded);
    cusInfo.push(rentDays);
    cusInfo.push(typeService);
    cusInfo.push(typeRoom);

    arrListCustomers.push(cusInfo);
    alert("Add Successfully");
}

function displayCustomer() {
    if (arrListCustomers.length===0){
        alert("List is empty");
        return;
    }
    let temp = "";
    let i = 1;
    for (const customer of arrListCustomers) {
        temp += i++ + ". " + customer[0] + "\n";
    }
    let choice = prompt(temp + "Choose customer you want to display") * 1;

    alert("Name: " + arrListCustomers[choice - 1][0] + "\n" +
        "ID: " + arrListCustomers[choice - 1][1] + "\n" +
        "Birthday: " + arrListCustomers[choice - 1][2] + "\n" +
        "Email : " + arrListCustomers[choice - 1][3] + "\n" +
        "Address: " + arrListCustomers[choice - 1][4] + "\n" +
        "Type Customer: " + arrListCustomers[choice - 1][5] + "\n" +
        "Discount: " + arrListCustomers[choice - 1][6] + "\n" +
        "Quantity Included: " + arrListCustomers[choice - 1][7] + "\n" +
        "Rent Days: " + arrListCustomers[choice - 1][8] + "\n" +
        "Type Service: " + arrListCustomers[choice - 1][9] + "\n" +
        "Type Room: " + arrListCustomers[choice - 1][10] + "\n"
    )
}

function editInfo() {
    let choiceEdit, choiceCus;
    do {
        let temp = "";
        let i = 1;
        for (const customer of arrListCustomers) {
            temp += i++ + ". " + customer[0] + "\n";
        }
        temp+= "0. Exit \n";
        choiceCus = prompt(temp + "Choose customer you want to edit") * 1;
        if (choiceCus===0)
            break;
        choiceEdit = prompt("1. Name: " + arrListCustomers[choiceCus - 1][0] + "\n" +
            "2. ID: " + arrListCustomers[choiceCus - 1][1] + "\n" +
            "3. Birthday: " + arrListCustomers[choiceCus - 1][2] + "\n" +
            "4. Email : " + arrListCustomers[choiceCus - 1][3] + "\n" +
            "5. Address: " + arrListCustomers[choiceCus - 1][4] + "\n" +
            "6. Type Customer: " + arrListCustomers[choiceCus - 1][5] + "\n" +
            "7. Discount: " + arrListCustomers[choiceCus - 1][6] + "\n" +
            "8. Quantity Included: " + arrListCustomers[choiceCus - 1][7] + "\n" +
            "9. Rent Days: " + arrListCustomers[choiceCus - 1][8] + "\n" +
            "10. Type Service: " + arrListCustomers[choiceCus - 1][9] + "\n" +
            "11. Type Room: " + arrListCustomers[choiceCus - 1][10] + "\n" +
            "12. Exit "
        );


        switch (choiceEdit) {
            case "1":
                arrListCustomers[choiceCus - 1][0] = prompt('Enter name: ');
                break;
            case "2":
                arrListCustomers[choiceCus - 1][1] = prompt('Enter id: ');
                break;
            case "3":
                arrListCustomers[choiceCus - 1][2] = prompt('Enter birthday: ');
                break;
            case "4":
                arrListCustomers[choiceCus - 1][3] = prompt('Enter email: ');
                break;
            case "5":
                arrListCustomers[choiceCus - 1][4] = prompt('Enter address: ');
                break;
            case "6":
                arrListCustomers[choiceCus - 1][5] = prompt('Enter type: ');
                break;
            case "7":
                arrListCustomers[choiceCus - 1][6] = prompt('Enter discount: ');
                break;
            case "8":
                arrListCustomers[choiceCus - 1][7] = prompt('Enter quantityIncluded: ');
                break;
            case "9":
                arrListCustomers[choiceCus - 1][8] = prompt('Enter rent days: ');
                break;
            case "10":
                arrListCustomers[choiceCus - 1][9] = prompt('Enter type Service: ');
                break;
            case "11":
                arrListCustomers[choiceCus - 1][10] = prompt('Enter type room : ');
                break;
            default:
                break;
        }
    }while(choiceEdit !== "12");
}

function deleteCustomer() {
    let temp = "";
    let i = 1;
    for (const customer of arrListCustomers) {
        temp += i++ + ". " + customer[0] + "\n";
    }
    temp+= "0. Exit \n";
    let choiceCus = prompt(temp + "Choose customer you want to delete") * 1;
    if (choiceCus===0)
        return;
    arrListCustomers.splice(choiceCus-1,1);
    alert("Delete Successfully");
}

function main() {
    let choice;
    do {
        choice = displayMainMenu();
        switch (choice) {
            case 1:
                addCustomer();
                break;
            case 2:
                displayCustomer();
                break;
            case 3:
                editInfo();
                break;
            case 4:
                deleteCustomer();
                break;
        }
    } while (choice>=1 && choice <=4);
}





