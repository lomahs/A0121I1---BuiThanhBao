package distinguish_hashmap_hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project: Practice
 * Package: distinguish_hashmap_hashset
 * User: lomahs
 * Date time: 27/05/2021 20:47
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Bao", 22,"DN");
        Student student2 = new Student("Nhi", 21,"GL");
        Student student3 = new Student("Hip", 24,"HUE");

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);

        studentMap.forEach((key,value) -> System.out.println(key + " - "  + value.toString()));

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student1);

        studentSet.forEach(System.out::println);
    }
}
