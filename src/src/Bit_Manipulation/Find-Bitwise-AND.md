```java
public static int findBitWiseAND(int ...arr){
        int ans=arr[0];
        for(int i=1;i<arr.length;i++){
            ans&=arr[i];
        }
        return ans;
}
```
