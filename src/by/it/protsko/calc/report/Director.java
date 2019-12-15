package by.it.protsko.calc.report;

public class Director {
    ReportCreator reportCreator;

    void setReportCreator(ReportCreator rc) {
        reportCreator = rc;
    }

    Report createStartReport() {
        reportCreator.createReport();
        reportCreator.createFileName();
        reportCreator.createReportTitle();
        reportCreator.createTimeStartProgram();
        return reportCreator.getReport();
    }

    Report createOperationReport() {
//        reportCreator.createReport();
        reportCreator.createOperation();
        reportCreator.createOperationResult();
        return reportCreator.getReport();
    }

    Report createFinishReport() {
//        reportCreator.createReport();
        reportCreator.createTimeFinishProgram();
        return reportCreator.getReport();
    }
}
