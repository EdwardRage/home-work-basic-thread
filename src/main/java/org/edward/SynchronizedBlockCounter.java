package org.edward;

public class SynchronizedBlockCounter extends Thread implements SiteVisitCounter {

    private Integer count = 0;

    @Override
    public synchronized void incrementVisitCount() {
        try {
            count++;
            sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized int getVisitCount() {
        return count;
    }

    @Override
    public void run() {
        incrementVisitCount();
    }
}
