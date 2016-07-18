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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author avinash.rao
 *
 */
public class ChewbakkaAndNumber514A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        System.out.println(getLeastNumberByReversingSomeDigits(number));
    }

    private static String getLeastNumberByReversingSomeDigits(String number) {

        StringBuilder sb = new StringBuilder();
        int num = number.charAt(0) - '0';
        if (num >= 5 && num < 9)
            sb.append(9 - num);
        else
            sb.append(num);
        for (int i = 1, j = number.length(); i < j; i++) {
            num = number.charAt(i) - '0';
            if (num >= 5)
                sb.append(9 - num);
            else
                sb.append(num);
        }
        return sb.toString();
    }
}
