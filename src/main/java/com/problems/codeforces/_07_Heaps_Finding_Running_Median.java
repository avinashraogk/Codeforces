package cracking.coing.interview.ds;

import java.util.Arrays;
import java.util.Scanner;

public class _07_Heaps_Finding_Running_Median {

    private static final Scanner scanner = new Scanner(System.in);

    private static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l] > a[largest]) {
            largest = l;
        }
        if (r < n && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, n, largest);
        }
    }

    private static void heapsort(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int top = a[0];
            a[0] = a[i];
            a[i] = top;
            heapify(a, i, 0);
        }
        System.out.println("----");
        Arrays.stream(a).forEach(System.out::println);
        System.out.println("----");
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            heapsort(a,i);
        }

        scanner.close();
    }
}
