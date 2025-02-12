import java.util.*;
public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> map; 

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val,nums.size());
        nums.add(val);

        return true;
        

    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);

        int lastele = nums.get(nums.size() - 1);
        nums.set(index, lastele);
        map.put(lastele, index);

        nums.remove(nums.size()-1);
        map.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        Random random = new Random();
        return nums.get(random.nextInt(nums.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */