package by.it.protsko.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                Printer.printVar();
            } else if (line.equals("sortvar")) {
                Printer.sortVar();
            } else {
                Var result = parser.calc(line);
                printer.print(result);
            }
        }
    }
}
