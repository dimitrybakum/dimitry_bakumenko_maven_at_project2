package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            LOGGER.info("i = " + i);
            System.out.println("i = " + i);
        }
    }
}