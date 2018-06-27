package cracking.coing.interview.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Hash_Tables_Ransom_Note {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Map<String,Integer> wordCount = new HashMap<>();
    
    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }

        Arrays.stream(magazine).forEach(_03_Hash_Tables_Ransom_Note::addToMap);
        boolean isAllFound = Arrays.stream(ransom).allMatch(_03_Hash_Tables_Ransom_Note::isPresent);
        
        if(isAllFound) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        scanner.close();
    }
    
    static boolean isPresent(String ransonWord) {
        Integer remainingWordCount = wordCount.getOrDefault(ransonWord, 0);
        if(remainingWordCount==0) {
            return false;
        }
        wordCount.put(ransonWord, remainingWordCount-1);
        return true;
    }
    static void addToMap(String magazineWord) {
        Integer currentValue = wordCount.putIfAbsent(magazineWord, 1);
        if(currentValue!=null) {
            wordCount.put(magazineWord, ++currentValue);
        }
    }
}
