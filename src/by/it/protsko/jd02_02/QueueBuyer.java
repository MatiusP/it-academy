package by.it.protsko.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyer {
    private final static Deque<Buyer> queue = new LinkedList<>();

    static void addBuyer(Buyer buyer) {
        synchronized (queue) {
            queue.addLast(buyer);
        }
    }

    static Buyer pollBuyer() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }
}
