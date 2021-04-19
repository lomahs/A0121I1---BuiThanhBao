class SoTietKiem {
    constructor(maSo, loaiTietKiem, hoTen, CMND, ngayMoSo, soTenGui) {
        this.maSo = maSo;
        this.loaiTietKiem = loaiTietKiem;
        this.hoTen = hoTen;
        this.CMND = CMND;
        this.ngayMoSo = ngayMoSo;
        this.soTenGui = soTenGui;
    }

    getMaSo() {
        return this.maSo;
    }

    setMaSo(value) {
        this.maSo = value;
    }

    getLoaiTietKiem() {
        return this.loaiTietKiem;
    }

    setLoaiTietKiem(value) {
        this.loaiTietKiem = value;
    }

    getHoTen() {
        return this.hoTen;
    }

    setHoTen(value) {
        this.hoTen = value;
    }

    getCMND() {
        return this.CMND;
    }

    setCMND(value) {
        this.CMND = value;
    }

    getNgayMoSo() {
        return this.ngayMoSo;
    }

    setNgayMoSo(value) {
        this.ngayMoSo = value;
    }

    getSoTenGui() {
        return this.soTenGui;
    }

    setSoTenGui(value) {
        this.soTenGui = value;
    }

    getSoTienGui() {
        return this.soTienGui;
    }

    setSoTienGui(value) {
        this.soTienGui = value;
    }
}

function mainEx3() {
    let chon;
    do {
        chon = menu();
        switch (chon) {
            case "1":
                themSoTietKiem();
                break;
            case "2":
                xoaSoTietKiem();
                break;
            case "3":
                hienThiDanhSachSo();
                break;
            default:
                return;
        }
    } while (chon >= 1 && chon <= 3);
}

let danhSachSo = [];

// function taoInput(tenInput, tenLabel) {
//     let label = document.createElement("label");
//     label.htmlFor = tenInput;
//     label.innerHTML = tenLabel;
//
//     let input = document.createElement("input");
//     input.type = "text";
//     input.id = tenInput;
//
//     let div = document.createElement("div");
//     div.appendChild(label);
//     div.appendChild(input);
//
//     return div;
// }

function themSoTietKiem() {
    // let maSoDiv = taoInput("maSo"+danhSachSo.length, "Mã sổ");
    // let loaiTietKiemDiv = taoInput("loaiTietKiem"+danhSachSo.length, "Loại tiết kiệm");
    // let hoTenDiv = taoInput("hoTen"+danhSachSo.length, "Họ tên");
    // let CMNDDiv = taoInput("CMND"+danhSachSo.length, "CMND");
    // let ngayMoSoDiv = taoInput("ngayMoSo"+danhSachSo.length, "Ngày mở sổ");
    // let soTienGuiDiv = taoInput("soTienGui"+danhSachSo.length, "Số tiền gửi");
    // let nutOK = document.createElement("button");
    // nutOK.innerHTML = "Thêm";
    // nutOK.onclick = function () {
    //     let maSo = document.getElementById("maSo" + danhSachSo.length).value;
    //     let loaiTietKiem = document.getElementById("loaiTietKiem" + danhSachSo.length).value;
    //     let hoTen = document.getElementById("hoTen" + danhSachSo.length).value;
    //     let CMND = document.getElementById("CMND" + danhSachSo.length).value;
    //     let ngayMoSo = document.getElementById("ngayMoSo" + danhSachSo.length).value;
    //     let soTienGui = document.getElementById("soTienGui" + danhSachSo.length).value;
    //
    //     let soMoi = new SoTietKiem(maSo, loaiTietKiem, hoTen, CMND, ngayMoSo, soTienGui);
    //
    //     danhSachSo.push(soMoi);
    //     alert("Add Successfully");
    //
    // }
    // document.body.append(maSoDi, loaiTietKiemDiv, hoTenDiv, CMNDDiv, ngayMoSoDiv, soTienGuiDiv, nutOK);

    let kiemTra = new Validation();

    let maSo;
    do {
        maSo = prompt("Nhập vào mã sổ");

        if (!kiemTra.kiemTraMaSo(maSo))
            alert("Mã sổ đã tồn tại");

        if (!kiemTra.gioiHanKiTu(1, 5, maSo))
            alert("Mã sổ tối đa 5 kí tự");
    } while (!kiemTra.kiemTraMaSo(maSo) && !kiemTra.gioiHanKiTu(1, 5, maSo));

    let loaiTietKiem;
    do {
        loaiTietKiem = prompt("Nhập vào loại tiết kiệm");

        if (!kiemTra.gioiHanKiTu(1, 10, loaiTietKiem))
            alert("Loại tiết kiệm tối đa 5 kí tự");
    } while (!kiemTra.gioiHanKiTu(1, 10, loaiTietKiem));

    let hoTen;
    do {
        hoTen = prompt("Nhập vào họ tên");

        if (!kiemTra.gioiHanKiTu(1, 30, hoTen))
            alert("Họ tên tối đa 5 kí tự");
    } while (!kiemTra.gioiHanKiTu(1, 30, hoTen));

    let CMND;
    do {
        CMND = prompt("Nhập vào số CMND");

        if (!kiemTra.kiemTraCMND(CMND))
            alert("Chứng minh nhân dân phải đủ 9 số");
    } while (!kiemTra.kiemTraCMND(CMND));

    let ngayMoSo;
    do {
        ngayMoSo = prompt("Nhập vào ngày mở sổ");

        if (!kiemTra.kiemTraNgay(ngayMoSo))
            alert("Ngày nhập vào dưới định dạng dd/mm/yyyy");
    } while (!kiemTra.kiemTraNgay(ngayMoSo));

    let soTienGui;
    do {
        soTienGui = prompt("Nhập vào số tiền gửi");

        if (!kiemTra.kiemTraTienGui(soTienGui)) {
            alert("Số tiền gửi phải lớn hơn 0");
        }
    } while (!kiemTra.kiemTraTienGui(soTienGui));

    let soMoi = new SoTietKiem(maSo, loaiTietKiem, hoTen, CMND, ngayMoSo, soTienGui);
    danhSachSo.push(soMoi);
    alert("Thêm thành công");
}

function xoaSoTietKiem() {
    if (danhSachSo.length === 0) {
        alert("Hiện chưa có sổ nào");
    } else {
        let maSo = prompt("Nhập vào mã sổ cần xóa");

        //Kiểm tra có nhập đúng dạng mã số chưa, nếu chưa thì cho nhập lại
        if (!new Validation().gioiHanKiTu(1, 5, maSo)) {
            alert("Mã số tối đa 5 kí tư");

            xoaSoTietKiem();
        } else if (new Validation().kiemTraMaSo(maSo)) {
            alert("Mã sổ " + maSo + " không tồn tại!");
        } else {
            for (const so of danhSachSo) {
                if (so.getMaSo() === maSo) {
                    if (confirm("Bạn có chắc chắn muốn xóa!")) {
                        danhSachSo.splice(danhSachSo.indexOf(so), 1);

                        alert("Xóa thành công");
                    }
                }
            }
        }
    }
}

function hienThiDanhSachSo() {
    if (danhSachSo.length === 0) {
        alert("Hiện chưa có sổ nào");
    } else {
        let danhSach = "";
        let i = 1;
        for (const so of danhSachSo) {
            danhSach += i++ + ". " + "Mã sổ: " + so.getMaSo() + " - Khách hàng: " + so.getHoTen() + "\n";
        }

        alert(danhSach);
    }
}

function menu() {
    let menu = "1. Thêm sổ tiết kiệm\n" +
        "2. Xóa sổ tiết kiệm\n" +
        "3. Hiển thị danh sách sổ\n" +
        "0. Thoát.\n" +
        "Lựa chọn\n"
    return prompt(menu);
}

//Kiểm tra đầu vào
class Validation {
    kiemTraMaSo(maSo) {
        for (const so of danhSachSo) {
            if (so.getMaSo() === maSo)
                return false;
        }

        //Khong ton tai
        return true;
    }

    gioiHanKiTu(a, b, chuoi) {
        return chuoi.length >= a && chuoi.length <= b;
    }

    kiemTraTienGui(tien) {
        return tien > 0;
    }

    kiemTraCMND(ma) {
        //Regex for ID (9 numbers)
        const CMND = /(\d){9}/;
        return CMND.test(ma);
    }

    kiemTraNgay(ngay) {
        let check = true;

        const DATE = /^(\d){2}[\/](\d){2}[\/](\d){4}/;
        check = check && DATE.test(ngay);

        //Get day, month, year
        let days = ngay.split("/");
        let dd = days[0];
        let mm = days[1];
        let yy = days[2];

        //Check leap year
        let isLeapYear = ((yy % 4 === 0) && (yy % 100 !== 0)) || (yy % 400 === 0);

        //Number of days of each month
        let listDay;
        if (isLeapYear)
            listDay = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        else listDay = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        check = check && (mm >= 1 && mm <= 12);
        check = check && (dd >= 1 && dd <= listDay[mm - 1]);

        return check;
    }
}