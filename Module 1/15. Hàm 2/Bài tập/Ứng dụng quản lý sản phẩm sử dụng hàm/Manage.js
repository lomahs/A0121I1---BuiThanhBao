const products = [];
let length = 0;
const display = document.getElementById("display_product");

function addProduct() {
  let product = document.getElementById("newProduct").value;

  if (product !== "") {
    products.push(product);
    length++;
    displayProduct();
    document.getElementById("newProduct").value = "";
  }
}

function removeProduct(id) {
  console.log(id);
  id.parentNode.removeChild(id);
  length--;
}

function editName(id) {
  id.innerText = prompt("Enter new name");
}

function displayProduct() {
  let newProduct = products[length - 1];

  let newPro = display.insertRow();
  let name = newPro.insertCell();
  let editButton = newPro.insertCell();
  let deleteButton = newPro.insertCell();
  document.getElementById("numProduct").innerText = length + " products";

  newPro.id = "product" + length;

  name.id = "namePro" + length;
  name.innerHTML = newProduct;
  editButton.innerHTML =
    '<button onclick="editName(' + name.id + ');">Edit</button>';

  deleteButton.innerHTML =
    '<button onclick="removeProduct(' + newPro.id + ');">Delete</button>';
}
