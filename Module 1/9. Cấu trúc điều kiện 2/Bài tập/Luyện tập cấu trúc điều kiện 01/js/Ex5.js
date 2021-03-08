function grade() {
  var ktra1 = Number(document.getElementById("ktra1").value);
  var ktra2 = Number(document.getElementById("ktra2").value);
  var giuaKi = Number(document.getElementById("giuaki").value);
  var cuoiKi = Number(document.getElementById("cuoiki").value);

  var final = ((ktra1 + ktra2) / 2 + giuaKi * 2 + cuoiKi * 3) / 6;
  document.getElementById("finalResult").innerHTML = final;

  var kqua = "";

  if (final < 4) {
    kqua = "Yếu";
  } else if (final < 6.5) {
    kqua = "Trung bình";
  } else if (final < 8) {
    kqua = "Khá";
  } else {
    kqua = "Giỏi";
  }
  document.getElementById("xepLoai").innerHTML = kqua;
}
