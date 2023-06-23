    public static void printlexiographicOrder(int n) {

        for(int i=1;i<=9;i++)
        {
            depthFirstLexio(i, n);
        }
        
    }

    public static void depthFirstLexio(int i, int n) {

        if(i>n)
        {
            return;
        }

        System.out.println(i);
        for(int j=0;j<10;j++)
        {
            depthFirstLexio(i*10+j, n);
        }
        
    }
