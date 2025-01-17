```java
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        /*Understand that from the original element, we are using each element twice to construct the derived array*/
        for (int num : derived) {
            xor ^= num;
        }

//The xor-sum of the derived array should be 0 since there is always a duplicate occurrence of each element.

        return xor == 1 ? false : true;
    }
}

```
