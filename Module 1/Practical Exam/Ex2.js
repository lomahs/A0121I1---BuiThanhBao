class PhanSo {
    constructor(tuSo, mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }


    getTuSo() {
        return this.tuSo;
    }

    setTuSo(value) {
        this.tuSo = value;
    }

    getMauSo() {
        return this.mauSo;
    }

    setMauSo(value) {
        this.mauSo = value;
    }
}

function mainEx2() {

    //Nhập phân số a
    let aTuSo;
    do{
        aTuSo = prompt("Nhập vào tử số của a");
    }while(aTuSo === "");

    let aMauSo;
    do {
        aMauSo = prompt("Nhập vào mẫu số của a");

        if (Number(aMauSo) === 0)
            alert("Mẫu số phải khác 0");
    } while (Number(aMauSo) === 0 || aMauSo === "");

    let a = new PhanSo(aTuSo, aMauSo);

    //Nhập phân số b
    let bTuSo
    do{
        bTuSo = prompt("Nhập vào tử số của b");
    }while(bTuSo === "");
    let bMauSo;
    do {
        bMauSo = prompt("Nhập vào mẫu số của b");

        if (Number(bMauSo) === 0)
            alert("Mẫu số phải khác 0");
    } while (Number(bMauSo) === 0|| bMauSo === "");

    let b = new PhanSo(bTuSo, bMauSo);

    document.write("Phân số a: " + aTuSo + "/" + aMauSo + "<br>");
    document.write("Phân số b: " + bTuSo + "/" + bMauSo + "<br>");

    if (kiemTraBangNhau(a, b))
        document.write("Phân số " + aTuSo + "/" + aMauSo + " bằng phân số " + bTuSo + "/" + bMauSo + " !");
    else document.write("Phân số " + aTuSo + "/" + aMauSo + " không bằng phân số " + bTuSo + "/" + bMauSo + "!");
}

function kiemTraBangNhau(a, b) {
    return a.getMauSo() * b.getTuSo() === a.getTuSo() * b.getMauSo();
}