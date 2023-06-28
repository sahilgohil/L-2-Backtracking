/*
     * make a sentence from a given string only with the words that exist in the dictionary
     */

    public static void wordBreak(String question, String ans, HashSet<String> dict) {

        if(question.length() == 0)
        {
            System.out.println(ans);
            return;
        }


        for(int i=0;i<question.length();i++)
        {
            String prefix = question.substring(0, i+1);
            String restOfString = question.substring(i+1);

            if(dict.contains(prefix))
            {
                wordBreak(restOfString, ans+prefix+" ", dict);
            }
        }
        
    }
