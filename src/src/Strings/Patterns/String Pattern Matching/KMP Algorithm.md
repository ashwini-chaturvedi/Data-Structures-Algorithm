```java
class Solution {
    public int[] findLPS(String pattern){
        int[] LPS=new int[pattern.length()];
        
        LPS[0]=0;//LPS at 0th Index is always 0
        int maxLength=0;//maximum length LPS we have seen in current times
        int i=1;//start from index 1 
        
        while(i<pattern.length()){
            //we match it with the element at index maxLength found so far because the element prior to that index would be matched and the have given the LPS that is stored at the Index.
            if(pattern.charAt(i)==pattern.charAt(maxLength) ){
                maxLength++;//Match found Increase the maximum length LPS seen so far
                
                LPS[i]=maxLength;//store it in LPS this will show that upto the point 'i' from 0,
                //the maximum LPS we can see is stored here 
                i++;
            }else{//if characters don't match start looking at the lesses indexes.
                if(maxLength!=0){//when still seen maxLength LPS is not zero
                    maxLength=LPS[maxLength-1];
                }else{//if LPS is zero then there is no option just to put 0 and move the ith pointer
                    LPS[i]=0;
                    i++;
                }
            }
        }
        return LPS;
    }

    ArrayList<Integer> search(String pattern, String s) {
        
        //Create an array to store LPS:the length of the longest prefix which is also a Suffix
        //LPS[i]=length if the longest prefix of pattern from(0 to i) which is also a suffix of pattern from (0 to i).
        
        int[] LPS=findLPS(pattern);//Find LPS
        
        //Now Apply KMP CODE
        int i=0;
        int j=0;
        
        ArrayList<Integer>list=new ArrayList<>();
        
        while(i<s.length()){
            if(s.charAt(i)==pattern.charAt(j)){//characters matched move forward
                i++;
                j++;
            }
            
            if(j==pattern.length()){//if the pattern String is End now we have found an Occurence of the Pattern String so now we have to store the Starting Index of this Pattern in String s and Move On.
                list.add(i-pattern.length());
                j=LPS[j-1];//Don't push start to the End just to re calculate once Again just push it to that Index which has the LPS at j-1.
            }else if(i<s.length() && s.charAt(i)!=pattern.charAt(j)){
                if(j!=0){
                    j=LPS[j-1];
                }else{
                    i++;
                }
            }
        }
        
        return list;
    }
}
```
