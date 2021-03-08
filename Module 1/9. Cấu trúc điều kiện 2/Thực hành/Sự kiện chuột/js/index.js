window.onload = init();

function init() {
  let imgObj = document.getElementById("myImage");
  imgObj.style.position = "relative";
  imgObj.style.left = "0px";
}

function moveRight() {
  imgObj.style.left = parseInt(imgObj.style.left) + 30 + "px";
}
