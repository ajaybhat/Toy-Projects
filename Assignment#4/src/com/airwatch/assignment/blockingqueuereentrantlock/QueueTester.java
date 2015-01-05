package com.airwatch.assignment.blockingqueuereentrantlock;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ABhat on 13 Aug 2014 - 13/08/14.
 */
public class QueueTester {
    public void doOperations() {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(3);
        Random rnd = new Random(System.currentTimeMillis());
        Lock lock = new ReentrantLock();

        Thread queueThreads[] = new Thread[20];
        for (int i = 0; i < 20; i++) {
            Insert insertQueue;
            Delete deleteQueue;
            int item = rnd.nextInt(3000);
            if (rnd.nextBoolean()) {
                insertQueue = new Insert(lock, queue, item);
                queueThreads[i] = new Thread(insertQueue);
            } else {
                deleteQueue = new Delete(lock, queue);
                queueThreads[i] = new Thread(deleteQueue);
            }
            queueThreads[i].start();
        }

        for (int i = 0; i < 20; i++)
            try {
                queueThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {

        QueueTester test = new QueueTester();
        test.doOperations();
    }
}

class TooBigValueException extends Exception {
    @Override
    public String getMessage() {
        return "Values greater than 2000 can't be inserted";
    }
}