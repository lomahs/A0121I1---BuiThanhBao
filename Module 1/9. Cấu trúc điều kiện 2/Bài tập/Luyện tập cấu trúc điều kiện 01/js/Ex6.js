function tinhHoaHong() {
  var doanhThu = Number(document.getElementById("amount6").value);
  var phanTramHoaHong;

  if (doanhThu == 0) {
    phanTramHoaHong = 0;
  } else if (doanhThu < 5000000) {
    phanTramHoaHong = 0.05;
  } else if (doanhThu < 10000000) {
    phanTramHoaHong = 0.2;
  } else phanTramHoaHong = 0.4;

  document.getElementById("hoaHong6").innerHTML = doanhThu * phanTramHoaHong;
}
