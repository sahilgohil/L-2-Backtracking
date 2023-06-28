/*
     * this question is the extension of the question of partition into k subsets
     * here the base case will be changed,
     * we need to check each subset and determine that each of the elements sum is equal
     * and print only those elements.
     */
    public static void equalSumSubsetPartition(int n, int k) {

        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sets.add(i, new ArrayList<>());
        }
        solveEqualSumSubset(1, n, k, 0, sets);

    }

    public static void solveEqualSumSubset(int i, int n, int k, int currentSet, ArrayList<ArrayList<Integer>> sets) {

        if (i > n) {
            if (k == currentSet) {
                int sum = 0;
                int sum2 = 0;
                for (int ii = 0; ii < sets.size(); ii++) {
                    for (int jj = 0; jj < sets.get(ii).size(); jj++) {
                        if (ii == 0) {
                            sum += sets.get(ii).get(jj);
                        } else {
                            sum2 += sets.get(ii).get(jj);
                        }

                    }
                    if (ii != 0) {
                        if (sum != sum2) {
                            return;
                        }
                        sum2 = 0;
                    }
                }

                for (ArrayList<Integer> set : sets) {
                    System.out.print(set + " ");
                }
                System.out.println();
                
            }

            return;
        }

        for (int j = 0; j < sets.size(); j++) {
            // if the set contains sets
            if (sets.get(j).size() > 0) {
                sets.get(j).add(i);
                solveEqualSumSubset(i + 1, n, k, currentSet, sets);
                sets.get(j).remove(sets.get(j).size() - 1);
            } else {

                sets.get(j).add(i);
                solveEqualSumSubset(i + 1, n, k, currentSet + 1, sets);
                sets.get(j).remove(sets.get(j).size() - 1);
                break;
            }
        }

    }
