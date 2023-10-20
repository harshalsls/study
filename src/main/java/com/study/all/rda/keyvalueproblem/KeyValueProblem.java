package com.study.all.rda.keyvalueproblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyValueProblem {
    public static void main(String[] args) {
        LookupTable table = new LookupTable();

        // Insert key-value pairs
        table.insert(1, 10);
        table.insert(1, 20);
        table.insert(2, 30);
        table.insert(2, 20);

        // Search for values by key
        Set<Integer> valuesForKey1 = table.searchByKey(1);
        System.out.println("Values for Key 1: " + valuesForKey1);

        // Search for keys by value
        Set<Integer> keysForValue20 = table.searchByValue(20);
        System.out.println("Keys for Value 20: " + keysForValue20);

        // Delete a key-value pair
        table.delete(1, 10);

        // Search for keys by value after deletion
        keysForValue20 = table.searchByValue(20);
        System.out.println("Keys for Value 20 after Deletion: " + keysForValue20);
    }

}

class LookupTable {
    private Map<Integer, Set<Integer>> table; // Key to list of values
    private Map<Integer, Set<Integer>> valueToKeyMap; // Value to list of keys

    public LookupTable() {
        table = new HashMap<>();
        valueToKeyMap = new HashMap<>();
    }

    // Method to insert a key-value pair
    public void insert(int key, int value) {
        Set<Integer> values = table.getOrDefault(key, new HashSet<>());
        values.add(value);
        table.put(key, values);

        Set<Integer> keys = valueToKeyMap.getOrDefault(value, new HashSet<>());
        keys.add(key);
        valueToKeyMap.put(value, keys);
    }

    // Method to search for values by key
    public Set<Integer> searchByKey(int key) {
        return table.getOrDefault(key, new HashSet<>());
    }

    // Method to search for keys by value
    public Set<Integer> searchByValue(int value) {
        return valueToKeyMap.getOrDefault(value, new HashSet<>());
    }

    // Method to delete a key-value pair
    public void delete(int key, int value) {
        Set<Integer> values = table.get(key);
        if (values != null) {
            values.remove(value);
            if (values.isEmpty()) {
                table.remove(key);
            }
        }

        Set<Integer> keys = valueToKeyMap.get(value);
        if (keys != null) {
            keys.remove(key);
            if (keys.isEmpty()) {
                valueToKeyMap.remove(value);
            }
        }
    }
}
