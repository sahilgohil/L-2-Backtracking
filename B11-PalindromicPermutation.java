public static void palindromicPermutations(String ques) {

        /*
         * first make a char frequency map
         */

        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i=0;i<ques.length();i++)
        {
            char c = ques.charAt(i);
            if(charMap.containsKey(c))
            {
                int freq = charMap.get(c);
                charMap.put(c, freq+1);
            }
            else{
                charMap.put(c, 1);
            }
        }
        /*
         * now we will check if each char has even frequency and if any char has odd frequency that must be for only one char for the palindromic
         * permutation to happen
         */

         Character odd = null;
         int oddNum = 0;
         int countSet = 0;
         for(char c:charMap.keySet())
         {
            int freq = charMap.get(c);
            if(freq%2 == 1)
            {
                oddNum++;
                odd = c;
            }

            charMap.put(c, freq/2);
            countSet += freq/2;
            if(oddNum >1)
            {
                System.out.println("Permutations does not exist");
                break;
            }
         }

         solvePalindromicPermutations(1, countSet, "", odd, charMap);
        
     }


     public static void solvePalindromicPermutations(int currentPosition, int totalElement, String asf, Character odd, HashMap<Character,Integer> charMap) {
        if(currentPosition > totalElement)
        {
            String reverse = "";
            for(int i=asf.length()-1;i>=0;i--)
            {
                reverse += asf.charAt(i);
            }

            if(odd != null)
            {
                asf+=odd;
            }

            System.out.println(asf+reverse);
            return;
        }

        for(char c: charMap.keySet())
        {
            int freq = charMap.get(c);
            charMap.put(c, freq-1);
            solvePalindromicPermutations(currentPosition+1, totalElement, asf+c, odd, charMap);
            charMap.put(c, freq);
        }
        
     }
