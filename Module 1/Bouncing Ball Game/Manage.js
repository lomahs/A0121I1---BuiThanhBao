var canvas;
var ctx;

var bar = new Bar(100, 500);
var circle = new Circle(400, 30, 10);

//speed ball move
var dx = 1;
var dy = 2;

//speed bar move
var dxBar = 20;

var timer;
var start, end;

function Bar(x, y) {
  this.x = x;
  this.y = y;
}

function Circle(x, y, r) {
  this.x = x;
  this.y = y;
  this.r = r;
}

function drawBall(c) {
  ctx.beginPath();
  ctx.arc(c.x, c.y, c.r, 0, Math.PI * 2, true);
  ctx.fill();
}

function drawBar(b) {
  ctx.beginPath();
  ctx.rect(b.x, b.y, 100, 20);
  ctx.stroke();
  ctx.fillStyle = "red";
  ctx.fill();
}

function doKeyDown(e) {
  if (e.keyCode == 37) {
    if (bar.x - dxBar >= 0) bar.x -= dxBar;
  } else if (e.keyCode == 39) {
    if (bar.x + 100 + dxBar <= canvas.width) bar.x += dxBar;
  }
}

function init() {
  window.addEventListener("keydown", doKeyDown, false);
  canvas = document.getElementById("canvas");
  ctx = canvas.getContext("2d");
  start = new Date().getTime();
  timer = setInterval(draw, 10);
}

function draw() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  ctx.fillStyle = "#FAF7F8";
  ctx.fillRect(0, 0, canvas.width, canvas.height);
  ctx.fillStyle = "#003300";
  drawBall(circle);
  drawBar(bar);
  if (circle.x + dx > canvas.width || circle.x + dx < 0) dx = -dx;
  if (
    (circle.y + dy > bar.y && circle.x > bar.x && circle.x < bar.x + 100) ||
    circle.y + dy < 0
  )
    dy = -dy;
  circle.x += dx;
  circle.y += dy;
  if (circle.y > bar.y) {
    clearTimeout(timer);
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    end = new Date().getTime();
    point = end - start;
    alert("Game Over \nYour point: " + point / 100);
  }
}
