package BinarySearch;

public class choclateProblem {
    static boolean isDivisionPossible(int[]chocolateBoxes,int numOfStudents,int maxChocAllowed ){
        int countOfStudent=1;
        int chocolates=0;
        for(int i=0;i<chocolateBoxes.length;i++){
            if(chocolateBoxes[i]>maxChocAllowed)return false;//if in current box there are chocolates more then maxChocolatesallowed then we cannot give it to anybody else.
            if(chocolates+chocolateBoxes[i]<=maxChocAllowed){
                chocolates+=chocolateBoxes[i];
            }else{
                countOfStudent++;
                chocolates=chocolateBoxes[i];
            }
        }
       if(numOfStudents<countOfStudent){
           return false;
       }else{
           return true;
       }
    }
    static int distributeChocolates(int[]chocolateBoxes,int numOfStudents){
        if(chocolateBoxes.length<numOfStudents) return -1;//Not possibly found
        int low=1;
        int high=(int)1e9;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isDivisionPossible(chocolateBoxes,numOfStudents,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[]args){
        int []chocolateBoxes={5,3,1,4,2};
        int numOfStudents=3;
        System.out.println(distributeChocolates(chocolateBoxes,numOfStudents));
    }
}
