package org.edward;

public class UnsynchronizedCounter extends Thread implements SiteVisitCounter {

    private int count = 0;

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100L);
            count++;
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
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

