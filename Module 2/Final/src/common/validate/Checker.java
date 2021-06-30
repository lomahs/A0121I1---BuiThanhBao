package common.validate;

import common.io.CSVReader;
import entity.SanPhamNhapKhau;
import entity.SanPhamXuatKhau;

import java.util.ArrayList;

public class Checker {
    CSVReader reader = new CSVReader();

    public boolean kiemTraMaTonTai(String ma, String product) {

        if (product.equals("nhapkhau")) {
            ArrayList<SanPhamNhapKhau> listVilla = reader.docSPNhapKhau();

            for (SanPhamNhapKhau sanPhamNhapKhau : listVilla) {
                if (sanPhamNhapKhau.getMaSanPham().equals(ma)) {
                    return true;
                }
            }
        }
        if (product.equals("xuatkhau")) {
            ArrayList<SanPhamXuatKhau> listHouse = reader.docSPXuatKhau();

            for (SanPhamXuatKhau sanPhamXuatKhau : listHouse) {
                if (sanPhamXuatKhau.getMaSanPham().equals(ma)) {
                    return true;
                }
            }
        }

        return false;
    }

//    public boolean isIDCustomerExist(String id) {
//        try {
//            ArrayList<Customer> listCustomer = reader.readCustomerCSV();
//
//            for (Customer customer : listCustomer) {
//                if (customer.getId().equals(id)) {
//                    return true;
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }

}
