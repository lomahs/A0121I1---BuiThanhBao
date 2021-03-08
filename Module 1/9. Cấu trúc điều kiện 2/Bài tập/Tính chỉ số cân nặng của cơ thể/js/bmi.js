function bmi() {
  var height = Number(document.getElementById("height").value);
  var weight = Number(document.getElementById("weight").value);
  var bmi = weight / (height * height);
  if (bmi < 18) document.getElementById("result").innerHTML = "Underweight";
  else if (bmi < 25.0) document.getElementById("result").innerHTML = "Normal";
  else if (bmi < 30.0)
    document.getElementById("result").innerHTML = "Overweight";
  else document.getElementById("result").innerHTML = "Obese";
}
