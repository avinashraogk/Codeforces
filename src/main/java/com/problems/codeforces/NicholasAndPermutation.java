package com.problems.codeforces;

import static java.lang.Math.max;

import java.util.Scanner;

public class NicholasAndPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int ps = 0, pb = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == 1)
                ps = i;
            if (a[i] == n)
                pb = i;
        }
        if (a[0] == 1 || a[0] == n || a[n - 1] == 1 || a[n - 1] == n) {
            System.out.println(n - 1);
            return;
        }
        int p = n - ps - 1, q = n - pb - 1, r = ps, s = pb;
        System.out.println(max(p, max(q, max(r, s))));

    }
}
