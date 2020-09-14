package com.philips;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface Sample {
  public static Map<Integer, Set<String>> groupByScores(Map<String, Integer> scores) {
    Map<Integer, Set<String>> byScores = new HashMap<>();
    for(String name : scores.keySet()) {
      int score = scores.get(name);

      Set<String> names = new HashSet<>();
      if(byScores.containsKey(score))
        names = byScores.get(score);

      names.add(name);
      byScores.put(score, names);
    }
    return byScores;
  }
}
