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
 * Created on Jun 1, 2016
 * Updated on $Date$
 */
package com.problems.codeforces;

import java.util.Scanner;

/**
 * @author avinash.rao
 *
 */
public class MovieWatching673A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int minWatchTime = 15;
        for (int i = 0; i < n; i++) {
            int kissTime = sc.nextInt();
            if (kissTime <= minWatchTime)
                minWatchTime = kissTime + 15;
            else
                break;
        }

        System.out.println(minWatchTime > 90 ? 90 : minWatchTime);
    }
}
