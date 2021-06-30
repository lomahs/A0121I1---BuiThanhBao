package common.io;

import common.exception.NotFoundProductException;
import common.manage.FileManager;
import entity.SanPhamNhapKhau;
import entity.SanPhamXuatKhau;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Project: Final
 * Package: common.io
 * User: lomahs
 * Date time: 28/06/2021 11:44
 * Created with IntelliJ IDEA
 */
public class CSVWrite {
    final String SP_XUATKHAU_CSV = "src//data//SanPhamXuatKhau.csv";
    final String SP_NHAPKHAU_CSV = "src//data//SanPhamNhapKhau.csv";
    FileManager checker = new FileManager();

    CSVReader reader = new CSVReader();

    public void luuSPXuatKhau(SanPhamXuatKhau sp, boolean append) {
        try {
            BufferedWriter writer;
            CSVPrinter csvPrinter;
            if (append) {
                writer = Files.newBufferedWriter(Paths.get(SP_XUATKHAU_CSV), StandardOpenOption.APPEND);
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID",
                                "MaSanPham",
                                "TenSanPham",
                                "GiaBan",
                                "SoLuong",
                                "NhaSanXuat",
                                "GiaXuatKhau",
                                "QuocGiaNhapKhau")
                        .withSkipHeaderRecord(!checker.isFileEmpty(SP_XUATKHAU_CSV)));
            }else {
                writer = Files.newBufferedWriter(Paths.get(SP_XUATKHAU_CSV));
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID",
                                "MaSanPham",
                                "TenSanPham",
                                "GiaBan",
                                "SoLuong",
                                "NhaSanXuat",
                                "GiaXuatKhau",
                                "QuocGiaNhapKhau"));
            }

            csvPrinter.printRecord(
                    sp.getId(),
                    sp.getMaSanPham(),
                    sp.getTen(),
                    sp.getGiaBan(),
                    sp.getSoLuong(),
                    sp.getNhaSanXuat(),
                    sp.getGiaXuatKhau(),
                    sp.getQuocGiaNhapKhau());

            csvPrinter.flush();

            writer.close();
            csvPrinter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void luuSPNhapKhau(SanPhamNhapKhau sp, boolean append) {
        try {
            BufferedWriter writer;
            CSVPrinter csvPrinter;
            if (append) {
                writer = Files.newBufferedWriter(Paths.get(SP_NHAPKHAU_CSV), StandardOpenOption.APPEND);
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID",
                                "MaSanPham",
                                "TenSanPham",
                                "GiaBan",
                                "SoLuong",
                                "NhaSanXuat",
                                "GiaNhapKhau",
                                "TinhThanhNhap",
                                "ThueNhapKhau")
                        .withSkipHeaderRecord(!checker.isFileEmpty(SP_NHAPKHAU_CSV)));
            }else {
                writer = Files.newBufferedWriter(Paths.get(SP_NHAPKHAU_CSV));
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID",
                                "MaSanPham",
                                "TenSanPham",
                                "GiaBan",
                                "SoLuong",
                                "NhaSanXuat",
                                "GiaNhapKhau",
                                "TinhThanhNhap",
                                "ThueNhapKhau"));
            }

            csvPrinter.printRecord(
                    sp.getId(),
                    sp.getMaSanPham(),
                    sp.getTen(),
                    sp.getGiaBan(),
                    sp.getSoLuong(),
                    sp.getNhaSanXuat(),
                    sp.getGiaNhapKhau(),
                    sp.getTinhThanhNhapKhau(),
                    sp.getThueNhapKhau());

            csvPrinter.flush();

            writer.close();
            csvPrinter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void xoaSanPham(String sp, String ma) throws NotFoundProductException {
        try {
            File file;
            if (sp.equals("nhapkhau")){
                file = new File(SP_NHAPKHAU_CSV);
                ArrayList<SanPhamNhapKhau> list = reader.docSPNhapKhau();
                if (list.isEmpty()){
                    throw new NotFoundProductException("\tDanh sach trong!");
                }

                list.removeIf(sanPham -> sanPham.getMaSanPham().equals(ma));

                if (list.isEmpty()){
                    file.delete();
                    file.createNewFile();
                    return;
                }

                for (int i = 0; i < list.size(); i++) {
                    if (i == 0){
                        luuSPNhapKhau(list.get(i),false);
                    }else {
                        luuSPNhapKhau(list.get(i),true);
                    }
                }


            }else {
                file = new File(SP_XUATKHAU_CSV);
                ArrayList<SanPhamXuatKhau> list = reader.docSPXuatKhau();
                if (list.isEmpty()){
                    throw new NotFoundProductException("\tDanh sach trong!");
                }

                list.removeIf(sanPham -> sanPham.getMaSanPham().equals(ma));

                if (list.isEmpty()){
                    file.delete();
                    file.createNewFile();
                    return;
                }

                for (int i = 0; i < list.size(); i++) {
                    if (i == 0){
                        luuSPXuatKhau(list.get(i),false);
                    }else {
                        luuSPXuatKhau(list.get(i),true);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
