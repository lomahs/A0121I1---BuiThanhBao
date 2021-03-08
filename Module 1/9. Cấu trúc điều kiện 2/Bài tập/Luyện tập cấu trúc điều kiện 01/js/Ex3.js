function checkNum() {
    var a = Number(document.getElementById('num').value);
    var result = document.getElementById('result3');
    if (a > 0) {
        result.innerHTML = a + " lớn hơn 0";
    } else if(a<0)
        result.innerHTML = a + " nhỏ hơn 0";
    else result.innerHTML = a + " bằng 0";
}