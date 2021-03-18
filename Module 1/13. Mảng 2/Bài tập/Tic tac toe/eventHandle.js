var cells = document.getElementsByTagName("td");
var x = "<img src='image/x.png'>";
var o = "<img src='image/o.png'>";
var sign = x;
for (var i = 0; i < cells.length; i++) {
  cells[i].onclick = function (e) {
    check(e);
    e.target.onclick = null;
    console.log();
  };
}

function check(e) {
  e.target.innerHTML = sign;
  if (sign == x) sign = o;
  else sign = x;
}
