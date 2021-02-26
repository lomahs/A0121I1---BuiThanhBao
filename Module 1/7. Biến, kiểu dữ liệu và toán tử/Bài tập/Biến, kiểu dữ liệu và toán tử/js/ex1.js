function tinhDiem() {
    let ly = parseFloat(document.getElementById('diemVatLy').value);
    let hoa = parseFloat(document.getElementById('diemHoaHoc').value);
    let sinh = parseFloat(document.getElementById('diemSinhHoc').value);

    let tong = ly + hoa + sinh;
    let trungBinh = tong/3;
    document.getElementById('tongDiem').innerHTML = tong;
    document.getElementById('diemTrungBinh').innerHTML = trungBinh;
}
