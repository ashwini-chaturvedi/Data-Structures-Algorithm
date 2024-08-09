package Strings;

public class String_Builder {
    public static void main(String[]args){
        StringBuilder sb=new StringBuilder("Hello");
        sb.append(78);
        sb.append(" Ashwini Chaturvedi");
        System.out.println(sb);

        System.out.println(sb.length());

        sb.setCharAt(0,'d');
        System.out.println(sb);

        sb.insert(6,9);
        System.out.println(sb);

        sb.deleteCharAt(6);
        System.out.println(sb);

        sb.delete(2,9);//excluding element at end index.
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        String sbs=sb.substring(8,14);
        System.out.println(sbs);

    }
}
