package common.io;

import entity.SanPhamNhapKhau;
import entity.SanPhamXuatKhau;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Project: Final
 * Package: common.io
 * User: lomahs
 * Date time: 28/06/2021 12:57
 * Created with IntelliJ IDEA
 */
public class CSVReader {
    final String SP_XUATKHAU_CSV = "src//data//SanPhamXuatKhau.csv";
    final String SP_NHAPKHAU_CSV = "src//data//SanPhamNhapKhau.csv";

    public ArrayList<SanPhamNhapKhau> docSPNhapKhau(){
        ArrayList<SanPhamNhapKhau> list = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(SP_NHAPKHAU_CSV));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                    "ID",
                    "MaSanPham",
                    "TenSanPham",
                    "GiaBan",
                    "NhaSanXuat",
                    "GiaNhapKhau",
                    "TinhThanhNhap",
                    "ThueNhapKhau").withSkipHeaderRecord());


            for (CSVRecord csvRecord : csvParser) {
                int id = Integer.parseInt(csvRecord.get(0));
                String ma = csvRecord.get(1);
                String ten = csvRecord.get(2);
                int gia = Integer.parseInt(csvRecord.get(3));
                int soLuong = Integer.parseInt(csvRecord.get(4));
                String nhaSanXuat = csvRecord.get(5);
                int giaNhapKhau = Integer.parseInt(csvRecord.get(6));
                String tinhThanh = csvRecord.get(7);
                int thue = Integer.parseInt(csvRecord.get(8));

                list.add(new SanPhamNhapKhau(id,ma,ten,gia,soLuong,nhaSanXuat,giaNhapKhau,tinhThanh,thue));

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<SanPhamXuatKhau> docSPXuatKhau(){
        ArrayList<SanPhamXuatKhau> list = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(SP_XUATKHAU_CSV));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                    "ID",
                    "MaSanPham",
                    "TenSanPham",
                    "GiaBan",
                    "SoLuong",
                    "NhaSanXuat",
                    "GiaXuatKhau",
                    "QuocGiaNhapKhau").withSkipHeaderRecord());


            for (CSVRecord csvRecord : csvParser) {
                int id = Integer.parseInt(csvRecord.get(0));
                String ma = csvRecord.get(1);
                String ten = csvRecord.get(2);
                int gia = Integer.parseInt(csvRecord.get(3));
                int soLuong = Integer.parseInt(csvRecord.get(4));
                String nhaSanXuat = csvRecord.get(5);
                int giaXuatKhau = Integer.parseInt(csvRecord.get(6));
                String quocGia = csvRecord.get(7);

                list.add(new SanPhamXuatKhau(id,ma,ten,gia,soLuong,nhaSanXuat,giaXuatKhau,quocGia));

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

}
