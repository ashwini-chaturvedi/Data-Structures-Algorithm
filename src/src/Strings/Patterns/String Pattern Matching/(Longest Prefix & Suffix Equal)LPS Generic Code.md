# Without Comments
```java
public int[] findLPS(String pattern){
        int[] LPS=new int[pattern.length()];
        
        LPS[0]=0;
        int maxLength=0;
        int i=1;
        
        while(i<pattern.length()){
           
            if(pattern.charAt(i)==pattern.charAt(maxLength) ){
                maxLength++;
                
                LPS[i]=maxLength;
                i++;
            }else{
                if(maxLength!=0){
                    maxLength=LPS[maxLength-1];
                }else{
                    LPS[i]=0;
                    i++;
                }
            }
        }
        return LPS;
    }
```
# With Comments
```java
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
```

