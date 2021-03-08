function isDivisible() {
  var a = Number(document.getElementById("numA").value);
  var b = Number(document.getElementById("numB").value);

  if (b == 0) {
    document.getElementById("result1").innerHTML = "Invalid input";
  } else if (a % b == 0)
    document.getElementById("result1").innerHTML = a + " chia hết cho " + b;
  else
    document.getElementById("result1").innerHTML =
      a + " không chia hết cho " + b;
}
