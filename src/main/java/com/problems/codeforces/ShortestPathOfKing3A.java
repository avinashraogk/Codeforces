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
 * Created on Jul 18, 2016
 * Updated on $Date$
 */
package com.problems.codeforces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author avinash.rao
 *
 */
public class ShortestPathOfKing3A {
    void kingMoves(String from, String to) {
        int x1 = from.charAt(0) - 'a' + 1;
        int y1 = from.charAt(1) - '0';
        List<String> list = new ArrayList<String>();
        int x2 = to.charAt(0) - 'a' + 1;
        int y2 = to.charAt(1) - '0';
        while (x1 != x2 || y1 != y2) {

            if (x1 == x2 && y1 < y2) {
                y1++;
                list.add("U");
            }
            else if (x1 == x2 && y1 > y2) {
                y1--;
                list.add("D");
            }
            else if (x1 < x2 && y2 == y1) {
                x1++;
                list.add("R");
            } else if (x1 > x2 && y2 == y1) {
                x1--;
                list.add("L");
            } else if (x1 > x2 && y1 < y2) {
                y1++;
                x1--;
                list.add("LU");
            } else if (x1 > x2 && y1 > y2) {
                y1--;
                x1--;
                list.add("LD");
            } else if (x1 < x2 && y1 < y2) {
                y1++;
                x1++;
                list.add("RU");
            } else if (x1 < x2 && y1 > y2) {
                y1--;
                x1++;
                list.add("RD");
            }
        }

        System.out.println(list.size());
        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String from = sc.next();
        String to = sc.next();
        new ShortestPathOfKing3A().kingMoves(from, to);
    }
}
