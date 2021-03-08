window.onload = docReady();
function moveUp() {
  var nobita = document.getElementById("myImage");
  nobita.style.top = parseInt(nobita.style.top) - 5 + "px";
}

function moveDown() {
  var nobita = document.getElementById("myImage");
  nobita.style.top = parseInt(nobita.style.top) + 5 + "px";
}

function moveRight() {
  var nobita = document.getElementById("myImage");
  nobita.style.left = parseInt(nobita.style.left) + 5 + "px";
}

function moveLeft() {
  var nobita = document.getElementById("myImage");
  nobita.style.left = parseInt(nobita.style.left) - 5 + "px";
}

function docReady() {
  window.addEventListener("keydown", moveSelection);
}

function moveSelection(evt) {
  switch (evt.keyCode) {
    case 37:
      moveLeft();
      break;
    case 39:
      moveRight();
      break;
    case 38:
      moveUp();
      break;
    case 40:
      moveDown();
      break;
  }
}
