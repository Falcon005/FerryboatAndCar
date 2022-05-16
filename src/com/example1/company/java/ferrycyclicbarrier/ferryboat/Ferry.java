package com.example1.company.java.ferrycyclicbarrier.ferryboat;

import com.example1.company.java.ferrycyclicbarrier.car.Car;
import com.example1.company.java.ferrycyclicbarrier.island.Island;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Ferry implements Runnable{
    private static Logger logger = LogManager.getLogger(Ferry.class.getName());
    private static final CyclicBarrier barrier = new CyclicBarrier(5,new Island());

    public  void run() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Car(i,barrier)).start();
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}
