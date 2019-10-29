package by.it.protsko.jd01_01;

import java.util.Scanner;

public class TaskC2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод (это вы вводите с клавиатуры):");

        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();

        int sum = firstNumber + secondNumber;
        System.out.println("DEC:" +firstNumber + "+" +secondNumber + "=" +sum);
        System.out.println("BIN:" +Integer.toBinaryString(firstNumber) + "+" +Integer.toBinaryString(secondNumber) + "=" +Integer.toBinaryString(sum));
        System.out.println("HEX:" +Integer.toHexString(firstNumber) + "+" +Integer.toHexString(secondNumber) + "=" +Integer.toHexString(sum));
        System.out.println("OCT:" +Integer.toOctalString(firstNumber) + "+" +Integer.toOctalString(secondNumber) + "=" +Integer.toOctalString(sum));

    }
}
