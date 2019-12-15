package by.it.protsko.calc.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintReport {

    static void saveReport(String fileName, String... reportItems) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            for (String item : reportItems) {
                writer.append(item).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printStartReport() {
        Director director = new Director();
//        director.setReportCreator(new ShortReportCreator());
        director.setReportCreator(new ShortReportCreator());
        director.createStartReport().saveStartReport();
    }

    public static void printOperationReport() {
        Director director = new Director();
        director.setReportCreator(new ShortReportCreator());
        director.setReportCreator(new ShortReportCreator());
        director.createStartReport().saveOperationReport();
    }

    public static void printFinishReport() {
        Director director = new Director();

        director.setReportCreator(new ShortReportCreator());
        director.setReportCreator(new ShortReportCreator());
        director.createStartReport().saveFinishReport();
    }
}
