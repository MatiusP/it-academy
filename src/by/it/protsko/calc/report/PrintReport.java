package by.it.protsko.calc.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintReport {

    static void saveReport(String fileName, String... reportItems) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            for (String item : reportItems) {
                if(item == null) continue;
                writer.append(item).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printStartReport() {
        by.it.protsko.calc.report.Director director = new by.it.protsko.calc.report.Director();
        director.setReportCreator(new ShortReportCreator());
        director.createStartReport().saveStartReport();
    }

    public static void printOperationReport(String operation) {
        by.it.protsko.calc.report.Director director = new by.it.protsko.calc.report.Director();
        director.setReportCreator(new ShortReportCreator());
        Report report = director.createStartReport();
        report.setOperation(operation);
        report.saveOperationReport();
    }

    public static void printFinishReport() {
        by.it.protsko.calc.report.Director director = new Director();
        director.setReportCreator(new ShortReportCreator());
        director.createFinishReport().saveFinishReport();
    }
}
