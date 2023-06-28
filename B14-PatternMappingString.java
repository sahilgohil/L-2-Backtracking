 /*
     * given a pattern map each char of that pattern to a given string
     * ex: pep - pattern, graphtreegraph - string
     * ans: p->graph, e-> tree
     */

    public static void patternMappingString(String pattern, String str) {

        HashMap<Character,String> map = new HashMap<>();

        solvePatternMappingString(pattern,str,pattern,map);
        
    }

    public static void solvePatternMappingString(String pattern, String str, String originalPattern, HashMap<Character,String> map) {

        if(pattern.length() == 0)
        {
            if(str.length() == 0)
            {
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for(int i=0;i<originalPattern.length();i++)
                {
                    char c = originalPattern.charAt(i);
                    if(alreadyPrinted.contains(c) == false)
                    {
                        System.out.println(c+" -> "+map.get(c));
                        alreadyPrinted.add(c);
                    }
                }
            }
            return;
        }


        char c = pattern.charAt(0);
        String restOfPattern = pattern.substring(1);

        if(map.containsKey(c))
        {
            String alreadyMapped = map.get(c);
            if(str.length()>= alreadyMapped.length())
            {
                String anotherSame = str.substring(0, alreadyMapped.length());
                String restOfString = str.substring(alreadyMapped.length());
                if(alreadyMapped.equals(anotherSame))
                {
                    solvePatternMappingString(restOfPattern, restOfString, originalPattern, map);
                }
            }

        }
        else{
            for(int i=0;i<str.length();i++)
            {
                String prefix = str.substring(0, i+1);
                String restOfString = str.substring(i+1);

                map.put(c, prefix);
                solvePatternMappingString(restOfPattern, restOfString, originalPattern, map);
                map.remove(c);
            }
        }
        
    }
