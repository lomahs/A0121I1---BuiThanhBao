function tinhDienTichTamGiac() {
  var a = Number(document.getElementById("lengthA5").value);
  var b = Number(document.getElementById("lengthB5").value);

  var s = (a * b) / 2;

  document.getElementById("result5").innerHTML = s;
}
