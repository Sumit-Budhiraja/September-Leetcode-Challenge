class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {        
        boolean[][] isZero = new boolean[n][n];
        for(int[] pos:mines){
            isZero[pos[0]][pos[1]] = true;
        }
		
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];
        
        int maxOrder = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                left[i][j] = isZero[i][j]?0:1+(j==0?0:left[i][j-1]);
                up[i][j] = isZero[i][j]?0:1+(i==0?0:up[i-1][j]);
            }
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                right[i][j] = isZero[i][j]?0:1+(j==n-1?0:right[i][j+1]);
                down[i][j] = isZero[i][j]?0:1+(i==n-1?0:down[i+1][j]);
                int ord = Math.min(Math.min(left[i][j],up[i][j]),Math.min(right[i][j],down[i][j]));
                maxOrder = Math.max(maxOrder, ord);
            }
        }
        
        return maxOrder;
    }
}