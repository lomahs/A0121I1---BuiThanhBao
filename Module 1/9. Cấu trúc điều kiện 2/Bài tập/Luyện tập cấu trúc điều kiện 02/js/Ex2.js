function convertMtoF() {
  var m = Number(document.getElementById("meter").value);

  var f = m * 3.2808;

  document.getElementById("result2").innerHTML = f;
}
