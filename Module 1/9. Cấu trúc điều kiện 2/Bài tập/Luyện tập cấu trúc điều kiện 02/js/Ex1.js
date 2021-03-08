function convertCtoF() {
  var c = Number(document.getElementById("doC").value);

  var f = (c * 9) / 5 + 32;

  document.getElementById("result1").innerHTML = f;
}
