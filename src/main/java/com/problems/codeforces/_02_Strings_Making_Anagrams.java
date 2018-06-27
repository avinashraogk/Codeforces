package cracking.coing.interview.ds;

import java.util.Scanner;

public class _02_Strings_Making_Anagrams {

    private static final Scanner scanner = new Scanner(System.in);
    // static int a_array[] = new int[26];
    // static int b_array[] = new int[26];
    static int c_array[] = new int[26];
     public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        scanner.close();

        for (char c : a.toCharArray()) {
            int index = c - 'a';
//            a_array[index]++;
            c_array[index]++;
        }

        for (char c : b.toCharArray()) {
            int index = c - 'a';
//            b_array[index]++;
            --c_array[index];
        }

//        int sum = 0;
        int sum2=0;
        for (int i = 0; i < 26; i++) {
//            sum += diff(a_array[i], b_array[i]);
            sum2+= Math.abs(c_array[i]);
        }
        
//        System.out.println(sum);
        System.out.println(sum2);
    }

    static int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }
}
