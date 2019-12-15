package by.it.protsko.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened!");
        List<Buyer> listBuyer = new ArrayList<>();
        List<Thread> cashierList = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            cashierList.add(thread);
            thread.start();
        }

        while (Dispather.marketOpen()) {
            createBuyer(listBuyer);
            Thread.sleep(1000 / Dispather.speedProcess);
        }
        for (Buyer buyer : listBuyer) {
            buyer.join();
        }
        for (Thread thread : cashierList) {
            thread.join();
        }
        System.out.println("\nMarket closed!");
    }

    private static void createBuyer(List<Buyer> listBuyer) {
        int countBuyer = Helper.randomValue(0, 2);
        for (int j = 1; j <= countBuyer; j++) {
            Buyer buyer;
            if (Dispather.marketOpen()) {
                if (++Dispather.countBuyer % 4 != 0) {
                    buyer = new Buyer(Dispather.countBuyer);
                } else {
                    buyer = new Buyer(Dispather.countBuyer, true);
                }
                listBuyer.add(buyer);
                buyer.start();
            }
        }
    }
}
