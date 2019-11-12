package by.it.protsko.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Scalar v1 = new Scalar(4.14);
        Var v2 = new Scalar(v1);
        Var v3 = new Scalar("3.1415");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        Vector v4 = new Vector(new double[]{1, 2, 4});
        Var v5 = new Vector(v4);
        Var v6 = new Vector("{1,2,4}");

        System.out.println(v4);
        System.out.println(v5);
        System.out.println(v6);
    }
}
