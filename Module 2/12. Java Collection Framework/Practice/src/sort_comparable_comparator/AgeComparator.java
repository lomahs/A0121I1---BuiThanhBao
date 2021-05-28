package sort_comparable_comparator;

import java.util.Comparator;

/**
 * Project: Practice
 * Package: sort_comparable_comparator
 * User: lomahs
 * Date time: 28/05/2021 09:41
 * Created with IntelliJ IDEA
 */
public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
