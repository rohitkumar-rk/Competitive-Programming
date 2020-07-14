class RandomizedSet {
    
    HashSet<Integer> set;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set  = new HashSet<Integer>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }
        return false; 
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        int pos = random.nextInt(list.size());
        return list.get(pos);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */