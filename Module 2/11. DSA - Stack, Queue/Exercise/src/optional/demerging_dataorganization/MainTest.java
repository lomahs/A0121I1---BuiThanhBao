package optional.demerging_dataorganization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        Student sv1 = new Student("Bao","Male", "05/10/1999");
        Student sv2 = new Student("Nhi","Female","17/01/2000");
        Student sv3 = new Student("Hong","Female","10/09/1999");
        Student sv4 = new Student("Tuan","Male","30/07/1999");
        Student sv5 = new Student("Phu","Male","09/06/2001");

        List<Student> list = new ArrayList<>();

        list.add(sv1);
        list.add(sv2);
        list.add(sv3);
        list.add(sv4);
        list.add(sv5);

        Collections.sort(list);
        Manage manage = new Manage();

        manage.demerging(list);
        manage.display();
    }
}
