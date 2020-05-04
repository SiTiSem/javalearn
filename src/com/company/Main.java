package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String scan = Scan();
        String[] scanSplit;
        try {
            scanSplit = scan.split(" ");
            Calc(scanSplit);
        }
        catch(Exception e) {
            System.out.println("Введены некорретные значения");
            System.exit(0);
        }
    }

    private static void Calc(String[] scanSplit) {
        String Str1 = scanSplit[0];
        String Str2 = scanSplit[2];
        String MathSing = scanSplit[1];
        int Num1 = 0;
        int Num2 = 0;

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
            int result = Math(MathSing, Num1, Num2);
            System.out.println(RomeConvert(result));
        }
        else {
            Num1 = Integer.parseInt(Str1);
            Num2 = Integer.parseInt(Str2);
            int result = Math(MathSing, Num1, Num2);
            System.out.println(result);
        }
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

    private static String RomeConvert(int arg) {
        int i = arg / 10;
        int mod = arg % 10;
        String a1 = "";
        String a2 = "";
        switch (i) {
            case 1: a1 = "X"; break;
            case 2: a1 = "XX"; break;
            case 3: a1 = "XXX"; break;
            case 4: a1 = "XL"; break;
            case 5: a1 = "L"; break;
            case 6: a1 = "LX"; break;
            case 7: a2 = "LXX"; break;
            case 8: a2 = "LXXX"; break;
            case 9: a2 = "XC"; break;
            case 10: a2 = "C"; break;
        }
        switch (mod) {
            case 1: a2 = "I"; break;
            case 2: a2 = "II"; break;
            case 3: a2 = "III"; break;
            case 4: a2 = "IV"; break;
            case 5: a2 = "V"; break;
            case 6: a2 = "VI"; break;
            case 7: a2 = "VII"; break;
            case 8: a2 = "VIII"; break;
            case 9: a2 = "IX"; break;
        }
        return (a1 + a2);
    }

    private static int Math(String MathSing, int Num1, int Num2) {
        int result = 0;
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
        try {
            if (result < 1) {
                throw new Exception();
            }
        }
        catch(Exception e) {
            System.out.println("Значение меньше 1");
            System.exit(0);
        }
        return result;
    }
}
