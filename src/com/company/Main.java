package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String scan = Scan();
        String[] scanSplit;
        try {
            scanSplit = scan.split(" ");
            Output(Calc(scanSplit));
        }
        catch(Exception e) {
            System.out.println("Введены некорретные значения");
            System.exit(0);
        }
    }

    private static int Calc(String[] scanSplit) {
        String Str1 = scanSplit[0];
        String Str2 = scanSplit[2];
        String MathSing = scanSplit[1];
        int Num1 = 0;
        int Num2 = 0;
        int result = 0;

        try {
            if (!TryMathSing(MathSing) || (!TryNum(Str1, Str2) && !TryArab(Str1, Str2))) {
                throw new Exception();
            }
        }
        catch(Exception e) {
            System.out.println("Введены некорретные значения");
            System.exit(0);
        }

        if (TryArab(Str1, Str2)) {
            Num1 = ArabConvert(Str1);
            Num2 = ArabConvert(Str2);
        }
        else {
            Num1 = Integer.parseInt(Str1);
            Num2 = Integer.parseInt(Str2);
        }

        switch (MathSing) {
            case "+":
                result = Num1 + Num2;
                break;
            case "-":
                result = Num1 - Num2;
                break;
            case "*":
                result = Num1 * Num2;
                break;
            case "/":
                result = Num1 / Num2;
                break;
        }
        return result;
    }

    private static String Scan() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите: ");
        String inputData = in.nextLine();;
        in.close();
        return inputData;
    }

    private static boolean TryNum(String arg1, String arg2) {
        String[] numList = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        if (Arrays.asList(numList).contains(arg1) && Arrays.asList(numList).contains(arg2)) {
            return true;
        }
        return false;
    }
    private static boolean TryArab(String arg1, String arg2) {
        String[] numList = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        if (Arrays.asList(numList).contains(arg1) && Arrays.asList(numList).contains(arg2)) {
            return true;
        }
        return false;
    }

    private static boolean TryMathSing(String arg) {
        String[] singList = new String[] {"+", "-", "*", "/"};
        if (Arrays.asList(singList).contains(arg)) {
            return true;
        }
        return false;
    }

    private static int ArabConvert(String arg) {
        int num = 0;
        switch (arg) {
            case "I": num = 1; break;
            case "II": num = 2; break;
            case "III": num = 3; break;
            case "IV": num = 4; break;
            case "V": num = 5; break;
            case "VI": num = 6; break;
            case "VII": num = 7; break;
            case "VIII": num = 8; break;
            case "IX": num = 9; break;
            case "X": num = 10; break;
        }
        return num;
    }

    private static void Output(int number) {
        System.out.println(number);
    }
}
