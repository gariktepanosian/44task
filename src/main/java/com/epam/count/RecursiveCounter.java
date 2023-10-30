package com.epam.count;

import java.util.logging.Logger;

public class RecursiveCounter {
    private static final Logger logger = Logger.getLogger(RecursiveCounter.class.getName());

    public static void count(int number) {
        if (number <= 0) {
            return;
        }
        logger.info("Starts With " + number);
        count(number - 1);
        System.out.println(number);
    }

    public static void main(String[] args) {
        int number = 5;

        logger.info("Counting from 1 to " + number + "...");
        count(number);
    }
}



