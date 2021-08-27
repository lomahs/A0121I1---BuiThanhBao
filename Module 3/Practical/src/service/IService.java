package service;

import bean.TiecCuoi;

import java.sql.Date;
import java.util.List;

public interface IService {

    void datTiecCuoi(Date ngayToChuc,
                     String tenCoDau,
                     String tenChuRe,
                     int soLuongBan,
                     int donGia,
                     int dichVuDiKem,
                     int tienNoDatCoc,
                     int tienNoThanhToan,
                     Date ngayDatCoc,
                     Date ngayThanhToan,
                     String ghiChu,
                     String trangThai);

    List<TiecCuoi> xemCacTiecCuoi();

    void suaTiecCuoi(
            int idTiecCanSua,
            Date ngayToChuc,
            String tenCoDau,
            String tenChuRe,
            int soLuongBan,
            int donGia,
            int dichVuDiKem,
            int tienNoDatCoc,
            int tienNoThanhToan,
            Date ngayDatCoc,
            Date ngayThanhToan,
            String ghiChu,
            String trangThai);

    void xoaTiecCuoi(int id);
}
