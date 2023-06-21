
    public static int maxScore(String[] words, int[] freq, int[] score, int idx) {

        if(idx == words.length)
        {
            return 0;
        }


        // first choice that the word will not come in the subset
        int scoreWithout = 0 + maxScore(words, freq, score, idx+1);

        // second choice that score with the word
        String word = words[idx];
        int scoreOfWord = 0;
        boolean canCall = true;

        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(freq[c - 'a'] == 0)
            {
                canCall = false;
            }

            scoreOfWord += score[c -'a'];
            freq[c - 'a']--;
        }

        int scoreWithWord = 0;

        if(canCall)
        {
            scoreWithWord = scoreOfWord + maxScore(words, freq, score, idx+1);
        }

        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            freq[c - 'a']++;
        }

        return Math.max(scoreWithout, scoreWithWord);


        
    }
