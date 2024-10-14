package org.edward;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter extends Thread implements SiteVisitCounter {
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void incrementVisitCount() {
        try {
            count.getAndIncrement();
            sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getVisitCount() {
        return count.get();
    }

    @Override
    public void run() {
        incrementVisitCount();
    }
}
