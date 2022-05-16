package com.example2.company.java.ferrysemaphore;

import com.example2.company.java.ferrysemaphore.ferry.Ferry;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Ferry());
        thread.start();
    }
}
