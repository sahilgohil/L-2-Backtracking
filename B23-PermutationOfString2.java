 /*

      * here each character will decide to come in the permutation or not
      hence the recursion will run till there are no characters left
      where as in the first type of permutation string the spot will decide that what character to put on it
      and here the recursion will run until there are no spots left

      */

     public static void permutationOfString2(String queString,String asf) {

        if(queString.length() == 0)
        {
            System.out.println(asf);
            return;
        }

        for(int i=0;i<queString.length();i++)
        {
            char c = queString.charAt(i);
            String ros = queString.substring(0, i) + queString.substring(i+1);
            permutationOfString2(ros, asf+c);
        }
        
     }
