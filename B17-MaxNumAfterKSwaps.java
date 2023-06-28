
    /*
     * swap the char k times and find out the maximum number possible
     */

    public static void maxNumAfterKSwaps(String num, int k) {

        HashSet<Integer> set = new HashSet<>();
        solveMaxNumAfterKSwaps(num, k, set);
        int max = Integer.MIN_VALUE;
        for(Integer i:set)
        {
            max = Math.max(max, i);
        }
        System.out.println(max);
        
    }


    public static void solveMaxNumAfterKSwaps(String num, int k,HashSet<Integer> set) {

        if(k < 0)
        {

            int n = Integer.parseInt(num);
           
                set.add(n);
            
            return;
        }

        for(int i=0;i<num.length();i++)
        {
            for(int j=i+1;j<num.length();j++)
            {
                int ith = num.charAt(i) - '0';
                int jth = num.charAt(j) - '0';
                if(jth > ith)
                {
                    String nstr = swapString(num, i, j);
                    solveMaxNumAfterKSwaps(nstr, k-1,set);
                }

            }
        }
        
    }

    public static String swapString(String s, int i, int j) {
       StringBuilder sb = new StringBuilder(s);
       char c = s.charAt(i);
       sb.setCharAt(i, s.charAt(j));
       sb.setCharAt(j, c);
       return sb.toString();
    }
