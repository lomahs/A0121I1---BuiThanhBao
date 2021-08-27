package service;

import bean.TiecCuoi;
import repository.Repository;

import java.sql.Date;
import java.util.List;

public class Service implements IService{
    Repository repository = new Repository();

    @Override
    public void datTiecCuoi(Date ngayToChuc,
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
                            String trangThai) {
        repository.datTiecCuoi(
                ngayToChuc,
                tenCoDau,
                tenChuRe,
                soLuongBan,
                donGia,
                dichVuDiKem,
                tienNoDatCoc,
                tienNoThanhToan,
                ngayDatCoc,
                ngayThanhToan,
                ghiChu,
                trangThai);
    }

    @Override
    public List<TiecCuoi> xemCacTiecCuoi() {
        return repository.xemCacTiecCuoi();
    }

    @Override
    public void suaTiecCuoi(int idTiecCanSua, Date ngayToChuc, String tenCoDau, String tenChuRe, int soLuongBan, int donGia, int dichVuDiKem, int tienNoDatCoc, int tienNoThanhToan, Date ngayDatCoc, Date ngayThanhToan, String ghiChu, String trangThai) {
        repository.suaTiecCuoi(
                idTiecCanSua,
                ngayToChuc,
                tenCoDau,
                tenChuRe,
                soLuongBan,
                donGia,
                dichVuDiKem,
                tienNoDatCoc,
                tienNoThanhToan,
                ngayDatCoc,
                ngayThanhToan,
                ghiChu,
                trangThai);
    }

    @Override
    public void xoaTiecCuoi(int id) {
        repository.xoaTiecCuoi(id);
    }
}
