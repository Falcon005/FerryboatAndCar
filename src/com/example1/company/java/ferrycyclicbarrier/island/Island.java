package com.example1.company.java.ferrycyclicbarrier.island;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Island implements Runnable{
    private static Logger logger = LogManager.getLogger(Island.class.getName());
    @Override
    public void run() {
        System.out.println("The Ferry is ferrying the cars to the other island");
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            logger.error(e);
        }
        System.out.println("The ferry is arrived in island with vehicles!");
    }

}
