var x = 0;
var array = Array();

function add_element_to_array() {
  array[x++] = Number(document.getElementById("txtValue").value);
  alert("Element: " + array[x - 1] + " Added at index " + x);
  document.getElementById("txtValue").value = "";
}

function display_array() {
  var e = "<hr>";
  for (let i = 0; i < array.length; i++) {
    e += "Element " + i + " = " + array[i] + "<br/>";
  }
  document.getElementById("result").innerHTML = e;
}
