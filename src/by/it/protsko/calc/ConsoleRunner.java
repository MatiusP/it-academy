package by.it.protsko.calc;

import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args){
        Var.loadCalcVariable();
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
                try {
                    Var result = parser.calc(line);
                    printer.print(result);
                    Var.saveCalcVariable();
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
