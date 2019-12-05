package by.it.protsko.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened!");
        List<Buyer> listBuyer = new ArrayList<>();

        for (int min = 1; min <= 2; min++) {
            for (int sec = 0; sec < 120; sec++) {

                if (sec == 0 || sec == 60) {
                    while (Dispather.countBuyerInMarket < 10) {
                        createBuyer(listBuyer);
                    }
//                    System.out.println(Dispather.countBuyerInMarket);
                }

                if (sec > 0 && sec <= 30) {
                    if (Dispather.countBuyerInMarket <= 10 + sec) {                 ////// НО!!!! Пока создается новый buyer, кто-то может выйти!!!!! Как быть?????
                        createBuyer(listBuyer);
                    }
//                    System.out.println(Dispather.countBuyerInMarket);
                }

                if (sec > 30 && sec < 60) {
                    if (Dispather.countBuyerInMarket <= 40 + (30 - sec)) {
                        createBuyer(listBuyer);
                    }
//                    System.out.println(Dispather.countBuyerInMarket);
                }
                Thread.sleep(1000 / Dispather.speedProcess);
            }
            Thread.sleep(1000 / Dispather.speedProcess);
        }

        for (Buyer buyer : listBuyer) {
            buyer.join();
        }

        System.out.println("\nMarket closed!");
        System.out.println("Count buyer in market=" + Dispather.countBuyerInMarket);
    }

    private static void createBuyer(List<Buyer> listBuyer) {
        int countBuyer = Helper.randomValue(0, 2);
        for (int j = 1; j <= countBuyer; j++) {
            Buyer buyer;
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
