function tinhCuocPhi() {
    var noiMang = Number(document.getElementById('noiMang7').value);
    var ngoaiMang = Number(document.getElementById('ngoaiMang7').value);
    var cuocNoiMang = 200;
    var cuocNgoaiMang = 500;

    document.getElementById('cuocPhi').innerHTML = noiMang * 60 * cuocNoiMang + ngoaiMang * 60 * cuocNgoaiMang;

}