/*
given the n boxes and r items give all the possible permutations to put the items in that box
*/
public static void permutationFillBoxes(int[] boxes,int currentItem, int totalItem) {

        if(currentItem > totalItem)
        {
            for(int i:boxes)
            {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<boxes.length;i++)
        {
            if(boxes[i] == 0)
            {
                boxes[i] = currentItem;
                permutationFillBoxes(boxes, currentItem+1, totalItem);
                boxes[i] = 0;
            }
        }
        
    }
