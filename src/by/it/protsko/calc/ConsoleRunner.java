package by.it.protsko.calc;

import by.it.protsko.calc.Log.Logger;
import by.it.protsko.calc.lang_operations.LanguageChanger;
import by.it.protsko.calc.lang_operations.ResurceManager;

import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResurceManager resurceManager = ResurceManager.INSTANSE;
//        Logger logger;
        Var.loadCalcVariable();

        while (!(line = sc.nextLine()).equals("end")) {
            switch (line) {
                case "printvar":
                    Printer.printVar();
                    break;
                case "sortvar":
                    Printer.sortVar();
                    break;
                case "ru":
                case "be":
                case "en":
                    resurceManager.setLocal(LanguageChanger.newLanguage(line));
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        printer.print(result);
                        Var.saveCalcVariable();
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        Logger.logMessages(e.getMessage() + "\t(" +line +")");
                    }
            }
        }
    }
}
