package by.it.protsko.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened!");
        List<Buyer> listBuyer = new ArrayList<>();

        for (int time = 0; time <=0; time++) {

            if (time == 0 || time == 60) {                    // начало каждой минуты работы магазина
                while (Dispather.countBuyerInMarket <= 10) {
                    int countBuyer = Helper.randomValue(10, 10);
                    for (int j = 0; j <= countBuyer; j++) {
                        Buyer buyer;
                        if (++Dispather.countBuyer % 4 != 0) {
                            buyer = new Buyer(Dispather.countBuyer);
                        } else {
                            buyer = new Buyer(Dispather.countBuyer, true);
                        }
                        listBuyer.add(buyer);
                        buyer.start();
                    }
                    Thread.sleep(1000 / Dispather.speedProcess);
                }
            }

            if (time > 0 && time <= 30 && time <= 90)){      // до 30 сек каждой минуты


            }





//            if (time <= 30 || (time >= 60 && time <= 90)) {                     ///////////////new
//                while (Dispather.countBuyerInMarket <) {
//
//                }
//
//
//                int countBuyer = Helper.randomValue(0, 2);
//
//
//                for (int j = 1; j <= countBuyer; j++) {
//                    Buyer buyer;
//                    if (++Dispather.countBuyer % 4 != 0) {
//                        buyer = new Buyer(Dispather.countBuyer);
//                    } else {
//                        buyer = new Buyer(Dispather.countBuyer, true);
//                    }
//                    listBuyer.add(buyer);
//                    buyer.start();
//                }

                //Thread.sleep(1000 / Dispather.speedProcess);
            }

//            for (Buyer buyer : listBuyer) {
//                    buyer.join();
//            }
            System.out.println("Market closed!");
        }
    }
