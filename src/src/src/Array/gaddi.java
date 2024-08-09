package Array;
import java.util.*;

public class gaddi {
    public static int leastInterval(char[] tasks, int n) {
        if(n==0){
            return tasks.length;
        }
        //making a counter array to take the occurences of the characters...
        int []count=new int[26];
        for(char ch:tasks){
            count[ch-'A']++;
        }
        Arrays.sort(count);//this will push the element with higher frequency to the end of the count array.
        //chunks that are the vaccant places that may or may not be filled
        //number of chunks is equal to freq of A minus 1.
        int chunks=count[25]-1;
        //idol spots are the places where character can be placed...
        int idolSpots=chunks*n;
        for(int i=24;i>=0;i--){
            idolSpots-=Math.min(chunks,count[i]);
            if(idolSpots<=0){
                break;
            }
        }
        if(idolSpots>0){
            return tasks.length+idolSpots;
        }else{
            return tasks.length;
        }

    }
    public static void main(String[]args){
        char[] ch={'A','C','A','B','D','B'};
        System.out.print(leastInterval(ch,1));
    }
}
