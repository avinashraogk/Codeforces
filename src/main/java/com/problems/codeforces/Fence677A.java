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
 * Created on Jun 3, 2016
 * Updated on $Date$
 */
package com.problems.codeforces;

import java.util.Scanner;

/**
 * @author avinash.rao
 *
 */
public class Fence677A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int width = 0;
        while (n-- > 0) {
            width += sc.nextInt() > h ? 2 : 1;
        }
        System.out.println(width);
    }
}
