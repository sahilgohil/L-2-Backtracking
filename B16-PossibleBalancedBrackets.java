 /*
     * minimum brackets to remove to make the string valid parenthesis
     */
    public static int minBracketsRemove(String s) {

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                st.push(c);
            }
            else if(c == ')')
            {
                if(st.empty())
                {
                    st.push(c);
                }
                else if(st.peek() == '(')
                {
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
        }

        return st.size();
    }

    public static void printPossibleBalancedBrackets(String que) {
        int minRemoval = minBracketsRemove(que);
        HashSet<String> set = new HashSet<>();
        solveBalancedBrackets(que,0, minRemoval, set);
        System.out.println(set);
    }
    private static void solveBalancedBrackets(String question,int currentRemoval, int minRemoval,HashSet<String> set ) {
        if(minRemoval == currentRemoval)
        {
            if(minBracketsRemove(question) == 0)
            {
                set.add(question);
            }
        }

        for(int i=0;i<question.length();i++)
        {
            String restOfString = question.substring(0, i)+question.substring(i+1);
            solveBalancedBrackets(restOfString,currentRemoval+1, minRemoval, set);
        }
    }
