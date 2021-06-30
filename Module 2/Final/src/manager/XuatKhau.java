package manager;

import common.exception.NotFoundProductException;
import common.io.CSVReader;
import common.validate.Checker;
import common.validate.ValidateInput;
import entity.SanPhamNhapKhau;
import entity.SanPhamXuatKhau;

import java.util.ArrayList;

/**
 * Project: Final
 * Package: manager
 * User: lomahs
 * Date time: 28/06/2021 19:12
 * Created with IntelliJ IDEA
 */
public class XuatKhau {
    ValidateInput validate = new ValidateInput();
    Checker checker = new Checker();

    CSVReader reader = new CSVReader();

    private int id = reader.docSPXuatKhau().size();

    public SanPhamXuatKhau taoSPXuatKhau() {
        System.out.println("\n\t--Tao San Pham Xuat Khau");

        System.out.print("Ma san pham: ");
        String ma = validate.inputMaSP();
        while (checker.kiemTraMaTonTai(ma, "xuatkhau")) {
            System.out.println("\tMa da ton tai!");
            System.out.print("Enter again: ");
            ma = validate.inputMaSP();
        }

        System.out.print("Ten san pham: ");
        String ten = validate.inputString();

        System.out.print("Gia ban: ");
        int gia = validate.inputPrice();

        System.out.print("So luong: ");
        int soLuong = validate.inputIntegerInRange(0, 1000);

        System.out.print("Nha san xuat: ");
        String nhaSanXuat = validate.inputString();

        System.out.print("Gia xuat khau: ");
        int giaXuatKhau = validate.inputPrice();

        System.out.print("Quoc Gia Nhap San Pham: ");
        String quocGia = validate.inputString();

        return new SanPhamXuatKhau(++id, ma, ten, gia, soLuong, nhaSanXuat, giaXuatKhau, quocGia);
    }

    public void hienThi() {
        ArrayList<SanPhamXuatKhau> sp = reader.docSPXuatKhau();

        if (sp.isEmpty()) {
            System.out.println("\t\tDanh sach rong");
        } else {

            System.out.printf("\t\t%-3s %-10s %-13s %-10s %-8s %-11s %-12s %-14s\n",
                    "ID",
                    "MaSanPham",
                    "TenSanPham",
                    "GiaBan",
                    "SoLuong",
                    "NhaSanXuat",
                    "GiaXuatKhau",
                    "QuocGiaNhapKhau");
            for (SanPhamXuatKhau sanPhamXuatKhau : sp) {
                sanPhamXuatKhau.showInfo();
            }
        }
    }

    public void timKiem(String loaiTimKiem) throws NotFoundProductException {
        final String ma = "maSanPham";
        final String ten = "tenSanPham";


        ArrayList<SanPhamXuatKhau> sp = reader.docSPXuatKhau();
        if (loaiTimKiem.equals(ma)) {
            System.out.print("\t\tNhap ma san pham: ");
            String maSP = validate.inputMaSP();

            for (SanPhamXuatKhau sanPhamXuatKhau : sp) {
                if (sanPhamXuatKhau.getMaSanPham().equals(maSP)) {
                    System.out.print("\tSan pham: ");
                    sanPhamXuatKhau.showInfo();
                } else {
                    throw new NotFoundProductException("San pham khong ton tai");
                }
            }
        }
        if (loaiTimKiem.equals(ten)) {
            System.out.print("\t\tNhap ten san pham: ");
            String tenSP = validate.inputString();

            for (SanPhamXuatKhau sanPhamXuatKhau : sp) {
                if (sanPhamXuatKhau.getTen().equals(tenSP)) {
                    System.out.print("\tSan pham: ");
                    sanPhamXuatKhau.showInfo();
                } else {
                    throw new NotFoundProductException("San pham khong ton tai");
                }
            }
        }
    }

}
