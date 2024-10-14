package org.edward;


public class Main {
    public static void main(String[] args) {
        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();

        MultithreadingSiteVisitor multithreadingSiteVisitor = new MultithreadingSiteVisitor(unsynchronizedCounter);

        multithreadingSiteVisitor.visitMultithread(100);

        long time = multithreadingSiteVisitor.getTotalTimeOfHandling();


    }
}