package org.edward;

public class VolatileCounter extends Thread implements SiteVisitCounter  {

    private volatile int count = 0;

    @Override
    public void incrementVisitCount() {
        try {
            count++;
            sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
