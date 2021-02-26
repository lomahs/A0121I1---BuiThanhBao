function doiCSangF() {
    let c = Number(document.getElementById('celsius').value);
    let f = 9*c/5+32;
    document.getElementById('fahrenheit').innerHTML = f;
}