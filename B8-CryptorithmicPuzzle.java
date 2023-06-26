 public static void cryptorithmicPuzzle(String s1, String s2, String s3) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        // mapping unique char from s1 s2 and s3 and making a unique string 
        String unique = "";
        for(char c:s1.toCharArray())
        {
            if(charMap.containsKey(c) == false)
            {
                charMap.put(c, -1);
                unique+= c;
            }
        }
        //
         for(char c:s2.toCharArray())
        {
            if(charMap.containsKey(c) == false)
            {
                charMap.put(c, -1);
                unique+= c;
            }
        }
         for(char c:s3.toCharArray())
        {
            if(charMap.containsKey(c) == false)
            {
                charMap.put(c, -1);
                unique+= c;
            }
        }

        boolean[] chars = new boolean[10];

        solveCryptorithmicPuzzle(charMap,unique,0,chars,s1,s2,s3);
    }

    public static void solveCryptorithmicPuzzle(HashMap<Character,Integer> charMap, String unique, int idx, boolean[] usedNums, String s1, String s2, String s3) {

        if(idx == unique.length())
        {
            int num1 = getNum(s1,charMap);
            int num2 = getNum(s2,charMap);
            int num3 = getNum(s3,charMap);
            if(num1 + num2 == num3)
            {
                for(int i=0;i<26;i++){
                    char c = (char) ('a'+i);
                    if(charMap.containsKey(c))
                    {
                        System.out.print(c +" - "+charMap.get(c)+" ");
                    }
                }
                System.out.println();

            }
            return;
        }

        char c = unique.charAt(idx);
        for(int num=0;num<=9;num++)
        {
            if(usedNums[num] == false)
            {
                charMap.put(c, num);
                usedNums[num] = true;
                solveCryptorithmicPuzzle(charMap, unique, idx+1, usedNums, s1, s2, s3);
                charMap.put(c, -1);
                usedNums[num] = false;
            }
        }
        
    }

    public static int getNum(String s, HashMap<Character,Integer> charMap) {

        String num = "";
        for(char c:s.toCharArray())
        {
            num += charMap.get(c);
        }
        return Integer.parseInt(num);
        
    }
