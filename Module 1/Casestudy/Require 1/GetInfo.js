function getInfo() {
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
  let totalPay =
    Number(typeService.value) * rentDays.value * (1 - discount.value / 100);
  let service;


  if (typeService.value === 100) service = "Normal";
  else if (typeService.value === 300) service = "House";
  else service = "Villa";

  document.write("Name: " + name.value + "<br>");
  document.write("ID: " + id.value + "<br>");
  document.write("Birthday: " + birthday.value + "<br>");
  document.write("Email: " + email.value + "<br>");
  document.write("Address: " + address.value + "<br>");
  document.write("Type Customer: " + typeCus.value + "<br>");
  document.write("Discount: " + discount.value + "<br>");
  document.write("Quantity Included: " + quantityIncluded.value + "<br>");
  document.write("Rent days: " + rentDays.value + "<br>");
  document.write("Type Services: " + service + "<br>");
  document.write("Type Room: " + typeRoom.value + "<br>");
  document.write("Total Pay: " + totalPay + "$<br>");
}
