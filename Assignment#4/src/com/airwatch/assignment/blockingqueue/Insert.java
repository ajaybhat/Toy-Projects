package com.airwatch.assignment.blockingqueue;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ABhat on 13 Aug 2014 - 13/08/14.
 */
public class Insert implements Runnable {
    BlockingQueue queue;
    int item;

    Insert(BlockingQueue q, int i) {
        queue = q;
        item = i;
    }

    public synchronized void insert(int item) {
        System.out.println("Inserting : "+ item);
        while (queue.remainingCapacity() == 0)
            try {
                System.out.println("Queue full.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        try {
            if (item > 2000)
                throw new TooBigValueException();
            queue.add(item);
            System.out.println("Inserted : " + item);
            System.out.println("Contents of queue : " + Arrays.toString(queue.toArray()));
notifyAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void run() {
        insert(item);
    }
}
