package org.edward;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numOfThread = 100;
        int numOfThreadTen = 10;

        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();
        VolatileCounter volatileCounter = new VolatileCounter();
        SynchronizedBlockCounter synchronizedBlockCounter = new SynchronizedBlockCounter();
        AtomicIntegerCounter atomicIntegerCounter = new AtomicIntegerCounter();
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();

        runMultithreading(unsynchronizedCounter, "UnsynchronizedCounter", numOfThread);
        runMultithreading(volatileCounter, "VolatileCounter", numOfThread);
        runMultithreading(synchronizedBlockCounter, "SynchronizedBlockCounter", numOfThread);
        runMultithreading(atomicIntegerCounter, "AtomicIntegerCounter", numOfThread);
        runMultithreading(reentrantLockCounter, "ReentrantLockCounter", numOfThread);

        /*runMultithreading(unsynchronizedCounter, "UnsynchronizedCounter", numOfThreadTen);
        runMultithreading(volatileCounter, "VolatileCounter", numOfThreadTen);
        runMultithreading(synchronizedBlockCounter, "SynchronizedBlockCounter", numOfThreadTen);
        runMultithreading(atomicIntegerCounter, "AtomicIntegerCounter", numOfThreadTen);
        runMultithreading(reentrantLockCounter, "ReentrantLockCounter", numOfThreadTen);*/
    }

    private static void runMultithreading(SiteVisitCounter siteVisitCounter, String threadName, int numOfThread) throws InterruptedException {

        MultithreadingSiteVisitor multithreadingSiteVisitor = new MultithreadingSiteVisitor(siteVisitCounter);

        multithreadingSiteVisitor.visitMultithread(numOfThread);
        multithreadingSiteVisitor.waitUntilAllVisited();
        double time = multithreadingSiteVisitor.getTotalTimeOfHandling();

        System.out.println("Название потока: " + threadName);
        System.out.println("Время работы: " + time + " сек при количестве потоков: " + numOfThread);
        System.out.println("Корректность: " + (siteVisitCounter.getVisitCount() == numOfThread ? "правильно" : "неправильно"));
        System.out.println("Ожидалось: " + numOfThread + ", получили: " + siteVisitCounter.getVisitCount());
        System.out.println("---------------------");
    }
}