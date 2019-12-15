package by.it.protsko.calc.report;

import by.it.protsko.calc.ConsoleRunner;
import by.it.protsko.calc.datetime.Date;

import java.io.File;

public class ShortReportCreator extends ReportCreator {

    @Override
    void createReportTitle() {
        report.setReportTitle("SHORT REPORT");
    }

    @Override
    void createTimeStartProgram() {
        report.setTimeStartProgram("Старт программы: " +Date.getCurrentDate());
    }

    @Override
    void createOperation() {
        report.setOperation("Совершенная операция: " + ConsoleRunner.operation);
    }

    @Override
    void createOperationResult() {
        report.setOperationResult("\t\t" + "Результат операции: " +ConsoleRunner.operationResult);
    }

    @Override
    void createTimeFinishProgram() {
        report.setTimeFinishProgram("Завершение программы: "+Date.getCurrentDate());
    }

    @Override
    void createFileName() {
        report.setFileName(getPath(ShortReportCreator.class) + "shortReport.txt");
    }

    private static String getPath(Class<?> cClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + cClass
                .getName()
                .replace(cClass.getSimpleName(), "")
                .replace(".", File.separator);
    }
}
