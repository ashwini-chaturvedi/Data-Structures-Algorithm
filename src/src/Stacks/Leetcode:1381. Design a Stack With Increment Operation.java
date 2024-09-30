class CustomStack {
    private int[] st;
    private int i;
    private int size;

    public CustomStack(int maxSize) {
        st = new int[maxSize];
        i = -1;
        size = maxSize;
    }

    private boolean isFull() {
        return i == size - 1;
    }

    public void push(int x) {
        if (isFull()) {
            return;
        }
        i++;
        st[i] = x;
    }

    private boolean isEmpty() {
        return i == -1;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int poppedVal = st[i];
        i--;
        return poppedVal;
    }

    public void increment(int k, int val) {
        if (i < k) { //If there are less than k elements in the stack, increment all the elements in the stack by val.
            for (int j = 0; j <= i; j++) {
                st[j] += val;
            }
        } else { // Increments the bottom k elements of the stack by val.
            for (int j = 0; j < k; j++) {
                st[j] += val;
            }
        }
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
