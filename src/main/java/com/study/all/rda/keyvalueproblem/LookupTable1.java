package com.study.all.rda.keyvalueproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LookupTable1 {
    private Map<Integer, List<Integer>> table; // Key to list of values
    private Map<Integer, List<Integer>> valueToKeyMap; // Value to list of keys

    public LookupTable1() {
        table = new HashMap<>();
        valueToKeyMap = new HashMap<>();
    }

    // Method to insert a key-value pair
    public void insert(int key, int value) {
        List<Integer> values = table.getOrDefault(key, new ArrayList<>());
        values.add(value);
        table.put(key, values);

        List<Integer> keys = valueToKeyMap.getOrDefault(value, new ArrayList<>());
        keys.add(key);
        valueToKeyMap.put(value, keys);
    }

    // Method to search for values by key
    public List<Integer> searchByKey(int key) {
        return table.getOrDefault(key, new ArrayList<>());
    }

    // Method to search for keys by value
    public List<Integer> searchByValue(int value) {
        return valueToKeyMap.getOrDefault(value, new ArrayList<>());
    }

    // Method to delete a key-value pair
    public void delete(int key, int value) {
        List<Integer> values = table.get(key);
        if (values != null) {
            values.remove(Integer.valueOf(value));
            if (values.isEmpty()) {
                table.remove(key);
            }
        }

        List<Integer> keys = valueToKeyMap.get(value);
        if (keys != null) {
            keys.remove(Integer.valueOf(key));
            if (keys.isEmpty()) {
                valueToKeyMap.remove(value);
            }
        }
    }
}
