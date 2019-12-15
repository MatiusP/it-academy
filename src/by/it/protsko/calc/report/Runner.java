package by.it.protsko.calc.report;

public class Runner {

    static int operation = 0;
    static int result = 0;


    public static void main(String[] args) {


        Director director = new Director();
        director.setReportCreator(new ShortReportCreator());
        Report report = director.createStartReport();
        report.saveStartReport();



        for (int i = 0; i <= 3; i++){
            operation = i;
            result = i+5;
            report = director.createOperationReport();
            report.saveOperationReport();
        }






        report = director.createFinishReport();
        report.saveFinishReport();

    }
}
