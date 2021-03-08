function tinhTienDien() {
  var a = Number(document.getElementById("chuDien").value);
  var giaDien;

  if (a < 50) {
    giaDien = 1.678;
  } else if (a < 100) {
    giaDien = 1.734;
  } else if (a < 200) {
    giaDien = 2.014;
  } else if (a < 300) {
    giaDien = 2.536;
  } else if (a < 400) {
    giaDien = 2.834;
  } else giaDien = 2.927;

  document.getElementById("result10").innerHTML = a * giaDien;
}
