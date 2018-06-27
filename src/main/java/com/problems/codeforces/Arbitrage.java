package blackrock;

import java.util.Arrays;
import java.util.Scanner;

public class Arbitrage {

    static int[] arbitrage(String[] quotes) {
//        System.out.println(quotes.length);
        int[] res = new int[quotes.length];
        for (int i = 0; i < quotes.length; i++) {
            int initalAmount = 100000;
            System.out.println(quotes[i]);
            String[] q = quotes[i].split("\\s+");
//            System.out.println(Arrays.stream(q).collect(Collectors.toList()));
            Float usdToEur = Float.valueOf(q[0]);
            Float eurToGbp = Float.valueOf(q[1]);
            Float gbpToUsd = Float.valueOf(q[2]);

            int s1 = (int) (initalAmount * usdToEur);
            int s2 = (int) (s1 * eurToGbp);
            int s3 = (int) (s2 * gbpToUsd);
            if (s3 > 0)
                res[i] = initalAmount-s3;
            else
                res[i] = 0;
//            System.out.println("RES:"+(initalAmount-res[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String quotes[] = new String[n];
        int i = 0;
        sc.nextLine();
        while (n-- != 0) {
            quotes[i++] = sc.nextLine();
        }

        Arrays.stream(arbitrage(quotes))
                .forEach(System.out::println);
    }
}
