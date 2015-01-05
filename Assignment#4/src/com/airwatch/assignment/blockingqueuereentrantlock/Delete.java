package com.airwatch.assignment.blockingqueuereentrantlock;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

/**
 * Created by ABhat on 13 Aug 2014 - 13/08/14.
 */
public class Delete implements Runnable {

    BlockingQueue queue;
    int item;
    Lock lock;

    Delete(Lock l, BlockingQueue q) {
        queue = q;
        lock = l;
    }

    public int delete() {
        while (queue.size() == 0)
            try {
                System.out.println("Queue empty.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        int item = (Integer) null;
        try {
            lock.lock();
            item = (Integer) queue.remove();
            Thread.sleep(500);
            System.out.println("Removed : " + item);
            System.out.println("Contents of queue : " + Arrays.toString(queue.toArray()));
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();

        }
        return item;
    }

    @Override
    public void run() {
        item = delete();
    }
}
