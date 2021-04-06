let name = "Bùi Thanh Bảo";
let email = "thanhBao@gmail.com";
let id = "012345678";
let birthday = "01/01/1999";
let address = "Quảng Nam";
let type = "Member";
let discount = 20;
let quantityIncluded = 2;
let typeRoom = "Vip";
let rentDays = "4";
let typeService = "Villa";


function showInfo() {
    let cusInfo = "1. Name: " + name + "<br>" +
        "2. Email: " + email + "<br>" +
        "3. ID: " + id + "<br>" +
        "4. Birthday: " + birthday + "<br>" +
        "5. Address: " + address + "<br>" +
        "6. Type: " + type + "<br>" +
        "7. Discount: " + discount + "<br>" +
        "8. Quantity Included: " + quantityIncluded + "<br>" +
        "9. Type Room: " + typeRoom + "<br>" +
        "10.Rent Days: " + rentDays + "<br>" +
        "11.Type Service: " + typeService + "<br>";

    document.write(cusInfo);
}

function editInfo() {
    showInfo();

    let choice = document.createElement("input");
    choice.setAttribute("type", "text");
    choice.placeholder = "Enter number";

    document.body.appendChild(choice);

    let confirmButton = document.createElement("button");
    confirmButton.setAttribute("type", "button");
    confirmButton.onclick = function () {
        switch (choice.value) {
            case "1":
                name = prompt('Enter name: ');
                break;
            case "2":
                email = prompt('Enter email: ');
                break;
            case "3":
                id = prompt('Enter id: ');
                break;
            case "4":
                birthday = prompt('Enter birthday: ');
                break;
            case "5":
                address = prompt('Enter address: ');
                break;
            case "6":
                type = prompt('Enter type: ');
                break;
            case "7":
                discount = prompt('Enter discount: ');
                break;
            case "8":
                quantityIncluded = prompt('Enter quantityIncluded: ');
                break;
            case "9":
                typeRoom = prompt('Enter type room : ');
                break;
            case "10":
                rentDays = prompt('Enter rent days: ');
                break;
            case "11":
                typeService = prompt('Enter type Service: ');
                break;
            default:
                break;
        }

        document.body.innerHTML = "";
        editInfo();
    };
    confirmButton.innerHTML = "Edit";
    document.body.appendChild(confirmButton);
}

function totalPay() {
    let serviceMoney = 0;

    if (typeService === "Villa")
        serviceMoney = 500;
    else if (typeService === "Hourse")
        serviceMoney = 300;
    else if (typeService === "Room")
        serviceMoney = 100;

    let totalDiscount=0;
    switch (address) {
        case "Quảng Nam":
            totalDiscount += 5;
            break;
        case "Đà Nẵng":
            totalDiscount += 20;
            break;
        case "Huế":
            totalDiscount += 10;
            break;
        default:
            break;
    }

    if (rentDays >= 2 && rentDays <= 4)
        totalDiscount += 10;
    else if (rentDays >= 5 && rentDays <= 7)
        totalDiscount += 20;
    else if (rentDays > 7)
        totalDiscount += 30;

    switch (type) {
        case "Diamond":
            totalDiscount += 15;
            break;
        case "Platium":
            totalDiscount += 10;
            break;
        case "Gold":
            totalDiscount += 5;
            break;
        case "Silver":
            totalDiscount += 2;
            break;
        default:
            break;
    }

    return serviceMoney * rentDays - totalDiscount;
}


function showTotalPayment() {
    document.write("Total amount you need to pay: "+ totalPay()+"$");
}
