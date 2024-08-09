package Stacks;

import java.util.Stack;

public class InfixExpression {
    public static void main(String[]args){
        String str="9-5+3*4/6";
        Stack<Integer>num=new Stack<>();
        Stack<Character>operator=new Stack<>();
        for(int i=0;i<str.length();i++){
            int asciiVal=(int)str.charAt(i);
            if(asciiVal>=48&&asciiVal<=57){
                num.push(asciiVal-48);
            }else if(operator.isEmpty()){
                operator.push(str.charAt(i));
            }else{
                //means that character is operator type and stack is not Empty
                //Now we will do the calculations.
                // we will check priority and do calculations
                if(str.charAt(i)=='+'||str.charAt(i)=='-'){
                    //Do the work these are the least prioritised
                    int v2=num.pop();
                    int v1=num.pop();
                   //pop the operator at top of the stack...
                    if(operator.peek()=='+')num.push(v1+v2);
                    if(operator.peek()=='-')num.push(v1-v2);
                    if(operator.peek()=='*')num.push(v1*v2);
                    if(operator.peek()=='/')num.push(v1/v2);
                    operator.pop();
                    operator.push(str.charAt(i));//pushing the current operation

                }else if(str.charAt(i)=='*'||str.charAt(i)=='/'){
                    if(operator.peek()=='*'||operator.peek()=='/'){
                        //Do the work these are the least prioritised
                        int v2=num.pop();
                        int v1=num.pop();
                        //pop the operator at top of the stack...
                        if(operator.peek()=='*')num.push(v1*v2);
                        if(operator.peek()=='/')num.push(v1/v2);
                        operator.pop();
                        operator.push(str.charAt(i));
                    }else{
                        operator.push(str.charAt(i));
                    }
                }

            }
        }
        //Extracting the Answer
        while(num.size()>1){
            int v2=num.pop();
            int v1=num.pop();
            char operation=operator.peek();//pop the operator at top of the stack...
            if(operation=='+')num.push(v1+v2);
            if(operation=='-')num.push(v1-v2);
            if(operation=='*')num.push(v1*v2);
            if(operation=='/')num.push(v1/v2);
            operator.pop();
        }
        System.out.println("Answer:"+num.peek());
    }
}
