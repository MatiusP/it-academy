package by.it.protsko.calc;

import by.it.protsko.calc.lang_operations.LanguageChanger;
import by.it.protsko.calc.lang_operations.ResurceManager;
import by.it.protsko.calc.log.Logger;
import by.it.protsko.calc.report.PrintReport;

import java.util.Scanner;

public class ConsoleRunner {///////////////////

    public static String operation;///////////////
    public static String operationResult;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResurceManager resurceManager = ResurceManager.INSTANSE;
        Var.loadCalcVariable();
        PrintReport.printStartReport();

        while (!(line = sc.nextLine()).equals("end")) {
            operation = line;                       ///////////////
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
                case "end":
                    PrintReport.printFinishReport();
                    break;
                default:
                    try {

                        Var result = parser.calc(line);
                        operationResult = result.toString();
                        printer.print(result);
                        Var.saveCalcVariable();
                        PrintReport.printOperationReport();
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        operationResult = e.getMessage();
                        PrintReport.printOperationReport();
                        Logger.logMessages(e.getMessage() + "\t(" + line + ")");
                    }
            }
        }
    }
}
