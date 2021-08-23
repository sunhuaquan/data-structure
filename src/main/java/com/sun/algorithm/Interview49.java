package com.sun.algorithm;

public class Interview49 {

    public static int GetUglyNumber_Solution(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[m2] * 2, Math.min(ugly[m3] * 3, ugly[m5] * 5));
            if (ugly[i] == ugly[m2] * 2) {
                m2++;
            }
            if (ugly[i] == ugly[m3] * 3) {
                m3++;
            }
            if (ugly[i] == ugly[m5] * 5) {
                m5++;
            }
        }
        return ugly[n - 1];
    }


    public static void main(String[] args) {

        System.out.println(Interview49.GetUglyNumber_Solution(1000000));
    }

    public static void print(int[] p) {

        for (int i = 0; i < p.length; i++) {
            System.out.print("\t" + i + ":[" + p[i] + "]");
        }
        System.out.print("\n");
    }

}
