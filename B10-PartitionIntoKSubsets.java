/*
     * partition n numbers into k subsets
     * each number has 2 choices that either it will go with the existing set or it will create its new set
     * when it will go with the existing set we will not increase the number of sets
     * but when it will create a new set we will increase the number of sets.
     * and we will remove that specific elelment when back tracking
     * if n<k = 0 subset
     * if n = k = 1
     * if n=0 = 0
     * if k = 0 = 0
     * if n>k => many
     */

     public static void partitionIntoKSubsets(int i, int n, int k,int setSoFar, ArrayList<ArrayList<Integer>> sets) {
        if(i>n)
        {
            if(k == setSoFar)
            {
                for(ArrayList<Integer> set:sets)
                {
                    System.out.print(set+" ");
                }
                System.out.println();
            }
            return;
        }

        for(int j=0;j<sets.size();j++)
        {
            if(sets.get(j).size() > 0)
            {
                sets.get(j).add(i);
                partitionIntoKSubsets(i+1, n, k, setSoFar, sets);
                sets.get(j).remove(sets.get(j).size()-1);
            }
            else{

                sets.get(j).add(i);
                partitionIntoKSubsets(i+1, n, k, setSoFar+1, sets);
                sets.get(j).remove(sets.get(j).size()-1);
                break;
            }
        }
        
     }
