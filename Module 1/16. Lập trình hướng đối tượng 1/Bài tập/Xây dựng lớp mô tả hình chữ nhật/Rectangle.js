class Rectangle {
  constructor(width, height) {
    this.width = width;
    this.height = height;
  }

  setWidth(width) {
    this.width = width;
  }

  setHeight(height) {
    this.height = height;
  }

  getArea() {
    return this.width * this.height;
  }

  getPerimeter() {
    return (this.width + this.height) * 2;
  }

  draw() {
    let ctx = document.getElementById("drawPlace").getContext("2d");
    ctx.fillRect(50, 50, this.width, this.height);
  }
}
