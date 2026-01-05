```java
class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n>=1 && (n&(n-1))==0){//koi bhi number jo 2 ka power hota h uska left most bit hmesha 1 hota h aur saare bits 0 hote h and number se ek kam number i.e 8 ka 8-1=7 ka sara bit 1 rehta h except left most bit and jb in dono ka BITWISE-AND loge toh answer hmesha 0 aaega for power of 2 number 
            return true;
        }else return false;
        
    }
}
```
