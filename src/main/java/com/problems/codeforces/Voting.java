package blackrock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Voting {

    static String electionWinner(String[] votes) {
        Map<String, Integer> map = new TreeMap<>((e1,e2) -> e1.compareTo(e2));

            Arrays.stream(votes)
            .forEach(s -> {
                Integer currentValue = map.get(s);
                if (currentValue == null) {
                    map.put(s, 1);
                } else {
                    map.put(s, 1 + currentValue);
                }
            });
            List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Entry.comparingByValue());
//            System.out.println("LIST : "+list);
            return list.get(list.size()-1).getKey();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String quotes[] = new String[n];
        int i = 0;
        sc.nextLine();
        while (n-- != 0) {
            quotes[i++] = sc.nextLine();
        }
        
        System.out.println(electionWinner(quotes));
    }
}
