package by.it.protsko.jd01_10;

class Bean {

    @Param(a = 5, b = 6)
    double sum(int a, int b) {
        return (a + b);
    }

    @Param(a = 1, b = 2)
    static double max(int a, int b) {
        return a < b ? b : a;
    }

    @Param(a = 2, b = 3)
    static double min(int a, int b) {
        return a > b ? b : a;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
