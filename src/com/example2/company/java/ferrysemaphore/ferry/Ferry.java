package com.example2.company.java.ferrysemaphore.ferry;

import com.example2.company.java.ferrysemaphore.car.Car;
import com.example2.company.java.ferrysemaphore.island.Island;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Ferry implements Runnable{
    private static Logger logger = LogManager.getLogger();
    private static int capacity=4;
    private static boolean isAtIsland=false;
    private Island island = new Island();
    private static Semaphore semaphore = new Semaphore(capacity,true);


    public Ferry(){

    }
    public Ferry(int c){
        capacity=c;
    }

    public static boolean isIsAtIsland() {
        return isAtIsland;
    }




    public void run(){
        System.out.println("To the "+getLocationText()+", the ferry is picking up cars");
        for (int i = 0; i < 5; i++) {
            new Thread(new Car(i,semaphore)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            logger.error(e);
        }

        isAtIsland=true;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            logger.error(e);
        }
        System.out.println("Ferry is arrived the island");
        island.drop();
    }

    public String getLocationText(){
        return "Island";
    }

    @Override
    public String toString() {
        return "Ferry{" +
                "island=" + island +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferry ferry = (Ferry) o;
        return Objects.equals(island, ferry.island);
    }

    @Override
    public int hashCode() {
        return Objects.hash(island);
    }
}
