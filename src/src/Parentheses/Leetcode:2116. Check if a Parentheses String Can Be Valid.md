```java
class Solution {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        //Take two Stacks to Store the Indexes of locked and Unlocked indices 
        Stack<Integer> Locked = new Stack<>();
        Stack<Integer> Unlocked = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {//if the character at Index is Locked.
                if (s.charAt(i) == '(') {//if it is Open parenthesis push it into the stack.
                    Locked.push(i);
                } else if (s.charAt(i) == ')') {//the it is a Closing then you have to find a closing paranthesis for it to be balanced
                    if (!Locked.isEmpty()) {//if the opening paranthesis is inside the locked stack then pop it as we have got the pair
                        Locked.pop();
                    } else if (!Unlocked.isEmpty()) {//if Locked Stack is Empty then match it with one of the Unlocked characters because Unlocked character can become both Open and Close Parenthesis. 
                        Unlocked.pop();
                    }else return false;//if both stack is Empty then this Close Parenthesis cannot be balances hence Return false.
                }
            } else if (locked.charAt(i) == '0') {
                Unlocked.push(i);
            }
        }

        //At last start matching the paranthesis in the Locked with the Parenthesis in the Unlocked and Unlocked Indexes should come before the Locked Index. Because Locked Stack will only contain the Opening Brackets so to balance them the Unlocked Stack should have Unlocked Parenthesis After that.
        while (!Locked.isEmpty() && !Unlocked.isEmpty() && Locked.peek() < Unlocked.peek()) {
            Locked.pop();
            Unlocked.pop();
        }

        return Locked.isEmpty();//at last return if all the Open brackets have been matched or not.
    }
}

```
