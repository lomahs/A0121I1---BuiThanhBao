let a, b, result;

function getData() {
  a = Number(document.getElementById("first").value);
  b = Number(document.getElementById("second").value);
}

function add() {
  getData();
  result = a + b;
  document.getElementById("result").innerHTML = "Result Add: " + result;
}

function sub() {
  getData();
  result = a - b;
  document.getElementById("result").innerHTML = "Result Sub: " + result;
}

function multi() {
  getData();
  result = a * b;
  document.getElementById("result").innerHTML = "Result Multip: " + result;
}

function div() {
  getData();
  result = a / b;
  document.getElementById("result").innerHTML = "Result Div: " + result;
}
