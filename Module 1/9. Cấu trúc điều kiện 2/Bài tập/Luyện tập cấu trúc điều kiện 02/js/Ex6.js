function giaiPhuongTrinhBacNhat() {
  var a = Number(document.getElementById("lengthA6").value);
  var b = Number(document.getElementById("lengthB6").value);
  var result = document.getElementById("result6");
  if (a == 0) {
    if (b == 0) {
      result.innerHTML = "Vô số nghiệm";
    } else result.innerHTML = "Vô nghiệm";
  } else result.innerHTML = -b / a;
}
