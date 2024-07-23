//RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also reporting a random element.

// Implement the RandomizedCollection class:

// RandomizedCollection() Initializes the empty RandomizedCollection object.
// bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
// bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
// int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of the same values the multiset contains.
// You must implement the functions of the class such that each function works on average O(1) time complexity.

// Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.

import java.util.*;


class RandomizedCollection {
    private List<Integer> values;
    private Map<Integer, Set<Integer>> valueToIndices;
    private Random random;

    public RandomizedCollection() {
        values = new ArrayList<>();
        valueToIndices = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !valueToIndices.containsKey(val);
        if(notPresent) valueToIndices.put(val, new HashSet<>());
        valueToIndices.get(val).add(values.size());
        values.add(val);
        return notPresent;
    }
    
    public boolean remove(int val) {
        if(!valueToIndices.containsKey(val) || valueToIndices.get(val).isEmpty()){
            return false;
        }
        Set<Integer> indices = valueToIndices.get(val);
        int indexToRemove = indices.iterator().next();
        indices.remove(indexToRemove);
        
        // Swap the element to be removed with the last element
        if (indexToRemove < values.size() - 1) {
            int lastValue = values.get(values.size() - 1);
            values.set(indexToRemove, lastValue);
            valueToIndices.get(lastValue).remove(values.size() - 1);
            valueToIndices.get(lastValue).add(indexToRemove);
        }
        
        // Remove the last element
        values.remove(values.size() - 1);
        
        // Clean up if the value list is empty
        if (valueToIndices.get(val).isEmpty()) {
            valueToIndices.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */