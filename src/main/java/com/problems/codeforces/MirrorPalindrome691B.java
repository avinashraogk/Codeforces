package com.problems.codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author avinash.rao
 *
 */
public class MirrorPalindrome691B {

    public static void main(String[] args) {
        Map<Character, Character> mirrorImage = new HashMap<>();
        mirrorImage.put('A', 'A');
        mirrorImage.put('H', 'H');
        mirrorImage.put('I', 'I');
        mirrorImage.put('M', 'M');
        mirrorImage.put('O', 'O');
        mirrorImage.put('T', 'T');
        mirrorImage.put('U', 'U');
        mirrorImage.put('V', 'V');
        mirrorImage.put('W', 'W');
        mirrorImage.put('X', 'X');
        mirrorImage.put('Y', 'Y');
        mirrorImage.put('H', 'H');
        mirrorImage.put('b', 'd');
        mirrorImage.put('d', 'b');
        mirrorImage.put('o', 'o');
        mirrorImage.put('p', 'q');
        mirrorImage.put('q', 'p');
        mirrorImage.put('v', 'v');
        mirrorImage.put('w', 'w');
        mirrorImage.put('x', 'x');
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int len = string.length() - 1;
        boolean sPalindrome = true;
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != mirrorImage.getOrDefault(string.charAt(len - i), '-')) {
                System.out.println("NIE");
                sPalindrome = false;
                break;
            }
        }
        if (sPalindrome && string.length() % 2 != 0) {
            if (string.charAt(string.length() / 2) != mirrorImage.getOrDefault(string.charAt(string.length() / 2), '-')) {
                System.out.println("NIE");
                sPalindrome = false;
            }
        }
        if (sPalindrome) {
            System.out.println("TAK");
        }
    }
}
