package Recursion.Recursion;

import java.util.ArrayList;

public class LetterCombinationToKeypad {
    public static void keys(String digits,String[]keyMap,String currAns,ArrayList<String>res){
        if(digits.isEmpty()){
            res.add(currAns+"");
            return;
        }
        int currNum=digits.charAt(0)-'0';//to get the result as int not as char.//can not do type casting because ti will give the ascii value not the real value means if the number is 3 it will give 51(ASCII value) not 3
        String currChoice=keyMap[currNum];
        for(int i=0;i<currChoice.length();i++){
            keys(digits.substring(1),keyMap,currAns+currChoice.charAt(i),res);
        }
    }
    public static void main(String[]args){
        String digits="23";
        String [] keyMap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> res=new ArrayList<>();
        keys(digits,keyMap,"",res);//=>empty string of currAns will be passed;
        System.out.println(res);

    }
}
