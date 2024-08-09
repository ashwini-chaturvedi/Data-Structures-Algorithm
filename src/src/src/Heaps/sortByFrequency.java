package Heaps;

import java.util.*;

class duo{
    char ch;
    int count;
    duo(char c,int cou){
        ch=c;
        count=cou;
    }
}



public class sortByFrequency {
    public static String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }
        PriorityQueue<duo> maxHeap=new PriorityQueue<>((a, b)->b.count-a.count);
        for(char key:map.keySet()){
            maxHeap.add(new duo(key,map.get(key)));
        }
        StringBuilder sb=new StringBuilder();
        while(!maxHeap.isEmpty()){
            int time=maxHeap.peek().count;
            for(int i=0;i<time;i++){
                sb.append(maxHeap.peek().ch);
            }
            maxHeap.remove();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="tree";
        String st=frequencySort(s);
        for(char ch:st.toCharArray()){
            System.out.print(ch+",");
        }

    }
}
