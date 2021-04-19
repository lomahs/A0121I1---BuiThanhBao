function mainEx1() {
    let n;
    do {
        n = prompt("Enter the number of element of array (<=50)");
        if (n > 50) alert("Please enter number <= 50!!")
    } while (n > 50);

    let a = [];
    for (let i = 0; i < n; i++) {
        a[i] = prompt("Enter a[" + i + "]");
    }

    let b = [];
    for (let e of a) {
        if (isPrime(e)) b.push(e);
    }

    document.write("Array a: " + a.toString() + "<br>");

    if (b.length === 0) {
        document.write("Not any prime number in array a!");
    } else
        document.write("Prime number in Array a: " + b.toString());
}

function isPrime(a) {
    if (a < 2) return false;

    for (let i = 2; i <= Math.sqrt(a); i++) {
        if (a % i === 0) return false;
    }

    return true;
}