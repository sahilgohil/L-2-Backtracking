public static void friendsPairing(int n) {

        // two options
        // first option
        // the friend will come
        // if the friend will come
        
        // the friend will not come
        boolean[] friends = new boolean[n+1];

        solveFriendsPairing(1,n, "", friends);
        
        
    }

    public static void solveFriendsPairing(int i,int n, String asf, boolean[] friends)
    {
        if(i>n)
        {
            System.out.println(asf);
            return;
        }
        // if i is already used then we will go to the next
        if(friends[i] == true)
        {
            solveFriendsPairing(i+1, n, asf, friends);
        }
        else{

            // if the i wants to stay alone
            friends[i] = true;
            solveFriendsPairing(i+1, n, asf+"("+i+") ", friends);

            // if the i wants to be with the rest
            for(int j=i+1;j<=n;j++)
            {
                if(friends[j] == false)
                {
                    friends[j] = true;
                    solveFriendsPairing(i+1, n, asf+"("+i+","+j+") ", friends);
                    friends[j] = false;
                }
            }
            friends[i] = false;
        }



    }
