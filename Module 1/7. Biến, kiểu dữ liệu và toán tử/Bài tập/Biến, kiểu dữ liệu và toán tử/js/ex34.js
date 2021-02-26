
function tinhDienTich() {
    let r = Number(document.getElementById('radius').value);
    var PI = 3.14;
    let s = PI * r * r;
    document.getElementById('dienTich').innerHTML = s;
}

function tinhChuVi() {
    let r = Number(document.getElementById('radius').value);
    var PI = 3.14;
    let c = 2 * PI * r;
    document.getElementById('chuVi').innerHTML = c;
}
