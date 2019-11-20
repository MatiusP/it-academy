package by.it.protsko.jd01_11;

public class Runner {

    public static void main(String[] args) {

        ListA<Integer> list = new ListA<>();
        list.add(3);
        list.add(5);
        list.add(6);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }
}
