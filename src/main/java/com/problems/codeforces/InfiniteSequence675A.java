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
public class InfiniteSequence675A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        String result = "No";
        if (d > 0) {
            if (b >= a && (b - a) % d == 0) {
                result = "Yes";
            }
        } else if (d < 0) {
            if (b <= a && (a - b) % -d == 0) {
                result = "Yes";
            }
        } else {
            if (a == b)
                result = "Yes";
        }
        System.out.println(result);
    }
}
