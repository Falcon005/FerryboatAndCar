package com.example1.company.java.ferrycyclicbarrier.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{
    private static Logger logger = LogManager.getLogger(Car.class.getName());
    private int carID;
    private static  CyclicBarrier barrier;

    public Car(int c, CyclicBarrier b){
        carID = c;
        barrier = b;
    }

    public void run(){
        System.out.println("The carN"+carID+" is in a ferry");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            logger.error(e);
        } catch (BrokenBarrierException e) {
            logger.error(e);
        }

        System.out.println("The carN"+carID+" is arrived the island and left the ferry!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carID == car.carID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                '}';
    }
}
