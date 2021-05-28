package studentlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Project: Practice
 * Package: studentlist
 * User: lomahs
 * Date time: 27/05/2021 15:51
 * Created with IntelliJ IDEA
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Bao", 22);
        hashMap.put("Tuan", 21);
        hashMap.put("Phu", 20);
        hashMap.put("Nhi", 23);
        hashMap.put("My", 21);
        System.out.println("Hash map: " + hashMap);

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Tree map: " + treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Bao",22);
        linkedHashMap.put("Tuan", 21);
        linkedHashMap.put("Phu", 20);
        linkedHashMap.put("Nhi", 23);
        linkedHashMap.put("My", 21);
        System.out.println("Age of Bao is " + linkedHashMap.get("Bao"));
    }
}
