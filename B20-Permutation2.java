 /*
     * permutation using second method where we will extedn the way we do combination
     * in combination, we have two choices for each box,
     * 1-> it will allow the item to place
     * 2-> not allow to place
     * 
     * but for permutation we will extend this to 
     * many choices as
     * 1-> not to place any one
     * 2-> place one of the item using the loop
     */

     public static void permutation2(int cb, int tb, int ssf, int ts, int[] usedItem, String asf) {

        if(cb > tb)
        {
            if(ssf == ts)
            {
                System.out.println(asf);
            }
            return;
        }
        
        permutation2(cb+1, tb, ssf, ts, usedItem, asf+"-");

        for(int i=1;i<=ts;i++)
        {
            if(usedItem[i-1] == 0)
            {
                usedItem[i-1] = 1;
                permutation2(cb+1, tb, ssf+1, ts, usedItem, asf+(i));
                usedItem[i-1] = 0;
            }
        }
     }
