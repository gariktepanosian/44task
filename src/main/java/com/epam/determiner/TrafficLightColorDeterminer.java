package com.epam.determiner;

import java.util.Scanner;
import java.util.logging.Logger;

public class TrafficLightColorDeterminer {
    private static final Logger logger = Logger.getLogger(TrafficLightColorDeterminer.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Please enter the time in minutes: ");

        while (scanner.hasNext()) {
            double timeInMinutes = scanner.nextDouble();

            double cycleTime = 5.0;
            double colorPercent = (timeInMinutes % cycleTime) / cycleTime;

            String color = determineTrafficLightColor(colorPercent);
            logger.info("The traffic light color is: " + color);
        }
    }

    private static String determineTrafficLightColor(double colorPercent) {
        if (colorPercent >= 0.0 && colorPercent < 0.6) {
            return "Green";
        } else if (colorPercent >= 0.6 && colorPercent < 0.8) {
            return "Yellow";
        } else {
            return "Red";
        }
    }
}
