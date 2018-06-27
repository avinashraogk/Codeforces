package com.problems.codeforces;

import java.util.Scanner;

// Not Solved
// http://codeforces.com/contest/957/my

/**
 * Solution :
 * 
 *  This problem has several cases.
 *  1. No , if there is no empty space to paint.
 *  2. No , if Existing pattern already is wrong.
 *  3. Yes, if two continuous empty space present.
 *  4. Yes, if first or last slot is empty.
 *  5. Yes, if same color is painted both side of empty side.
 *  6. No, in all other case ! i.e. Empty is covered by other two colors in all places.
 *  
 *  Status : ACCEPTED !!!
 *  
 * @author avinash.rao
 *
 */
public class A957_TritonicIridescence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
//--------------------------------------------------------------------
        boolean noSpaceForPainting = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                noSpaceForPainting = false;
                break;
            }
        }
        if (noSpaceForPainting) {
            System.out.println("No");
            return;
        }
//--------------------------------------------------------------------        
        boolean existingWrong = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.charAt(i) == s.charAt(i + 1)) && s.charAt(i) != '?') {
                existingWrong = true;
                break;
            }
        }
        if (existingWrong) {
            System.out.println("No");
            return;
        }
//--------------------------------------------------------------------
        boolean twoQuestionMark = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.charAt(i) == s.charAt(i + 1)) && s.charAt(i) == '?') {
                twoQuestionMark = true;
                break;
            }
        }
        if (twoQuestionMark) {
            System.out.println("Yes");
            return;
        }
//--------------------------------------------------------------------
        if(s.charAt(0)=='?'||s.charAt(s.length()-1)=='?') {
            System.out.println("Yes");
            return;
        }
//--------------------------------------------------------------------
        boolean adjecentSame = false;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '?' && checkAdjecentSame(s.charAt(i - 1), s.charAt(i + 1))) {
                adjecentSame = true;
                break;
            }
        }
        if (adjecentSame)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
//--------------------------------------------------------------------
    private static boolean checkAdjecentSame(char c1, char c2) {
        if (isColor(c1) && isColor(c2)) {
            return c1 == c2;
        }
        return true;
    }

    private static boolean isColor(char c) {
        return c != '?';
    }
}
