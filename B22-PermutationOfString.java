public static void permutationOfString(String question) {

        // first make a frequency map of each char in string
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<question.length();i++)
        {
            char c = question.charAt(i);
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }

        solvePermutationOfString(0,question.length()-1,map,"");
        
     }
     public static void solvePermutationOfString(int currentSpot, int totalSpots, HashMap<Character,Integer> map,String asf) {
        if(currentSpot>totalSpots)
        {
            System.out.println(asf);
            return;
        }

        for(char c:map.keySet())
        {
            if(map.get(c)>0)
            {
                map.put(c, map.get(c)-1);
                solvePermutationOfString(currentSpot+1, totalSpots, map, asf+c);
                map.put(c, map.get(c)+1);
            }
        }
        
     }
