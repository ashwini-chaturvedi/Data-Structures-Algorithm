package Backtracking;

public class hdf {
    public static void main(String[] args) {
      int []arr={1,2,1,3,2,5};
      int xorRes=0;
      for(int num:arr){
          xorRes^=num;
      }
        System.out.println(xorRes);
      int rightMostBit=xorRes& -xorRes;
        System.out.println(rightMostBit);
        int[]res=new int[2];
        for(int num:arr){
            if((num&rightMostBit)==0){
                res[0]^=num;
            }else{
                res[1]^=num;
            }
        }
        for(int num:res){
            System.out.print(num+",");
        }
    }
}
