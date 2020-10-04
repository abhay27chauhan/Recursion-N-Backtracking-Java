class maxScoreOfWords{

    public static int maxScoreOfWords(String[] words, int[] farr, int[] scores, int idx){
        if(idx == words.length){
            return 0;
        }

        int sno = 0 + maxScoreOfWords(words, farr, scores, idx + 1);

        int sword = 0;
        String word = words[idx];
        boolean flag = true;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(farr[ch - 'a'] <= 0){
                flag = false;
            }

            farr[ch - 'a']--;
            sword += scores[ch - 'a'];
        }

        int syes = 0;
        if(flag){
            syes = sword + maxScoreOfWords(words, farr, scores, idx + 1);
        }

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }

        return Math.max(sno, syes);
    }

    public static void main(String[] args){
        String[] words = {"dog", "cat", "dad", "good"};
        int[] scores = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int[] farr = new int[26];
        String str = "absdddgoo";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            farr[ch - 'a']++;
        }

        int maxScore = maxScoreOfWords(words, farr, scores, 0);
        System.out.println(maxScore);
    }
}