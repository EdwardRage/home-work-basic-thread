package org.edward;

public class SynchronizedBlockCounter extends Thread implements SiteVisitCounter {

    private Integer count = 0;

    public SynchronizedBlockCounter(Integer count) {
        this.count = count;
    }

    @Override
    public synchronized void incrementVisitCount() {
        count++;
    }

    @Override
    public synchronized int getVisitCount() {
        return 0;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <1_000_000; i++) {
                incrementVisitCount();
            }
            System.out.println("Result count = " + getVisitCount());
            sleep(100L);
        } catch (InterruptedException e) {
            System.out.println(getName()  + " interrupted");
        }
    }
}
