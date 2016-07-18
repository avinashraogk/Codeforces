package com.problems.codeforces;

import java.util.Scanner;

public class DifferentIsGood672B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        String s = sc.next();
        long distinct = s.chars().distinct().count();
        long diff = s.length() - distinct;
        System.out.println(diff < 26 ? diff : -1);
    }
}
