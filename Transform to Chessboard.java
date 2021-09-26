class Solution {
    int n;
    int[][] board;
    int countInRow(int r,int what){
        int count=0;
        for(int i =0;i<n;i++)if(board[r][i]==what)count++;

        return count;
    }
    int countInCol(int c,int what){
        int count=0;
        for(int i =0;i<n;i++)if(board[i][c]==what)count++;

        return count;
    }

    public int movesToChessboard(int[][] board) {
        n = board.length;
        this.board = board;

        int sameMinRowF = -1;
        int sameMaxRowF = -1;
        int sameMinColF = -1;
        int sameMaxColF = -1;
        for (int i = 0; i < n; i++) {
            int newCountOnesRow = countInRow(i, 1);
            int newCountZerosRow = countInRow(i, 0);
            if(Math.abs(newCountOnesRow-newCountZerosRow)>1)return -1;
            int newCountZerosCol = countInCol(i, 0);
            int newCountOnesCol = countInCol(i, 1);
            if(Math.abs(newCountZerosCol-newCountOnesCol)>1)return -1;
            int[]row=board[i];
            int same0Row = countSameInRow(row, 0);
            int same1Row = countSameInRow(row, 1);
            int sameMinRow = Math.min(same0Row,same1Row);
            int sameMaxRow = Math.max(same0Row, same1Row);
            if(sameMinRowF==-1)sameMinRowF = sameMinRow;
            if(sameMaxRowF==-1)sameMaxRowF=sameMaxRow;
            if(sameMinRowF!=sameMinRow)return -1;
            if(sameMaxRowF!=sameMaxRow)return -1;

            int same0Col=countSameInCol(i, 0); 
            int same1Col=countSameInCol(i, 1); 
            int sameMinCol = Math.min(same0Col,same1Col);
            int sameMaxCol = Math.max(same0Col, same1Col);
            if(sameMinColF==-1)sameMinColF = sameMinCol;
            if(sameMaxColF==-1)sameMaxColF=sameMaxCol;
            if(sameMinColF!=sameMinCol)return -1;
            if(sameMaxColF!=sameMaxCol)return -1;
        }
        int count=0;
        boolean isEven =n%2==0;
        if(isEven){
            //101010 nz=3,no=3
            //010101
            int nz = countInRow(0,0);
            int no = countInRow(0,1);
            if(nz!=no)throw new Error("can't");
            nz = countInCol(0,0);
            no = countInCol(0,1);
            if(nz!=no)throw new Error("can't");
            //00111100
            //1001
            //0110
            int c1=0;int c0=0;
            for(int i=0;i<n;i+=2){if(board[0][i]!=1)c1++;if(board[0][i]!=0)c0++;}
            count+=Math.min(c1,c0);
            c1=0;c0=0;
            for(int i=0;i<n;i+=2){if(board[i][0]!=1)c1++;if(board[i][0]!=0)c0++;}
            count+=Math.min(c1,c0);
        }else{
            //1010101 nz=3, no=4
            //0101010 nz=4, no=3

            //1100100100111
            int nz = countInRow(0,0);
            int no = countInRow(0,1);
            if(nz==no+1){
                //0101010
                for(int i =1;i<n;i+=2)if(board[0][i]!=1)count++;
            }else if(no==nz+1){
                //101
                for(int i =1;i<n;i+=2)if(board[0][i]!=0)count++;

            }else throw new Error("can't");
            nz = countInCol(0,0);
            no = countInCol(0,1);
            if(nz==no+1){
                //0101010
                for(int i =1;i<n;i+=2)if(board[i][0]!=1)count++;
            }else if(no==nz+1){
                //101
                for(int i =1;i<n;i+=2)if(board[i][0]!=0)count++;

            }else throw new Error("can't");

        }
            
        return count;
    }
    int countSameInRow(int[]row, int what){
        int count=0;
        int prev=row[0];
        int len=1;
        for(int i =1;i<n;i++){
            int curr=row[i];
            if(curr==what&&curr==prev){
                len++;
            }else{
                count+=len-1;
                len=1;
            }
            prev=curr;
        }
        count+=len-1;
        return count;
    }
    int countSameInCol(int c, int what){ 
        int count=0;
        int prev=board[0][c];
        int len=1;
        for(int i =1;i<n;i++){
            int curr=board[i][c];
            if(curr==what&&curr==prev){
                len++;
            }else{
                count+=len-1;
                len=1;
            }
            prev=curr;
        }
        count+=len-1;
        return count; 
    }  
}   