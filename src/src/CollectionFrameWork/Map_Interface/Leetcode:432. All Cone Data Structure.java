/*Approach:
1. We will store a HashMap which will have the key-value pair of string and its count of occurence 
2. secondly, we will store a TreeMap(For Sorted Order) which will have an Integer and a     LinkedHashSet that will store all the String having same number of Occurence.
3. Now for Operations we will take a key find its occurence from the HashMap then remove it from the TreeMap do the Operations whether it will be increase/decrease then reinsert the newCount with the LinkedHashSet into the TreeMap and the Key with newCount after Operations.
4.For max/min key we will do :
    The expression countKeyMap.lastEntry().getValue().iterator().next()/countKey.firstEntry().getValue().iterator().next() retrieves the first/last key associated with the highest /lowest frequency in a TreeMap<Integer, LinkedHashSet<String>>. The lastEntry()/firstEntry() method gets the entry with the largest/smallest key (highest/lowest count), and getValue() returns the set of keys at that frequency. iterator().next() then returns the first key from this set. 
*/

class AllOne {
    Map<String,Integer>keyCount;
    TreeMap<Integer,LinkedHashSet<String>>countKey;
    public AllOne() {
        keyCount=new HashMap<>();//Store Key-Count
        countKey=new TreeMap<>();// Store Count-Key
    }
    
    public void inc(String key) {
        int count=keyCount.getOrDefault(key,0);

        //remove it from TreeMap/countKey
        if(count>0){
            removeFromCountKey(count,key);//Method to remove from the countKey map
        }
        //Update the Count
        int newCount=count+1;
        //Update the Count in the map 
        keyCount.put(key,newCount);
        //Update the Count in TreeMap
        countKey.putIfAbsent(newCount,new LinkedHashSet<>());
        countKey.get(newCount).add(key);
    }
    
    public void dec(String key) {
        int count=keyCount.getOrDefault(key,0);

       
        removeFromCountKey(count,key);

        if(count==1){
            keyCount.remove(key);
        }else{
            int newCount=count-1;

            keyCount.put(key,newCount);

            countKey.putIfAbsent(newCount,new LinkedHashSet<>());
            countKey.get(newCount).add(key);
        }
    }
    
    public String getMaxKey() {
        return countKey.isEmpty()?"":countKey.lastEntry().getValue().iterator().next();
        
    }
    
    public String getMinKey() {
        return countKey.isEmpty()?"":countKey.firstEntry().getValue().iterator().next();
    }

    public void removeFromCountKey(int count,String key){
        LinkedHashSet<String>keySet=countKey.get(count);

        keySet.remove(key);

        if(keySet.isEmpty()){
            countKey.remove(count);
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
