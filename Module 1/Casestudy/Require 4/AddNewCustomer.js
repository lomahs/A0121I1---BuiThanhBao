const arrNameCustomers = [];

function addCustomer() {
    let numCus = prompt("Enter the number of customers you want to add")*1;

    for (let i = 0; i < numCus; i++) {
        arrNameCustomers.push(prompt("Enter name of new customer"));
    }

    displayCustomer();
}

function displayCustomer(){
    sortListCustomers();
    let display = document.getElementById("displayCustomer");
    display.innerHTML = "<h3> List Customer</h3>";
    for (let i = 0; i <arrNameCustomers.length; i++){
        display.innerHTML += (i+1) +". " + arrNameCustomers[i] + "<br>";
    }
}

function delCustomer(){
    let cus = prompt("Enter name of customer to delete");

    if (arrNameCustomers.includes(cus)){
        arrNameCustomers.splice(arrNameCustomers.indexOf(cus),1);
    }else
        alert("Can't find " + cus + " in list");

    displayCustomer();
}

function sortListCustomers(){
    for (let i = 0; i < arrNameCustomers.length-1; i++)
        for (let j = i; j <arrNameCustomers.length; j++)
            if (arrNameCustomers[j]<arrNameCustomers[i]){
                let temp = arrNameCustomers[j];
                arrNameCustomers[j] = arrNameCustomers[i];
                arrNameCustomers[i] = temp;
            }
}