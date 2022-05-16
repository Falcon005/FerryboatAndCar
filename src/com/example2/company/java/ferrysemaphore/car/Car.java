package com.example2.company.java.ferrysemaphore.car;

import com.example2.company.java.ferrysemaphore.ferry.Ferry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable{
    private static Logger logger = LogManager.getLogger();
    private int carNumber;//id for the car
    private static Semaphore semaphore;
    public Car(int c,Semaphore s){
        carNumber = c;
        semaphore = s;
    }

    public int getCarNumber(){
        return carNumber;
    }




    public void run(){
        System.out.println("Car№"+carNumber+" is waiting for  a permit");
//        System.out.println("Car№"+carNumber+" "+Thread.currentThread().getState());
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            logger.error(e);
        }
//        System.out.println("Car№"+carNumber+" "+Thread.currentThread().getState());
        System.out.println("Car№"+carNumber+" gets permitted");
        System.out.println("Car№"+carNumber+" is on the ferry");

        while(!Ferry.isIsAtIsland()){
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                logger.error(e);
            }

        }

        semaphore.release();
        System.out.println("Car№"+carNumber+" is arrived the island");

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carNumber == car.carNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber=" + carNumber +
                '}';
    }
}
