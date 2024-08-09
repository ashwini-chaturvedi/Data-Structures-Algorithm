package BinarySearch;

public class Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0)return false;
        int n=matrix[0].length;
        if(n==0)return false;

        int low=0;
        int high=m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/n;
            int column=mid%m;
            if(matrix[row][column]==target){
                return true;
            }else if(matrix[row][column]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
    public static void main(String[]args){
        int [][] mat={{1,4},{2,5}};
        int target=2;
        System.out.print(searchMatrix(mat,target));
    }
}
