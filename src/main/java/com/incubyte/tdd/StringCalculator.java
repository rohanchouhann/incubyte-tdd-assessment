package com.incubyte.tdd;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Simple String Calculator kata implementation.
 *
 * Rules implemented:
 * - empty string -> 0
 * - single number -> value
 * - comma or newline as delimiters
 * - custom delimiter defined as: //[delimiter]\n[numbers...]
 * - negative numbers -> throw IllegalArgumentException listing all negatives
 *
 * Keep methods small and readable to make testing and refactoring easier.
 */
public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String numSection = numbers;
        String delimiterRegex = ",|\n";

        // Custom delimiter syntax: //[delimiter]\n[numbers...]
        if (numbers.startsWith("//")) {
            int newlineIdx = numbers.indexOf('\n');
            if (newlineIdx == -1) {
                throw new IllegalArgumentException("Invalid input: missing newline after custom delimiter");
            }
            String customDelim = numbers.substring(2, newlineIdx);
            String escaped = Pattern.quote(customDelim); // escape regex special chars
            delimiterRegex = escaped;
            numSection = numbers.substring(newlineIdx + 1);
        }

        String[] tokens = numSection.split(delimiterRegex);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String t : tokens) {
            if (t == null || t.trim().isEmpty()) {
                continue;
            }
            int n;
            try {
                n = Integer.parseInt(t.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number: " + t);
            }
            if (n < 0) {
                negatives.add(n);
            }
            sum += n;
        }

        if (!negatives.isEmpty()) {
            String list = negatives.stream().map(String::valueOf).collect(Collectors.joining(","));
            throw new IllegalArgumentException("negative numbers not allowed " + list);
        }

        return sum;
    }
}
