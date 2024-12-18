```java
class Solution {

    public int[] nextSmallerElement(int[] prices) {//Get the Next Smaller Element for the current Index
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();//Monotonically Increasing Stack

//Start from back to get the Next Smaller Element
        ans[prices.length - 1] = 0;
        stack.push(prices[prices.length - 1]);

        for (int i = prices.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

    public int[] finalPrices(int[] prices) {
        int[] nextSmallElement = nextSmallerElement(prices);

        for (int i = 0; i < prices.length; i++) {
            prices[i] -= nextSmallElement[i];
        }

        return prices;
    }
}

```

```java
class Solution {

    public int nextSmallElement(int[] prices, int i) {//Discounted Price
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[i] >= prices[j]) {
                return prices[j];
            }
        }
        return 0;
    }

    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] -= nextSmallElement(prices, i);
        }

        return prices;
    }
}

```
