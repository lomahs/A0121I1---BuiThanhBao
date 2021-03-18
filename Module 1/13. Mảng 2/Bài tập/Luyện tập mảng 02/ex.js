function reverse() {
  var str = prompt("Nhập vào một chuỗi kí tự");
  document.getElementById("arrayElements").innerHTML = str;

  var n = str.length;
  var arr = str.split("");
  for (let i = 0; i < n / 2; i++) {
    let temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
  }

  document.getElementById("result").innerHTML = arr.join("");
}

function countNumAndWord() {
  var str = prompt("Nhập vào một chuỗi kí tự");
  document.getElementById("arrayElements").innerHTML = str;

  var arr = str.split(" ");
  var countNum = 0;
  for (let i = 0; i < str.length; i++) {
    if (str[i] >= "0" && str[i] <= "9") {
      countNum++;
    }
  }

  document.getElementById("result").innerHTML =
    "Có " + arr.length + " từ và " + countNum + " số";
}

function compareString() {
  var str1 = prompt("Nhập vào một chuỗi kí tự");
  var str2 = prompt("Nhập vào một chuỗi kí tự");

  document.getElementById("arrayElements").innerHTML =
    "String 1: " + str1 + "<br> String 2: " + str2;

  var check = false;
  if (str1.localeCompare(str2) == 0) {
    check = true;
  }

  document.getElementById("result").innerHTML = check
    ? "Bằng nhau"
    : "Không bằng nhau";
}
