package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class choice{
    String direction;
    int changeInX;
    int changeInY;
    choice(String direction,int changeInX,int changeInY){
        this.changeInX=changeInX;
        this.changeInY=changeInY;
        this.direction=direction;
    }
}
public class ratInAMaze {
    public static boolean isReached(int x,int y,int n){
        return x==n-1&&y==n-1;
    }
    public static boolean isValids(int x,int y,int[][]arr,int n){
        return x>=0&&x<n&&y>=0&&y<n&&arr[x][y]==1;
    }
    public static void rat(int x,int y,int n,int[][]arr,ArrayList<String>list,List<String>path,List<choice>choices){
        if(isReached(x,y,n)){
            list.add(String.join("",path));
            return;
        }
        for(choice choiced:choices){
            int newX=x+choiced.changeInX;
            int newY=y+choiced.changeInY;
            if(isValids(newX,newY,arr,n)){
                arr[x][y]=0;
                path.add(choiced.direction+"->");
                rat(newX,newY,n,arr,list,path,choices);
                path.remove(path.size()-1);
                arr[x][y]=1;
            }
        }
    }
    public static ArrayList<String> findPath(int[][]arr,int n){
        ArrayList<String>list=new ArrayList<>();
        List<choice> choices=new ArrayList<>(Arrays.asList(
               new choice ("UP",-1,0),
                new choice("Down",1,0),
                new choice ("left",0,-1),
                new choice("Right",0,1)


        ));
        List<String>path=new ArrayList<>();
        if(arr[0][0]==1){
            rat(0,0,n,arr,list,path,choices);
        }
        return list;

    }
    public static void main(String[]args){
        int [][]arr=
                {   {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}
                };
        int n=arr.length;
        System.out.println(findPath(arr,n));

    }
}
