package entity;

/**
 * Project: Final
 * Package: entity
 * User: lomahs
 * Date time: 28/06/2021 18:45
 * Created with IntelliJ IDEA
 */
public class SanPhamNhapKhau extends SanPham{
    private int giaNhapKhau;
    private String tinhThanhNhapKhau;
    private int thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(int id, String maSanPham, String ten, int giaBan, int soLuong, String nhaSanXuat, int giaNhapKhau, String tinhThanhNhapKhau, int thueNhapKhau) {
        super(id, maSanPham, ten, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhapKhau = tinhThanhNhapKhau;
        this.thueNhapKhau = thueNhapKhau;
    }

    public int getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(int giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhapKhau() {
        return tinhThanhNhapKhau;
    }

    public void setTinhThanhNhapKhau(String tinhThanhNhapKhau) {
        this.tinhThanhNhapKhau = tinhThanhNhapKhau;
    }

    public int getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(int thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public void showInfo() {
        System.out.printf("\t\t%-3d %-10s %-13s %-10d %-8d %-11s %-12d %-14s %-13d\n",
                id,
                maSanPham,
                ten,
                giaBan,
                soLuong,
                nhaSanXuat,
                giaNhapKhau,
                tinhThanhNhapKhau,
                thueNhapKhau);
    }
}
