package entity;

/**
 * Project: Final
 * Package: entity
 * User: lomahs
 * Date time: 28/06/2021 18:45
 * Created with IntelliJ IDEA
 */
public abstract class SanPham {
    protected int id;
    protected String maSanPham;
    protected String ten;
    protected int giaBan;
    protected int soLuong;
    protected String nhaSanXuat;

    public SanPham() {
    }

    public SanPham(int id, String maSanPham, String ten, int giaBan, int soLuong, String nhaSanXuat) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.ten = ten;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public abstract void showInfo();
}
