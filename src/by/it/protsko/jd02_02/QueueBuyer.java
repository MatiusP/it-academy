package by.it.protsko.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyer {
    private static final Deque<Buyer> queue = new LinkedList<>();

    synchronized static void addToQueue(Buyer buyer) {
        synchronized (queue) {
            queue.addLast(buyer);
        }
    }

    static Buyer pullFromQueue() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }
}
