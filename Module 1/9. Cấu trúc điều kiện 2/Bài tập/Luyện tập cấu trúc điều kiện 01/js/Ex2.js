function checkAgeCondition() {
    var age = Number(document.getElementById('age').value);

    if(age <=0)
        document.getElementById('result2').innerHTML = "Invalid input";
    else if (age < 16)
        document.getElementById('result2').innerHTML = "Chưa đủ tuổi vào lớp 10";
    else
        document.getElementById('result2').innerHTML = "Đủ tuổi vào lớp 10";
}