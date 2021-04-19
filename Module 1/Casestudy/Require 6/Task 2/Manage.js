import {Employee} from "./Employee.js";


let listEmployees = [];

function addNewEmployee() {
    let name = prompt("Enter name of employee");
    let birthday = prompt("Enter birthday");
    let id = prompt("Enter id");
    let phoneNumber = prompt("Enter phone number");
    let email = prompt("Enter email");
    let levelChoice = prompt("Choose level\n" +
        "1. Trung cấp\n" +
        "2. Cao đẳng\n" +
        "3. Đại học\n" +
        "4. Sau đại học");
    let level;
    if (levelChoice === "1") level = "Trung cấp";
    else if (levelChoice === "2") level = "Cao đẳng";
    else if (levelChoice === "3") level = "Đại học";
    else level = "Sau đại học";
    let positionChoice = prompt("Choose position\n" +
        "1. Lễ tân\n" +
        "2. Phục vụ\n" +
        "3. Chuyên viên\n" +
        "4. Giám sát\n" +
        "5. Quản lý\n" +
        "6. Giám đốc");
    let position;
    if (positionChoice === "1") position = "Marketing";
    else if (positionChoice === "2") position = "Sale";
    else if (positionChoice === "3") position = "Manager";
    let newEmployee = new Employee(name, birthday, id, phoneNumber, email, level, position);

    listEmployees.push(newEmployee);
    alert("Add Successfully");
}

function displayInformation() {
    if (listEmployees.length === 0) {
        alert("List is empty");
    } else {
        let temp = "";
        for (let i = 0; i < listEmployees.length; i++)
            temp += (i + 1) + ". " + listEmployees[i].getNameEmployee() + "\n";

        temp += "0. Exit \n";
        let choice = prompt(temp + "Choose employee to display");

        if (choice !== "0") {
            alert("Name: " + listEmployees[choice - 1].getNameEmployee() + "\n" +
                "Birthday: " + listEmployees[choice - 1].getBirthday() + "\n" +
                "ID: " + listEmployees[choice - 1].getId() + "\n" +
                "Phone Number: " + listEmployees[choice - 1].getPhoneNumber() + "\n" +
                "Email: " + listEmployees[choice - 1].getEmail() + "\n" +
                "Level: " + listEmployees[choice - 1].getLevel() + "\n" +
                "Position: " + listEmployees[choice - 1].getPosition()
            )

            displayInformation()
        }
    }
}

function displaySalary() {
    if (listEmployees.length === 0) {
        alert("List is empty");
    } else {
        let temp = "";
        for (let i = 0; i < listEmployees.length; i++)
            temp += (i + 1) + ". " + listEmployees[i].getNameEmployee() + ": " + listEmployees[i].getSalary() + "\n";

        alert(temp);
    }
}

function menu() {
    let menu = "MANAGE EMPLOYEE\n" +
        "1. Add new employee\n" +
        "2. Display information of employee\n" +
        "3. Salary of employees\n" +
        "0. Exit\n"
    return prompt(menu + "Enter your option ");
}

export function main() {
    let choice;
    do {
        choice = menu();
        switch (choice) {
            case "1":
                addNewEmployee();
                break;
            case "2":
                displayInformation();
                break;
            case "3":
                displaySalary();
                break;
            default:
                alert("Goodbye!")
                break;
        }
    } while (choice >= 1 && choice <= 3)
}



