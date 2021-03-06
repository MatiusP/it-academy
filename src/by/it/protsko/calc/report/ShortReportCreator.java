package by.it.protsko.calc.report;

import by.it.protsko.calc.ConsoleRunner;
import by.it.protsko.calc.datetime.Date;
import by.it.protsko.calc.lang_operations.ReportMessages;
import by.it.protsko.calc.lang_operations.ResurceManager;

import java.io.File;

public class ShortReportCreator extends ReportCreator {

    @Override
    void createReportTitle() {
        report.setReportTitle(ResurceManager.INSTANSE.getMessage(ReportMessages.REP_TOPIC_SHORT));
    }

    @Override
    void createTimeStartProgram() {
        report.setTimeStartProgram(ResurceManager.INSTANSE.getMessage(ReportMessages.REP_TIME_START) + Date.getCurrentDate());
    }

    @Override
    void createOperation() {
        report.setOperation(ResurceManager.INSTANSE.getMessage(ReportMessages.REP_OPERATION) + ConsoleRunner.operation);
    }

    @Override
    void createOperationResult() {
        report.setOperationResult(ResurceManager.INSTANSE.getMessage(ReportMessages.REP_OPERATION_RES) + ConsoleRunner.operationResult);
    }

    @Override
    void createTimeFinishProgram() {
        report.setTimeFinishProgram(ResurceManager.INSTANSE.getMessage(ReportMessages.REP_TIME_FINISH) + Date.getCurrentDate());
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
