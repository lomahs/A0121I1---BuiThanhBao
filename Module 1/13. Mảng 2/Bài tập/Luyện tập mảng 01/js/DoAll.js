//Viết chương trình khởi tạo mảng số nguyên gồm 10 phần tử. Chương trình thực hiện tính và hiển thị xem có bao nhiêu số nguyên lớn hơn hoặc bằng 10.

function countNegativeAndBiggerThanN() {
  var n = prompt("Nhập 1 số nguyên") * 1;
  var count = 0;
  var negative = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] >= n) {
      count++;
    }
    if (arr[i] < 0) {
      negative++;
    }
  }
  document.getElementById("result").innerHTML =
    "Có " + negative + " số âm <br>" + "Có " + count + " số lớn hơn bằng " + n;
}

function biggestAndAverage() {
  var sum = 0;
  var max = arr[0];

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
    sum += arr[i];
  }

  document.getElementById("result").innerHTML =
    "Số lớn nhất: " + max + "<br>" + "Trung bình cộng: " + sum / arr.length;
}

function sorting() {
  for (let i = 0; i < arr.length - 1; i++)
    for (let j = i + 1; j < arr.length; j++) {  
      if (arr[i] > arr[j]) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

  document.getElementById("result").innerHTML = arr.join(",");
}
