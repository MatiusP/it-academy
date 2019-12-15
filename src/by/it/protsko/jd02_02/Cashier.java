package by.it.protsko.jd02_02;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened cashbox");
        while (!Dispather.marketClosed()) {
            Buyer buyer = QueueBuyer.pollBuyer();
            if (buyer != null) {
                System.out.println(this + " start service for " + buyer.getName());
                try {
                    Thread.sleep(Helper.randomValue(2000,5000)/ Dispather.speedProcess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (buyer) {
                    buyer.notify();
                }
                System.out.println(this + " stop service for " + buyer.getName());
            } else {

            }
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
