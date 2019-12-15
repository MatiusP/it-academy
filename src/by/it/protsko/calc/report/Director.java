package by.it.protsko.calc.report;

public class Director {
    ReportCreator reportCreator;

    void setReportCreator(ReportCreator rc) {
        reportCreator = rc;
    }

    by.it.protsko.calc.report.Report createStartReport() {
        reportCreator.createReport();
        reportCreator.createFileName();
        reportCreator.createReportTitle();
        reportCreator.createTimeStartProgram();
        return reportCreator.getReport();
    }

    by.it.protsko.calc.report.Report createOperationReport() {
//        reportCreator.createReport();
        reportCreator.createOperation();
        reportCreator.createOperationResult();
        return reportCreator.getReport();
    }

    Report createFinishReport() {
        reportCreator.createReport();
        reportCreator.createFileName();
        reportCreator.createTimeFinishProgram();
        return reportCreator.getReport();
    }}

