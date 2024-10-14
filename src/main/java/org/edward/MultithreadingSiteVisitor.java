package org.edward;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingSiteVisitor {
    private final SiteVisitCounter siteVisitCounter;
    private long startTime;

    private List<Thread> threads = new ArrayList<>();

    public MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    /*Запускает указанное количество потоков, каждый из которых вызывает incrementVisitCount*/
    public void visitMultithread(int numOfThread) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfThread; i++) {
            Thread thread = new Thread(siteVisitCounter::incrementVisitCount);
            thread.start();
            threads.add(thread);
        }
    }

    /*ожидает окончания всех потоков*/
    public void waitUntilAllVisited() throws InterruptedException {
        //ожидает окончания всех потоков
        for (Thread thread : threads) {
            thread.join();
        }
    }

    //должно возвращаться количество секунд
    public long getTotalTimeOfHandling() {
        //Возвращает общее время обработки всех потоков в секундах
        return (System.currentTimeMillis() - startTime) /*/ 1000*/;
    }
}
