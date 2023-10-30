package com.epam.process;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonthInfoProcessor {
  public static List<Integer> findDistinctMonthLengthsAndSubstringToFind(String substringToFind) {
    return Arrays.stream(Month.values())
        .filter(month -> month.name().contains(substringToFind.toUpperCase()))
        .map(month -> month.name().length())
        .distinct()
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(findDistinctMonthLengthsAndSubstringToFind("M"));
  }
}
