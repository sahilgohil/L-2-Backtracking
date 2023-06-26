	public static void solveCrossword(char[][] crossword, String[] words, int idx) {

        if(words.length == idx)
        {
            printBoard(crossword);
            return;
        }
        String word = words[idx];
        for(int i=0;i<crossword.length;i++)
        {
            for(int j=0;j<crossword[0].length;j++)
            {
                if(crossword[i][j] == '-' || crossword[i][j] == word.charAt(0))
                {
                    if(canPlaceHorizontally(crossword,i,j,word))
                    {
                       boolean[] placed = placeHorizontally(crossword,i,j,word);
                       solveCrossword(crossword, words, idx+1);
                       unplaceHorizontally(crossword,i,j,placed);
                    }

                    if(canPlaceVertically(crossword, i, j, word))
                    {
                       boolean[] placed = placeVertically(crossword,i,j,word);
                       solveCrossword(crossword, words, idx+1);
                       unplaceVertically(crossword, i, j, placed);
                    }
                }
            }
        }

	}

    public static boolean[] placeHorizontally(char[][] crossword, int i, int j, String word) {

        boolean[] wePlaced = new boolean[word.length()];
        for(int jj=0;jj<word.length();jj++)
        {
            if(crossword[i][j+jj] =='-')
            {
                wePlaced[jj] = true;
                crossword[i][j+jj] = word.charAt(jj);
            }
        }
        return wePlaced;    
    }

    public static void unplaceHorizontally(char[][] crossword, int i, int j, boolean[] wePlaced) {
        for(int jj=0;jj<wePlaced.length;jj++)
        {
            if(wePlaced[jj] == true)
            {
                crossword[i][j+jj] = '-';
            }
        }
    }

    public static boolean canPlaceHorizontally(char[][] crossword,int i, int j, String word) {
        if(j-1 >=0 && crossword[i][j-1]!='+')
        {
            return false;
        }
        if(j+word.length() < crossword[0].length && crossword[i][j+word.length()]!= '+' )
        {
            return false;
        }
        

        for(int jj=0;jj<crossword[0].length;jj++)
        {
            if(j+jj >= crossword[0].length)
            {
                return false;
            }
            if(crossword[i][j+jj] == '-' || crossword[i][j+jj] == word.charAt(jj))
            {
                continue;
            }
            else{
                return false;
            }
        }

        return true;
    }

        public static boolean canPlaceVertically(char[][] crossword,int i, int j, String word) {
        if(i-1 >=0 && crossword[i-1][j]!='+')
        {
            return false;
        }
        if(i+word.length() < crossword.length && crossword[i+word.length()][j]!= '+' )
        {
            return false;
        }
     

        for(int ii=0;ii<crossword.length;ii++)
        {
            if(i+ii >= crossword.length)
            {
                return false;
            }
            if(crossword[i+ii][j] == '-' || crossword[i+ii][j] == word.charAt(ii))
            {
                continue;
            }
            else{
                return false;
            }
        }

        return true;
    }

        public static boolean[] placeVertically(char[][] crossword, int i, int j, String word) {

        boolean[] wePlaced = new boolean[word.length()];
        for(int ii=0;ii<word.length();ii++)
        {
            if(crossword[i+ii][j] =='-')
            {
                wePlaced[ii] = true;
                crossword[i+ii][j] = word.charAt(ii);
            }
        }
        return wePlaced;    
    }

        public static void unplaceVertically(char[][] crossword, int i, int j, boolean[] wePlaced) {
        for(int jj=0;jj<wePlaced.length;jj++)
        {
            if(wePlaced[jj] == true)
            {
                crossword[i+jj][j] = '-';
            }
        }
    }
