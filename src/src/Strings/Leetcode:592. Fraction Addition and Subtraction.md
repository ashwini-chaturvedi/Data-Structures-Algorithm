```java
//Make the Numerator and Denominator separetely and then find there GCD to make them in there irreducible form.
class Solution {
    public String fractionAddition(String exp) {
        int numerator=0;
        int denominator=1;
        int n=exp.length();
        int i=0;
        while(i<n){
            int currNum=0;
            int currDeno=0;
            boolean isNegative=(exp.charAt(i)=='-');

            if(exp.charAt(i)=='+' || exp.charAt(i)=='-') i++; //skipping
 
            //Making numerator
            while(i<n && Character.isDigit(exp.charAt(i))){
                int val=exp.charAt(i)-'0';
                currNum=(currNum*10)+val;
                i++;
            }
            i++; //skipping the '/' sign

            if(isNegative) currNum*=-1;

            //making denominator
            while(i<n && Character.isDigit(exp.charAt(i))){
                int val=exp.charAt(i)-'0';
                currDeno=(currDeno*10)+val;
                i++;
            }

            numerator=numerator*currDeno+denominator*currNum;
            denominator=denominator*currDeno;
           
        }
        int gcd=gcd(Math.abs(numerator),denominator);//So that we can divide the numberator and denominator and make them in simpler form or Irreducible Form...
        numerator=numerator/gcd;
        denominator=denominator/gcd;

        return numerator+"/"+denominator;
    }
    //Euclidean method to find gcd
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
```
