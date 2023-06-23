 public static void goldMineTwo(int[][] mine) {

        boolean[][] visited = new boolean[mine.length][mine[0].length];

        int max = Integer.MIN_VALUE;

        for(int i=0;i<mine.length;i++)
        {
            for(int j=0;j<mine[0].length;j++)
            {
                if(mine[i][j] != 0 && visited[i][j] == false)
                {
                    ArrayList<Integer> bag = new ArrayList<>();
                    travelAndFillBag(mine,visited,i,j,bag);

                    // after filling the bag we have to check it and compare it with the max
                    int sum = 0;
                    for(int v:bag)
                    {
                        sum += v;
                    }

                    if(sum>max)
                    {
                        max = sum;
                    }
                }
            }
        }

        System.out.println("Max gold in the goldmine is:"+ max);
    
   }

   public static void travelAndFillBag(int[][] mine, boolean[][] visited, int i,int j, ArrayList<Integer> bag) {
        if(i>=mine.length || i<0 || j>=mine[0].length || j<0 || mine[i][j] == 0 || visited[i][j])
        {
            return;
        }

        visited[i][j] = true;
        bag.add(mine[i][j]);
        travelAndFillBag(mine, visited, i+1, j, bag);
        travelAndFillBag(mine, visited, i-1, j, bag);
        travelAndFillBag(mine, visited, i, j+1, bag);
        travelAndFillBag(mine, visited, i, j-1, bag);
    
   }
