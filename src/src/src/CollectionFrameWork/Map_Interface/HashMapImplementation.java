package CollectionFrameWork.Map_Interface;

import java.util.LinkedList;

public class HashMapImplementation {
    static class myHashMap<K,V>{//these are called generics which helps when we want to write general code which can work with all datatypes.

        public static final int  DEFAULT_CAPACITY=4;//default capacity of our hashmap java's builtin hashmap has capacity 16
        public static final float DEFAULT_LOAD_FACTOR=0.75f;

        private int n; //the number of entries
        private class Node{
            K key;
            V value;
            Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }//node class

        private LinkedList<Node>[]buckets;

        private void initialiseBuckets(int N){//N= capacity or size of buckets array
            buckets=new LinkedList[DEFAULT_CAPACITY];
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();//this will create Array of LinkedList means at every Index of the array there is an empty LinkedList
            }

        }
        public myHashMap(){
            initialiseBuckets(DEFAULT_CAPACITY);
        }
        public int size(){
            //this return the number of entries
            return n;
        }
        private int hashFunction(K key){
            int hc=key.hashCode();//this will create a hash code of key of any type and return it
            return Math.abs(hc)%buckets.length;// hc can be out of bound for out array it can be negative,positive etc..
            //we take absolute value so that it is positive we take modulus to make it fall under size of our array...
        }
        private int searchInBucket(LinkedList<Node>list,K key){
            //traverse the linked list that is passed and looks for the node of the key if found it returns its index else return -1...
            for(int i=0;i<list.size();i++){
                if(list.get(i).key==key){
                    //does key of Node at i th index is equal to the passed key or not...
                    //.get is builtin function of LinkedList and .key is the part of Node that is our custom data type...
                    return i;
                }
            }
            return -1;
        }
        public void put(K key,V value){

            int bi=hashFunction(key);//bucket Index given by hashFunction
            LinkedList<Node>currBucket=buckets[bi];
            int idx=searchInBucket(currBucket,key);
            if(idx==-1){//key does not exist,so we have to insert new node
                Node newNode=new Node(key,value);
                currBucket.add(newNode);
                n++;

            }else{
                //now Node exist we have to update the value of the key
                Node currNode=currBucket.get(idx);
                currNode.value=value;
            }
            if(n>=buckets.length*DEFAULT_LOAD_FACTOR){
                reHash();
            }

        }
        private void reHash(){
            
        }
        public V get(K key){
            int bi=hashFunction(key);
            LinkedList<Node>currBucket=buckets[bi];
            int idx=searchInBucket(currBucket,key);
            if(idx!=-1){
                //key exist
                Node currNode=currBucket.get(idx);
                return currNode.value;
            }
            return null;//key does't exist...
        }
        public V remove(K key){
            int bi=hashFunction(key);
            LinkedList<Node>currBucket=buckets[bi];
            int idx=searchInBucket(currBucket,key);
            if(idx!=-1){
                //key exist
                Node currNode=currBucket.get(idx);
                V removedVal=currNode.value;
                currBucket.remove(idx);
                n--;//number of entries...
                return currNode.value;
            }
            return null;//key does't exist...
        }
        public int capacity(){
            return buckets.length;
        }
        public float load(){
            return (n*1.0f)/buckets.length;
        }


    }
    public static void main(String[]args){
        myHashMap<String,Integer>map=new myHashMap<>();
        System.out.println("testing put:");
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        System.out.println("size:"+map.size());
        System.out.println("Capacity:"+map.capacity());
        System.out.println("load"+map.load());
        map.put("c",30);
        System.out.println("size:"+map.size());
        //testing get
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println(map.get("cidi"));//not existing.


    }
}
