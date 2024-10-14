package org.edward;

public class MultithreadingSiteVisitor {
    private final SiteVisitCounter siteVisitCounter;
    private long startTime;

    public MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    /*Запускает указанное количество потоков, каждый из которых вызывает incrementVisitCount*/
    public void visitMultithread(int numOfThread) {
        for (int i = 0; i < numOfThread; i++) {
            Thread thread = new Thread(siteVisitCounter::incrementVisitCount);
            thread.start();
        }
    }

    /*ожидает окончания всех потоков*/
    public void waitUntilAllVisited() {
        //ожидает окончания всех потоков
    }

    //должно возвращаться количество секунд
    public long getTotalTimeOfHandling() {
        //Возвращает общее время обработки всех потоков в секундах
        return System.currentTimeMillis() - startTime;
    }
}
