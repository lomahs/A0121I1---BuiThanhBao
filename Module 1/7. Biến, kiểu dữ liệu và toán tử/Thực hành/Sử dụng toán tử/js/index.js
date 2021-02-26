let inputWidth = prompt("Enter the width");
let inputHeight = prompt("Enter the height");
let area = inputWidth * inputHeight;

document.getElementById('width').innerHTML = 'Width: ' + inputWidth;
document.getElementById('height').innerHTML = 'Height: ' + inputHeight;
document.getElementById('area').innerHTML = 'The area is: ' + area;