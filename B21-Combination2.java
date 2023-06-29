public static void combination2(int[] boxes, int ci, int ti, int llb) {

        if(ci>ti)
        {
            for(int i:boxes)
            {
                if(i == 0)
                {
                    System.out.print("-");
                }
                else{
                    System.out.print("i");
                }
                
            }
            System.out.println();
            return;
        }


        for(int i=llb+1;i<boxes.length;i++)
        {
            if(boxes[i] == 0)
            {
                boxes[i] = 1;
                combination2(boxes, ci+1, ti, i);
                boxes[i] = 0;
            }
        }
        
     }
