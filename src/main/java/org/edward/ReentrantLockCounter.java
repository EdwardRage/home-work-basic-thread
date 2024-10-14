package org.edward;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter extends Thread implements SiteVisitCounter {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void incrementVisitCount() {
        lock.lock();
        try {
            count++;
            sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getVisitCount() {
        return count;
    }

    @Override
    public void run() {
        incrementVisitCount();
    }
}
