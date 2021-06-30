package manager;

import common.exception.NotFoundProductException;
import common.io.CSVWrite;
import common.validate.Checker;
import common.validate.ValidateInput;
import entity.SanPhamNhapKhau;
import entity.SanPhamXuatKhau;

/**
 * Project: Final
 * Package: manager
 * User: lomahs
 * Date time: 28/06/2021 18:51
 * Created with IntelliJ IDEA
 */
public class MainController {
    ValidateInput validate = new ValidateInput();
    Checker checker = new Checker();

    CSVWrite write = new CSVWrite();

    NhapKhau nhapKhau = new NhapKhau();
    XuatKhau xuatKhau = new XuatKhau();

    public void menu() {
        while (true) {
        System.out.println("""
                                
                \t\t---CHUONG TRINH QUAN LY SAN PHAM---
                \t1. Them moi
                \t2. Xoa
                \t3. Xem danh sach cac san pham
                \t4. Tim kiem
                \t5. Thoat""");
        System.out.print("\tChon chuc nang: ");
        int choice = validate.inputIntegerInRange(1, 5);


            switch (choice) {
                case 1 -> themSanPham();
                case 2 -> {
                    try {
                        xoaSanPham();
                    } catch (NotFoundProductException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> xemSanPham();
                case 4 -> timKiemSanPham();
                default -> {
                    return;
                }
            }
        }
    }

    public void themSanPham() {
        System.out.println("""
                                
                \t--Them moi san pham--
                \t1. Them San pham Nhap Khau
                \t2. Them San pham Xuat Khau
                \t3. Tro ve trang chu""");
        System.out.print("\tChon chuc nang: ");
        int choice = validate.inputIntegerInRange(1, 3);

        switch (choice) {
            case 1 -> {
                SanPhamNhapKhau sp = nhapKhau.taoSPNhapKhau();
                write.luuSPNhapKhau(sp, true);
            }
            case 2 -> {
                SanPhamXuatKhau sp = xuatKhau.taoSPXuatKhau();
                write.luuSPXuatKhau(sp, true);
            }
            default -> {
            }
        }
    }

    public void xoaSanPham() throws NotFoundProductException {
        System.out.println("""
                                
                \t--Xoa san pham--
                \t1. Xoa San pham Nhap Khau
                \t2. Xoa San pham Xuat Khau
                \t3. Tro ve trang chu""");
        System.out.print("\tChon chuc nang: ");
        int choice = validate.inputIntegerInRange(1, 3);

        System.out.print("\tNhap ma san pham: ");
        String ma = validate.inputMaSP();

        switch (choice) {
            case 1 -> {
                if (!checker.kiemTraMaTonTai(ma, "nhapkhau")){
                     throw new NotFoundProductException("San pham khong ton tai!");
                }else {
                    System.out.println("\tBan co chac chan muon xoa!");
                    System.out.print("\tYes or No: ");
                    String input = validate.inputYesNo();

                    if (input.equalsIgnoreCase("yes")) {
                        write.xoaSanPham("nhapkhau", ma);
                    }
                }

            }
            case 2 -> {
                if (!checker.kiemTraMaTonTai(ma, "xuatkhau")){
                    throw new NotFoundProductException("San pham khong ton tai!");
                }else {
                    System.out.println("\tBan co chac chan muon xoa!");
                    System.out.print("\tYes or No: ");
                    String input = validate.inputYesNo();

                    if (input.equalsIgnoreCase("yes")) {
                        write.xoaSanPham("xuatkhau", ma);

                    }
                }
            }
            default -> {
            }
        }
    }

    public void xemSanPham(){
        System.out.println("""
                                
                \t--Hien thi san pham--
                \t1. Xem San pham Nhap Khau
                \t2. Xem San pham Xuat Khau
                \t3. Tro ve trang chu
                """);
        System.out.print("\tChon chuc nang: ");
        int choice = validate.inputIntegerInRange(1, 3);

        switch (choice){
            case 1 ->{
                nhapKhau.hienThi();
            }
            case 2 -> {
                xuatKhau.hienThi();
            }
            default -> {

            }
        }
    }

    public void timKiemSanPham(){
        System.out.println("""
                                
                \t--Tim kiem san pham--
                \t1. Tim San pham Nhap Khau
                \t2. Tim San pham Xuat Khau
                \t3. Tro ve trang chu""");
        System.out.print("\tChon chuc nang: ");
        int choice = validate.inputIntegerInRange(1, 3);

        switch (choice){
            case 1 -> {
                System.out.println("\t\tPhuong thuc tim kiem");
                System.out.println("""
                        \t\t1. Tim theo ma san pham
                        \t\t2. Tim theo ten san pham
                        """);
                System.out.print("\t\tChon chuc nang: ");
                int loai = validate.inputIntegerInRange(1,2);

                switch (loai){
                    case 1 -> {
                        try {
                            nhapKhau.timKiem("maSanPham");
                        } catch (NotFoundProductException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            nhapKhau.timKiem("tenSanPham");
                        } catch (NotFoundProductException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            case 2 ->{
                System.out.println("\t\tPhuong thuc tim kiem");
                System.out.println("""
                        \t\t1. Tim theo ma san pham
                        \t\t2. Tim theo ten san pham""");
                System.out.print("\t\tChon chuc nang: ");
                int loai = validate.inputIntegerInRange(1,2);

                switch (loai){
                    case 1 -> {
                        try {
                            xuatKhau.timKiem("maSanPham");
                        } catch (NotFoundProductException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            xuatKhau.timKiem("tenSanPham");
                        } catch (NotFoundProductException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
