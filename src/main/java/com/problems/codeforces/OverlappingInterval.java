package booking.com;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class OverlappingInterval {

    static void merge_overlapping_intervals() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        while (n-- != 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            map.put(start, end);
        }
        Map<Integer, Integer> newMap = new TreeMap<>(map);
        map.forEach((k, v) -> {
            Set<Integer> keySet = map.keySet();
            for (int key : keySet) {
                if (key < v && map.get(key) > v) {
                    newMap.put(k, map.get(key));
                    newMap.remove(key);
                }
            }
        });

        System.out.println(newMap.size());
        newMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
    public static void main(String[] args) {
        merge_overlapping_intervals();
    }
}
