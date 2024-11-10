```java
  public int[] setBitsCount(int[] nums) {
        int[] IthBitSet = new int[32];
        for (int num : nums) {
            int IthBitSet = 0;
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    IthBitSet[i]++;
                }
            }
        }
        return IthBitSet;
    }
```
