Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

Note that a number can contain multiple digits.

 

Example 1:

Input: num = "123", target = 6

Output: ["1*2*3","1+2+3"]

Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

Example 2:

Input: num = "232", target = 8

Output: ["2*3+2","2+3*2"]

Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.

```java
class Solution {

    public void solve(String s, int target, StringBuilder sb, List<String> list, long res, long prevNum, int idx) {
        if (idx == s.length()) {
            if (res == target) {
                list.add(sb.toString());
            }
            return;
        }

        //Run loop to extract digit or multiple digits from the String to make the res equal to target

        for (int i = idx; i < s.length(); i++) {
            if (i > idx && s.charAt(idx) == '0') break;

            //Saving the Previous Values for backtracking
            long currNum=Long.parseLong(s.substring(idx,i+1));
            long prevRes=res;
            long prev=prevNum;
            int len=sb.length();//saving the length so that at the time of backtracking we come back to initial length and don't have to backtrack and remove each digit as we know the number can be of any number of digits.

            if(idx==0){//if it is first number then avoid appending any operator


                sb.append(currNum);
                res+=currNum;
                prevNum=currNum;

                solve(s,target,sb,list,res,prevNum,i+1);//i+1=>Combination 

                sb.setLength(len);
                res=prevRes;
                prevNum=prev;

            }else{
                //Add
                sb.append("+").append(currNum);
                res+=currNum;
                prevNum=currNum;

                solve(s,target,sb,list,res,prevNum,i+1);//i+1=>Combination 

                sb.setLength(len);
                res=prevRes;
                prevNum=prev;

                //Sub
                sb.append("-").append(currNum);
                res-=currNum;
                prevNum=(-currNum);//Negative number because subtracting

                solve(s,target,sb,list,res,prevNum,i+1);//i+1=>Combination 

                sb.setLength(len);
                res=prevRes;
                prevNum=prev;

                //Multi-!!This is why this Que is HARD
                sb.append("*").append(currNum);
                res=(res-prevNum)+(prevNum*currNum);//formula to calculate multiplication this is the Reason why we need to know the previous number because for +,- we can just do reverse but for multiplication it is of higher priority so we need to know the prev number
                prevNum=currNum*prevNum;

                solve(s,target,sb,list,res,prevNum,i+1);//i+1=>Combination 

                sb.setLength(len);
                res=prevRes;
                prevNum=prev;


            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        long res = 0;//this will tell us the result we got up until now
        long prevNum = 0;//this will tell us what was the previous number that was included in the Equation so that if operator with Higher priority comes then it can be handled.

        StringBuilder sb = new StringBuilder();

        solve(num, target, sb, list, res, prevNum, 0);

        return list;
    }
}

```
