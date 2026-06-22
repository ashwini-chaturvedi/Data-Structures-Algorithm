```java
class Solution {

    public double calc(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double ans= calc(x, n/2);//calculate power for n/2 i.e. (half)

        if(n%2==0){//if the number was even then multiplying the same number will give answer for both the parts
            return ans*ans;
        }else{//else multiply once by x means 7/2=3 so cube*cube*number
            return x*ans*ans;
        }
    }

    public double myPow(double x, int n) {
        if (n < 0) {//if negative power
            x = (1 / x);//make the number 1/number
            n*=(-1);//make the power positive
        }

        return calc(x, n);
    }
}

```
