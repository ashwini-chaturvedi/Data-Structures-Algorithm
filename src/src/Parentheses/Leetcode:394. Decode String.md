```java
class Solution {
    public String decodeString(String s) {
        Stack<Integer>counts=new Stack<>();//Store the Integer or Number which will be used to multiply
        Stack<StringBuilder>st=new Stack<>();
        StringBuilder currRes=new StringBuilder();

        int i=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int count=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    count=count*10+(s.charAt(i)-'0');//if the number is of 2 or 3 digit number
                    i++;
                }
                counts.push(count);
            }else if(s.charAt(i)=='['){
                st.push(currRes);
                currRes=new StringBuilder();
                i++;
            }else if(s.charAt(i)==']'){
                StringBuilder temp=currRes;//Store the currRes's backup

                currRes=st.pop();//Get the String
                int counter=counts.pop();//Get the count which is use to multiply with the String
                for(int j=0;j<counter;j++){//
                    currRes.append(temp);//add the temp count number of times
                }
                i++;
            }else{
                currRes.append(s.charAt(i));
                i++;
            }
        }
        return currRes.toString();
    }
}
```
