    public static void printAbbreviation(String str, String asf, int count, int pos) {

        if(str.length() == pos)
        {
            if(count == 0)
            {
                System.out.println(asf);
            }
            else{
                System.out.println(asf + count);
            }
            return;
        }


        if(count >0) printAbbreviation(str, asf + count + str.charAt(pos), 0, pos+1);
        else printAbbreviation(str, asf + str.charAt(pos), count, pos+1);
        printAbbreviation(str, asf, count+1, pos+1);
        
    }
