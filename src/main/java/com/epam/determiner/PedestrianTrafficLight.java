package com.epam.determiner;

import java.util.Scanner;
import java.util.logging.Logger;

public class PedestrianTrafficLight {

  private static final Logger logger = Logger.getLogger(PedestrianTrafficLight.class.getName());
  private static final int GREEN_LIGHT_DURATION = 3;
  private static final int YELLOW_LIGHT_DURATION = 1;
  private static final int RED_LIGHT_DURATION = 1;

  public static void main(String[] args) {
    runTrafficLightDeterminer();
  }

  private static void runTrafficLightDeterminer() {
    try (Scanner scanner = new Scanner(System.in)) {

      while (scanner.hasNext()) {
        logger.info("Enter the time in minutes elapsed since the beginning of the next hour: ");
        double timeInMinutes = scanner.nextDouble();

        String trafficLightColor = determineTrafficLightColor(timeInMinutes);
        logger.info("The traffic light color for pedestrians is: " + trafficLightColor);
      }
    } catch (Exception e) {
      logger.info("An error occurred: " + e.getMessage());
    }
  }

  private static String determineTrafficLightColor(double timeInMinutes) {
    double cycleTime = GREEN_LIGHT_DURATION + YELLOW_LIGHT_DURATION + RED_LIGHT_DURATION;

    double colorPercent = (timeInMinutes % cycleTime) / cycleTime;

    if (colorPercent < GREEN_LIGHT_DURATION / cycleTime) {
      logger.info("Choose the green");
      return "Green";
    } else if (colorPercent < (GREEN_LIGHT_DURATION + YELLOW_LIGHT_DURATION) / cycleTime) {
      logger.info("Choose the Yellow");
      return "Yellow";
    } else {
      logger.info("Choose the Red");
      return "Red";
    }
  }
}
