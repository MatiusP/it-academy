package by.it.protsko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List javaList = new ArrayList();
        javaList.add("hello");
        javaList.set(0, "hi");



        ListA<Integer> listA = new ListA<>();
        ListB<Double> listB = new ListB<>();

        listA.add(10);
        listA.add(20);
        listA.add(30);
        listA.add(40);
        listA.add(50);
        listA.add(60);
        listA.add(70);
        System.out.println(listA);
        listA.remove(0);
        System.out.println(listA);
        listA.remove((Object) 50);
        listA.set(2, 15);
        System.out.println(listA);

        listB.add(100.0);
        listB.add(200.0);
        listB.add(300.0);
        listB.add(400.0);
        listB.add(500.0);
        listB.add(600.0);
        listB.add(700.0);
        System.out.println(listB);
        listB.remove((Object) 50.0);
        listB.set(2, 150.0);
        System.out.println(listB);
        listB.addAll(listB);
        System.out.println(listB);
    }
}
