function tinhDienTichHinhChuNhat() {
  var a = Number(document.getElementById("lengthA4").value);
  var b = Number(document.getElementById("lengthB4").value);

  var s = a * b;

  document.getElementById("result4").innerHTML = s;
}
