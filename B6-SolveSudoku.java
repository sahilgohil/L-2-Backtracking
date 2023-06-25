   public static void solveSudoku(int[][] board, int row, int col) {

    if(row == board.length)
    {
        printBoard(board);
        return;
    }

        int nRow = 0;
        int nCol = 0;
        if(col == board[0].length)
        {
            nRow = row+1;
            nCol = 0;
            solveSudoku(board, nRow, nCol);
        }
        else{
            if(board[row][col] != 0)
            {
                solveSudoku(board, row, col+1);
            }
            else{
                for(int pos = 1;pos<=9;pos++)
                {
                    if(isValid(board,row,col,pos))
                    {
                        board[row][col] = pos;
                        solveSudoku(board,row,col+1);
                        board[row][col] = 0;
                    }
                }

            }
        }
    
   }

   public static boolean isValid(int[][] board, int row, int col, int val)
   {
        // check the entire col
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col] == val)
            {
                return false;
            }
        }

        // check the entire row
        for(int i=0;i<board[0].length;i++)
        {
            if(board[row][i] == val)
            {
                return false;
            }
        }

        // check the matrix
        int stRow = 3 * (row/3);
        int stCol = 3 * (col/3);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[stRow+i][stCol+j] == val)
                {
                    return false;
                }
            }
        }

        return true;
   }

   public static void printBoard(int[][] board)
   {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
   }
