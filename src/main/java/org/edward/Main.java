package org.edward;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();


        runMultithreading(unsynchronizedCounter, "UnsynchronizedCounter");
    }

    private static void runMultithreading(SiteVisitCounter siteVisitCounter, String threadName) throws InterruptedException {
        int numIfThread = 100;

        MultithreadingSiteVisitor multithreadingSiteVisitor = new MultithreadingSiteVisitor(siteVisitCounter);

        multithreadingSiteVisitor.visitMultithread(numIfThread);
        multithreadingSiteVisitor.waitUntilAllVisited();
        long time = multithreadingSiteVisitor.getTotalTimeOfHandling();

        System.out.println("Название потока: " + threadName);
        System.out.println("Время работы: " + time + " c количеством потоков: " + numIfThread);
        System.out.println("Корректность: " + (siteVisitCounter.getVisitCount() == numIfThread ? "правильно" : "неправильно"));
    }
}