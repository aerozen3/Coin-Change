import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [] rarr = new int[m];
        int [] arr = new int[m];
        for (int i = 0; i < m; i++) {
            rarr[i] = in.nextInt();
        }
        Arrays.sort(rarr);
        for (int i = 0; i < m; i++) {
            arr[i] = rarr[rarr.length - 1 -i];
            //  System.out.println(arr[i]);
        }
        long[][] cache = new long[n+1][arr.length];
        System.out.println(getChange(n, arr, 0, cache));
    }

    public static long getChange(int n, int [] arr, int index, long[][] cache) {
        if (index >= (arr.length-1)) {
            if (n % arr[index] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (cache[n][index] != 0) {
            return cache[n][index];
        }
        long ret = 0;
        int denom = arr[index];
        for (int i = 0; (i * denom) <= n; i++) {
            ret += getChange(n - (i*denom), arr, index + 1, cache);
        }
        cache[n][index] = ret;
        return ret;
    }
}