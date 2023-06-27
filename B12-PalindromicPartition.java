    /*
     * palindromic partitionating
     */

    public static void palindromicPartition(String s, String ans) {

        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String palin = s.substring(0, i + 1);
            String ros = s.substring(i + 1);
            if (isPalindromic(palin)) {
                palindromicPartition(ros, ans+"("+palin+") ");
            }
        }

    }

    public static boolean isPalindromic(String s) {

        int si = 0;
        int ei = s.length()-1;

        while(si<ei)
        {
            char st = s.charAt(si);
            char ed = s.charAt(ei);
            if(st != ed)
            {
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }
