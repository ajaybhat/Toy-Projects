package com.airwatch.assignment.blockingqueue;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ABhat on 13 Aug 2014 - 13/08/14.
 */
public class Delete implements Runnable {

    BlockingQueue queue;
    int item;

    Delete(BlockingQueue q) {
        queue = q;
    }

    public synchronized int delete() {
        while (queue.size() == 0)
            try {
                System.out.println("Queue empty.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        int item = (Integer) queue.remove();
        System.out.println("Removed : " + item);
        System.out.println("Contents of queue : " + Arrays.toString(queue.toArray()));
        notifyAll();
        return item;
    }

    @Override
    public void run() {
        item = delete();
    }
}
