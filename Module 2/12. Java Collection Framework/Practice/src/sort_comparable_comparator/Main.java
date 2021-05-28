package sort_comparable_comparator;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: Practice
 * Package: sort_comparable_comparator
 * User: lomahs
 * Date time: 28/05/2021 09:42
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Bao", 22,"DN");
        Student student2 = new Student("Nhi", 21,"GL");
        Student student3 = new Student("Hip", 24,"HUE");
        Student student4 = new Student("Hip", 21,"HUE");

        List<Student> list = new ArrayList<Student>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        //sort by name
        Collections.sort(list);

        System.out.println("Sort by name");
        list.forEach(student -> System.out.println(student.toString()));

        //sort by age
        list.sort(new AgeComparator());
        System.out.println("Sort by age");
        list.forEach(student -> System.out.println(student.toString()));

    }
}
