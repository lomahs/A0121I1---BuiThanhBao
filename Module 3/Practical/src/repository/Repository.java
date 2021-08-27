package repository;

import bean.TiecCuoi;
import util.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

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
        String INSERT_TIECCUOI = "INSERT INTO ThongTinTiecCuoi (ngayToChuc, " +
                "tenCoDau, " +
                "tenChuRe, " +
                "soLuongBan, " +
                "donGia, " +
                "dichVuDiKem, " +
                "tienNoDatCoc, " +
                "tienNoThanhToan, " +
                "ngayDatCoc, " +
                "ngayThanhToan, " +
                "ghiChu, " +
                "trangThai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            conn = DBContext.getConnection();
            pstmt = conn.prepareStatement(INSERT_TIECCUOI);

            pstmt.setDate(1,ngayDatCoc);
            pstmt.setString(2,tenCoDau);
            pstmt.setString(3,tenChuRe);
            pstmt.setInt(4,soLuongBan);
            pstmt.setInt(5,donGia);
            pstmt.setInt(6,dichVuDiKem);
            pstmt.setInt(7,tienNoDatCoc);
            pstmt.setInt(8,tienNoThanhToan);
            pstmt.setDate(9,ngayDatCoc);
            pstmt.setDate(10,ngayThanhToan);
            pstmt.setString(11,ghiChu);
            pstmt.setString(12,trangThai);

            pstmt.executeUpdate();
            System.out.println(pstmt);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<TiecCuoi> xemCacTiecCuoi() {
        List<TiecCuoi> list = new ArrayList<>();

        String SELECT_ALL_TIECCUOI = "SELECT TT.id,\n" +
                "       TT.ngayToChuc,\n" +
                "       TT.tenCoDau,\n" +
                "       TT.tenChuRe,\n" +
                "       TT.soLuongBan,\n" +
                "       TT.donGia,\n" +
                "       DV.tenDichVu,\n" +
                "       TT.tienNoDatCoc,\n" +
                "       TT.tienNoThanhToan,\n" +
                "       TT.ngayDatCoc,\n" +
                "       TT.ngayThanhToan,\n" +
                "       TT.ghiChu,\n" +
                "       TT.trangThai\n" +
                "FROM ThongTinTiecCuoi TT JOIN DichVu DV ON DV.idDichVu = TT.dichVuDiKem;";

        try {
            conn = DBContext.getConnection();
            pstmt = conn.prepareStatement(SELECT_ALL_TIECCUOI);
            rs = pstmt.executeQuery();

            System.out.println(pstmt);

            while (rs.next()) {
                list.add(new TiecCuoi(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getDate(10),
                        rs.getDate(11),
                        rs.getString(12),
                        rs.getString(13)
                ));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public void suaTiecCuoi(int idTiecCanSua, Date ngayToChuc, String tenCoDau, String tenChuRe, int soLuongBan, int donGia, int dichVuDiKem, int tienNoDatCoc, int tienNoThanhToan, Date ngayDatCoc, Date ngayThanhToan, String ghiChu, String trangThai) {

    }

    @Override
    public void xoaTiecCuoi(int id) {

    }
}
