//Generating array
var arr;

function randomElement() {
  return Math.floor(Math.random() * 100);
}

function generatingArray() {
  var n = prompt("Nhập vào số lượng phần tử của mảng") * 1;
  arr = new Array();
  for (let i = 0; i < n; i++) {
    arr.push(randomElement());
  }
}

function displayArray() {
  document.getElementById("arrayElements").innerHTML = arr.join(", ");
}
