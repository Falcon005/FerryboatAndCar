package com.example1.company.java.ferrycyclicbarrier;

import com.example1.company.java.ferrycyclicbarrier.ferryboat.Ferry;

public class Main {
    public static void main(String[] args) {
        new Thread(new Ferry()).start();
    }
}
