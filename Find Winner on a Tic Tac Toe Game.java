class Solution {
    
    public String validateBoard(char[][] board, int n){
        
        // checking Horizontal
        
        for(int i=0;i<n;i++){
            int Acount = 0;
            int Bcount = 0;
            
            for(int j=0;j<n;j++){
                if(board[i][j]=='X') Acount++;
                
                if(board[i][j]=='O') Bcount++;
            }
            
            if(Acount==3) return "A";
            if(Bcount==3) return "B";
        }
        
        // checking Vertical
        
        for(int j=0;j<n;j++){
            int Acount=0;
            int Bcount = 0;
            
            for(int i=0;i<n;i++){
                if(board[i][j]=='X') Acount++;
                if(board[i][j]=='O') Bcount++;
            }
            
            if(Acount==3) return "A";
            if(Bcount==3) return "B";
        }
        
        // checking diagonal
        
        if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X') return "A"; 
        if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O') return "B";
              
        if(board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X') return "A";
        if(board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O') return "B";
        
        // checking draw or pending
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X' || board[i][j]=='O')
                    cnt++;
            }
        }
        
        if(cnt==9) return "Draw";
        return "Pending";
        
    }
    
    
    public String tictactoe(int[][] moves) {
        int n = 3;
        char[][] board = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        // initialize board
        int flag = 0;
        for(int[] move : moves){
            if(flag%2==0){
                board[move[0]][move[1]] = 'X';
            }else{
                board[move[0]][move[1]] = 'O';
            }
            flag++;
        }
        
        return validateBoard(board,n);
    }
}