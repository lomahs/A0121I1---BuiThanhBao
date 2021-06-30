package entity;

/**
 * Project: Final
 * Package: entity
 * User: lomahs
 * Date time: 28/06/2021 18:45
 * Created with IntelliJ IDEA
 */
public class SanPhamXuatKhau extends SanPham{
    private int giaXuatKhau;
    private String quocGiaNhapKhau;

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(int id, String maSanPham, String ten, int giaBan, int soLuong, String nhaSanXuat, int giaXuatKhau, String quocGiaNhapKhau) {
        super(id, maSanPham, ten, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapKhau = quocGiaNhapKhau;
    }

    public int getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(int giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapKhau() {
        return quocGiaNhapKhau;
    }

    public void setQuocGiaNhapKhau(String quocGiaNhapKhau) {
        this.quocGiaNhapKhau = quocGiaNhapKhau;
    }

    @Override
    public void showInfo() {
        System.out.printf("\t\t%-3d %-10s %-13s %-10d %-8d %-11s %-12d %-14s\n",
                id,
                maSanPham,
                ten,
                giaBan,
                soLuong,
                nhaSanXuat,
                giaXuatKhau,
                quocGiaNhapKhau);
    }
}
