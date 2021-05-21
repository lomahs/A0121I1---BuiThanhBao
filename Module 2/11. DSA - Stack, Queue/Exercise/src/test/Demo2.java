package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo2 {
//    public static void demoSet2() {
//        Set<SinhVien> sinhViens = new HashSet<>();
//        sinhViens.add(new SinhVien("01", "Nga", 22, "Da nang"));
//        sinhViens.add(new SinhVien("02", "Do", 21, "Quang Nam"));
//        sinhViens.add(new SinhVien("03", "Uyen", 23, "Da nang"));
//        sinhViens.add(new SinhVien("04", "Bao", 20, "Hue"));
//        sinhViens.add(new SinhVien("05", "Vuong", 19, "Quang Tri"));
//    }

    public static void main(String[] args) {
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        sinhViens.add(new SinhVien("01", "Nga", 22, "Da nang"));
        sinhViens.add(new SinhVien("02", "Do", 21, "Quang Nam"));
        sinhViens.add(new SinhVien("03", "Uyen", 23, "Da nang"));
        sinhViens.add(new SinhVien("04", "Bao", 20, "Hue"));
        sinhViens.add(new SinhVien("05", "Vuong", 19, "Quang Tri"));

        for (SinhVien sinhVien : sinhViens) {
            if (sinhVien.getAddress().equals("Da nang")){
                System.out.println(sinhVien.toString());
            }
        }
    }
}