package org.edward;

public class VolatileCounter extends Thread implements SiteVisitCounter  {

    private volatile int count = 0;

    @Override
    public void incrementVisitCount() {
        count++;
    }

    @Override
    public int getVisitCount() {
        return count;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1_000_000; i++) {
                incrementVisitCount();
            }
            System.out.println("Result count = " + getVisitCount());
            sleep(100L);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }
}
