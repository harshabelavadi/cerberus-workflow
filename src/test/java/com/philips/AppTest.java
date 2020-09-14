package com.philips;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
@SuppressWarnings("PMD")
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private Map<String, Integer> scores = new HashMap<>();
    private Map<Integer, Set<String>> expected = new HashMap<>();

    @Test
    public void groupByScoresEmptyMap() {
        assertEquals(expected, Sample.groupByScores(scores));
    }

    @Test
    public void groupByScoresWithOneScore() {
        scores.put("Jill", 15);

        expected.put(15, new HashSet<>(Arrays.asList("Jill")));

        assertEquals(expected, Sample.groupByScores(scores));
    }

    @Test
    public void groupByScoresWithTwoScores() {
        scores.put("Jill", 15);
        scores.put("Jack", 12);

        expected.put(15, new HashSet<>(Arrays.asList("Jill")));
        expected.put(12, new HashSet<>(Arrays.asList("Jack")));

        assertEquals(expected, Sample.groupByScores(scores));
    }

    @Test
    public void groupByScoresWithThreeScoresWithOneTied() {
        scores.put("Pam", 12);
        scores.put("Jill", 15);
        scores.put("Jack", 12);

        expected.put(15, new HashSet<>(Arrays.asList("Jill")));
        expected.put(12, new HashSet<>(Arrays.asList("Jack", "Pam")));

        assertEquals(expected, Sample.groupByScores(scores));
    }

    @Test
    public void groupByScoresWithMultipleScores() {
        scores.put("Pam", 12);
        scores.put("Jill", 15);
        scores.put("Jack", 12);
        scores.put("Tom", 11);
        scores.put("Darla", 15);
        scores.put("Raj", 15);
        scores.put("Nguyen", 11);

        expected.put(11, new HashSet<>(Arrays.asList("Tom", "Nguyen")));
        expected.put(12, new HashSet<>(Arrays.asList("Pam", "Jack")));
        expected.put(15, new HashSet<>(Arrays.asList("Jill", "Darla", "Raj")));

        assertEquals(expected, Sample.groupByScores(scores));
    }

}
