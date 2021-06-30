package manager;

import common.exception.NotFoundProductException;
import common.io.CSVReader;
import common.validate.Checker;
import common.validate.ValidateInput;
import entity.SanPhamNhapKhau;

import java.util.ArrayList;

/**
 * Project: Final
 * Package: manager
 * User: lomahs
 * Date time: 28/06/2021 19:02
 * Created with IntelliJ IDEA
 */
public class NhapKhau {
    ValidateInput validate = new ValidateInput();
    Checker checker = new Checker();

    CSVReader reader = new CSVReader();
    private int id = reader.docSPNhapKhau().size();

    public SanPhamNhapKhau taoSPNhapKhau(){
        System.out.println("\n\t--Tao San Pham Nhap Khau");

        System.out.print("Ma san pham: ");
        String ma = validate.inputMaSP();
        while (checker.kiemTraMaTonTai(ma,"nhapkhau")){
            System.out.println("\tMa da ton tai!");
            System.out.print("Enter again: ");
            ma = validate.inputMaSP();
        }

        System.out.print("Ten san pham: ");
        String ten = validate.inputString();

        System.out.print("Gia ban: ");
        int gia = validate.inputPrice();

        System.out.print("So luong: ");
        int soLuong = validate.inputIntegerInRange(0,1000);

        System.out.print("Nha san xuat: ");
        String nhaSanXuat = validate.inputString();

        System.out.print("Gia nhap khau: ");
        int giaNhapKhau = validate.inputPrice();

        System.out.print("Tinh thanh nhap: ");
        String tinhThanh = validate.inputString();

        System.out.print("Thue Nhap Khau: ");
        int thue = validate.inputPrice();

        return new SanPhamNhapKhau(++id,ma,ten,gia,soLuong,nhaSanXuat,giaNhapKhau,tinhThanh,thue);
    }

    public void hienThi(){
        ArrayList<SanPhamNhapKhau> sp = reader.docSPNhapKhau();

        if (sp.isEmpty()){
            System.out.println("\t\tDanh sach rong");
        }else {

            System.out.printf("\t\t%-3s %-10s %-13s %-10s %-8s %-11s %-12s %-14s %-13s\n",
                    "ID",
                    "MaSanPham",
                    "TenSanPham",
                    "GiaBan",
                    "SoLuong",
                    "NhaSanXuat",
                    "GiaNhapKhau",
                    "TinhThanhNhap",
                    "ThueNhapKhau");
            for (SanPhamNhapKhau sanPhamNhapKhau : sp) {
                sanPhamNhapKhau.showInfo();
            }
        }
    }

    public void timKiem(String loaiTimKiem) throws NotFoundProductException {
        final String ma = "maSanPham";
        final String ten = "tenSanPham";


        ArrayList<SanPhamNhapKhau> sp = reader.docSPNhapKhau();
        if (loaiTimKiem.equals(ma)){
            System.out.print("\t\tNhap ma san pham: ");
            String maSP = validate.inputMaSP();

            for (SanPhamNhapKhau sanPhamNhapKhau : sp) {
                if (sanPhamNhapKhau.getMaSanPham().equals(maSP)){
                    System.out.print("\tSan pham: ");
                    sanPhamNhapKhau.showInfo();
                }
            }
        }if (loaiTimKiem.equals(ten)){
            System.out.print("\t\tNhap ten san pham: ");
            String tenSP = validate.inputString();

            for (SanPhamNhapKhau sanPhamNhapKhau : sp) {
                if (sanPhamNhapKhau.getTen().equals(tenSP)){
                    System.out.print("\tSan pham: ");
                    sanPhamNhapKhau.showInfo();
                }
            }
        }
    }
}
