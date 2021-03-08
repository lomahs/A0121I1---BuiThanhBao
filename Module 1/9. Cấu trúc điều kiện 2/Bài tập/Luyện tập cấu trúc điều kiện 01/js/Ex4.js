function findLargest() {
  var a = Number(document.getElementById("numA4").value);
  var b = Number(document.getElementById("numB4").value);
  var c = Number(document.getElementById("numC4").value);
  var biggest = document.getElementById("result4");

  var max = a;
  if (max < b) max = b;
  if (max < c) max = c;
  biggest.innerHTML = max;
}
