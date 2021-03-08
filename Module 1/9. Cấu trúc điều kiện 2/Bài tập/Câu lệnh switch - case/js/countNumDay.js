function numDay() {
  var month = Number(document.getElementById("month").value);

  var days = document.getElementById("result");
  switch (month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
      days.innerHTML = "Tháng " + month + " có 31 ngày";
      break;
    case 2:
      days.innerHTML = "Tháng 2 có 28 hoặc 29 ngày";
      break;
    case 4:
    case 6:
    case 9:
    case 11:
      days.innerHTML = "Tháng " + month + " có 30 ngày";
      break;
    default:
      days.innerHTML = "Nhập lại tháng!";
      break;
  }
}
