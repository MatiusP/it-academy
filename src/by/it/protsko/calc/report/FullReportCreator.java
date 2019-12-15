package by.it.protsko.calc.report;

import by.it.protsko.calc.ConsoleRunner;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class FullReportCreator extends ReportCreator {

    @Override
    void createReportTitle() {
        report.setReportTitle("FULL REPORT");
    }

    @Override
    void createTimeStartProgram() {
        report.setTimeStartProgram("Старт программы: " + LocalDate.now() + " " + LocalTime.now());
    }

    @Override
    void createOperation() {
        report.setOperation("Совершенная операция: " + ConsoleRunner.operation);
    }

    @Override
    void createOperationResult() {
        report.setOperationResult("Результат операции: " + ConsoleRunner.operationResult);
    }

    @Override
    void createTimeFinishProgram() {
        report.setTimeFinishProgram("Завершение программы: " + LocalDate.now() + " " + LocalTime.now());
    }

    @Override
    void createFileName() {
        report.setFileName(getPath(FullReportCreator.class) + "fullReport.txt");
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
