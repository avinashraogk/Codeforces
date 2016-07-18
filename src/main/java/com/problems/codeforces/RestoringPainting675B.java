/*
 * Copyright (c) Rakuten, Inc. All Rights Reserved.
 * 
 * This program is the information assets which are handled
 * as "Strictly Confidential".
 * Permission of Use is only admitted in Rakuten Inc.
 * Development Department.
 * If you don't have permission , MUST not be published,
 * broadcast, rewritten for broadcast or publication
 * or redistributed directly or indirectly in any medium.
 * 
 * $Id$
 * Created on May 28, 2016
 * Updated on $Date$
 */
package com.problems.codeforces;

import java.util.Scanner;

/**
 * @author avinash.rao
 *
 */
public class RestoringPainting675B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(solve(n, a, b, c, d));
    }

    private static long solve(int n, int a, int b, int c, int d) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = i + a + b;
            int q = sum - a - c;
            int r = sum - b - d;
            int s = sum - c - d;
            // System.out.println("When P:" + i + " q:" + q + " r:" + r + " s:" + s);
            if (valid(q, n) && valid(r, n) && valid(s, n))
                count++;
        }
        // System.out.println("count:" + count + " result:" + result);
        return (long) count * n;
    }

    private static boolean valid(int v, int n) {
        return v >= 1 && v <= n;
    }
}
