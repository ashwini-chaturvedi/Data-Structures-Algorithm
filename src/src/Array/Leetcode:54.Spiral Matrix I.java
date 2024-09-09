class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int columns=matrix[0].length;
        int topRow=0;
        int bottomRow=row-1;
        int leftColumn=0;
        int rightColumn=columns-1;
        int totalElement=0;
        ArrayList<Integer>res=new ArrayList<>();
        while(totalElement<row*columns){
            for(int j=leftColumn;j<=rightColumn&&totalElement<row*columns;j++){
                totalElement++;
                res.add( matrix[topRow][j]);
            }
            topRow++;
            for(int i=topRow;i<=bottomRow&&totalElement<row*columns;i++){
                totalElement++;
                res.add(matrix[i][rightColumn]);
                
            }
            rightColumn--;
            for(int j=rightColumn;j>=leftColumn&&totalElement<row*columns;j--){
                totalElement++;
                res.add(matrix[bottomRow][j]);
                
            }
            bottomRow--;
            for(int i=bottomRow;i>=topRow&&totalElement<row*columns;i--){
                totalElement++;
                res.add(matrix[i][leftColumn]);
                
            }
            leftColumn++;
        }
        return res;
    }
}
