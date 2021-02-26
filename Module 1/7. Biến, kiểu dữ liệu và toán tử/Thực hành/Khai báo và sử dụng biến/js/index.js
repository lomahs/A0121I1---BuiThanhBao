let i = 10;
let f = 20.5;
let b = true;
let s = 'Hà Nội';

function print() {
    document.write('i = ' + i + '<br>');
    document.write('f = ' + f + '<br>');
    document.write('b = ' + b + '<br>');
    document.write('s = ' + s + '<br>');
}

let width = 20;
let height = 10;
let area = width * height;

function getArea() {
    document.write('Area = ' + area + '<br>');
}

function divisible() {
    a = prompt('Enter a: ');
    b = prompt('Enter b: ');
    if (a%b==0) {
        alert('a is divisible by b');
    } else {
        alert('a is not divisible by b');
    }
}
