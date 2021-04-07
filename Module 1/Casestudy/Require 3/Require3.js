class Validation {

    checkEmail(email) {
        //Regex for email
        const EMAIL = /\S+@\S+\.\S+/;
        return EMAIL.test(email);
    }

    checkID(id) {
        //Regex for ID (9 numbers)
        const ID = /(\d){9}/;
        return ID.test(id);
    }

    checkDated(date) {
        //flag check if date is invalid
        let check = true;

        //Regex for date
        const DATE = /^(\d){2}[\/](\d){2}[\/](\d){4}/;
        check = check && DATE.test(date);

        //Get day, month, year
        let days = date.split("/");
        let dd = days[0];
        let mm = days[1];
        let yy = days[2];

        //Check leap year
        let isLeapYear = ((yy % 4 === 0) && (yy % 100 !== 0)) || (yy % 400 === 0);

        //Number of days of each month
        let listDay;
        if (isLeapYear)
            listDay = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        else listDay = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        check = check && (mm >= 1 && mm <= 12);
        check = check && (dd >= 1 && dd <= listDay[mm - 1]);

        return check;
    }

    checkPositiveNumber(number) {
        return number > 0;
    }

    checkStringEmpty(str) {
        return str.length === 0;
    }

    normalizationString(str) {
        //Delete redundant space
        str = str.replaceAll(/\s+/g," ").trim();

        //capitalize first letter
        let words = str.split(/\s/);
        let final = "";
        for (let word of words) {
            word = word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
            final += word + " ";
        }

        return final;
    }
}


let name = document.getElementById("name");
let id = document.getElementById("identifyNum");
let birthday = document.getElementById("birthday");
let email = document.getElementById("email");
let address = document.getElementById("address");
let typeCus = document.getElementById("typeCus");
let discount = document.getElementById("discount");
let quantityIncluded = document.getElementById("quantityIncluded");
let rentDays = document.getElementById("rentDays");
let typeService = document.getElementById("typeService");
let typeRoom = document.getElementById("typeRoom");

let service;
if (typeService.value === 100) service = "Normal";
else if (typeService.value === 300) service = "House";
else service = "Villa";


function checkValidInput() {
    let valid = new Validation();
    let check = true;
    let invalidInput = [];

    if (valid.checkStringEmpty(name.value) === true) {
        check = false;
        invalidInput.push(name);
    }
    if (valid.checkEmail(email.value) === false) {
        check = false;
        invalidInput.push(email);
    }

    if (valid.checkID(id.value) === false) {
        check = false;
        invalidInput.push(id);
    }

    if (valid.checkStringEmpty(address.value) === true) {
        check = false;
        invalidInput.push(address);
    }

    if (valid.checkDated(birthday.value) === false) {
        check = false;
        invalidInput.push(birthday);
    }

    if (valid.checkStringEmpty(discount.value) === true) {
        check = false;
        invalidInput.push(discount);
    }

    if (valid.checkPositiveNumber(rentDays.value) === false) {
        check = false;
        invalidInput.push(rentDays);
    }

    if (valid.checkPositiveNumber(quantityIncluded.value) === false) {
        check = false;
        invalidInput.push(quantityIncluded);
    }

    for (const invalidInputElement of invalidInput) {
        invalidInputElement.style.border = "1px solid red";
    }
    return check;
}

function getInfo() {
    let inputs = document.getElementsByTagName("input");
    for (const input of inputs) {
        input.style.border = "none";
    }

    let valid = new Validation();
    if (checkValidInput()) {
        document.write("Name: " + valid.normalizationString(name.value) + "<br>");
        document.write("ID: " + id.value + "<br>");
        document.write("Birthday: " + birthday.value + "<br>");
        document.write("Email: " + email.value + "<br>");
        document.write("Address: " + valid.normalizationString(address.value) + "<br>");
        document.write("Type Customer: " + typeCus.value + "<br>");
        document.write("Discount: " + discount.value + "<br>");
        document.write("Quantity Included: " + quantityIncluded.value + "<br>");
        document.write("Rent days: " + rentDays.value + "<br>");
        document.write("Type Services: " + service + "<br>");
        document.write("Type Room: " + typeRoom.value + "<br>");

        let totalPay =
            Number(typeService.value) * rentDays.value * (1 - discount.value / 100);
        document.write("Total Pay: " + totalPay + "$<br>");
    } else
        alert("Invalid Information");

}




