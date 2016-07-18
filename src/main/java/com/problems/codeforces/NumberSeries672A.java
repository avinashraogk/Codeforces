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
public class NumberSeries672A {

    String number;

    NumberSeries672A() {
        init();
    }

    void init() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1, p = 0; p <= 1000; i++) {
            String number = i + "";
            for (int j = 0; j < number.length(); j++, p++) {
                sb.append(number.charAt(j));
            }
        }
        number = sb.toString();
    }

    public static void main(String[] args) {
        NumberSeries672A numberSeries = new NumberSeries672A();
        Scanner sc = new Scanner(System.in);
        System.out.println(numberSeries.number.charAt(sc.nextInt() - 1));

    }
}
