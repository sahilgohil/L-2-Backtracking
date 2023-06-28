
    static int minDiff = Integer.MAX_VALUE;
    static String ans = "";

    public static void minSubsetSumDifference(int[] arr) {

        solveMinSubsetSumDiff(arr, 0, 0, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(ans);

    }

    public static void solveMinSubsetSumDiff(int[] arr, int idx, int sum1, int sum2, ArrayList<Integer> set1,
            ArrayList<Integer> set2) {

        if (idx == arr.length) {
            int diff = Math.abs(sum2 - sum1);
            if (minDiff > diff) {
                minDiff = diff;
                ans = set1 + " " + set2;
            }
            return;
        }

        if (set1.size() < (arr.length + 1) / 2) {
            set1.add(arr[idx]);
            solveMinSubsetSumDiff(arr, idx + 1, sum1 + arr[idx], sum2, set1, set2);
            set1.remove(set1.size() - 1);
        }

        if (set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[idx]);
            solveMinSubsetSumDiff(arr, idx + 1, sum1, sum2+arr[idx], set1, set2);
            set2.remove(set2.size() - 1);
        }

    }
