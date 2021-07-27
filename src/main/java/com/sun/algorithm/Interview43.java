package com.sun.algorithm;


public class Interview43 {


    public static void main(String[] args) {

        int i = numberOf1Between1AndN(21235);
        System.out.println(i);
    }

    public static int numberOf1Between1AndN(int n) {

        if (n <= 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        return numberOf1(sb, 0);
    }


    private static int numberOf1(StringBuilder sb, int digitIndex) {

        int first = sb.charAt(digitIndex) - '0';
        int numberOfFirst = 0;
        int length = sb.length() - digitIndex;
        if (length == 1 && first == 0) {
            return 0;
        } else if (length == 1 && first > 0) {
            return 1;
        }
        if (first > 1) {
            //当前位
            numberOfFirst = powerOf10(length - 1);
        } else if (first == 1) {
            //
            numberOfFirst = getNext(sb, digitIndex + 1) + 1;
        }

        int numberOther = first * (length - 1) * powerOf10(length - 2);

        return numberOfFirst + numberOther + numberOf1(sb, digitIndex + 1);
    }

    private static int getNext(StringBuilder sb, int length) {

        int result = 0;
        for (int i = length; i < sb.length(); i++) {
            result= result * 10 + (sb.charAt(i)-'0');
        }
        return result;
    }

    public static int powerOf10(int length) {

        int result = 1;
        for (int i = 0; i < length; i++) {
            result *= 10;
        }
        return result;

    }

}
