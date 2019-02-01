package leetcode.hash.hashSet;

import java.util.*;

/**
 * @author stevenw
 * @date 2019/2/1
 */
public class MyHashSet {
    Map<Integer,List <Integer>> hashTable;
    public MyHashSet() {
        hashTable = new HashMap();
    }

    private static int hashFunction(int key){
        return  key % 5;
    }
    public void add(int key) {
        if(this.contains(key)){
            return;
        }
        List<Integer> bucket = null;
        int hashKey = hashFunction(key);
        if(null != hashTable.get(hashKey)){
            bucket = hashTable.get(hashKey);
            bucket.add(key);
        }else {
            bucket = new ArrayList<>();
            bucket.add(key);
        }
        hashTable.put(hashKey,bucket);
    }

    public void remove(int key) {
        if(!this.contains(key)){
            int hashKey = hashFunction(key);
            List<Integer> bucket = hashTable.get(hashKey);
            for (int i = 0; i < bucket.size();i++) {
                if(bucket.get(i) == key){
                    bucket.remove(i);
                    break;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(final int key) {
        int hashKey = hashFunction(key);
        if(null != hashTable.get(hashKey)){
            for (int value:hashTable.get(hashKey)) {
                if (value == key){
                    return true;
                }
            }
        }
            return false;
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        obj.contains(1);
        obj.contains(3);
        obj.add(2);
        obj.contains(3);
        obj.remove(2);
        boolean param_3 = obj.contains(2);
        System.err.println(param_3);


    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
}
