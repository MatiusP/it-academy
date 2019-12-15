package by.it.protsko.jd02_02;

public class Cashier implements Runnable {
    private String name;
    private Thread thread;

    Cashier(int number) {
        thread = new Thread(this, ("Cashier №" + number));
    }


    @Override
    public void run() {
        System.out.println(this + " open cashbox");
        while (!Dispather.marketClosed()) {
            Buyer buyer = QueueBuyer.pullFromQueue();
            if (buyer != null) {
                System.out.println(this + " start service for buyer " + buyer);
                try {
                    Thread.sleep(Helper.randomValue(2000, 5000) / Dispather.speedProcess);
                    synchronized (buyer){
                        buyer.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println(this + " close cashbox");
    }

    @Override
    public String toString() {
        return name;
    }
}
