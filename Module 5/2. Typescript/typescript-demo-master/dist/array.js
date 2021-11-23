"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
require("./scss/styles.scss");
var list = [1, 2, 3];
var categories = ['Sport', 'IT', 'Car'];
console.log('list');
list.forEach(function (num) {
    return console.log(num.toFixed(2));
});
console.log('categries');
categories.forEach(function (str) {
    return console.log(str.includes('a'));
});
var listSquare = list.map(function (num) { return num * num; });
console.log(listSquare);
var result = categories.filter(function (str) { return str.length > 2; });
console.log(result);
var x;
x = ["hello", 10];
console.log(x[0].substr(1));
x[3] = "world";
x[5] = 100.25;
console.log(x[5].toString());
//# sourceMappingURL=array.js.map