class crosswordPuzzle{

    public static void display(char[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }System.out.println();
        }
    }

    public static boolean canWePlaceWordHorizontally(char[][] board, String word, int i, int j){
        if(j-1>=0 && board[i][j-1] != '+'){
            return false;
        }else if(j+word.length() < board[0].length && board[i][j+word.length()] != '+'){
            return false;
        }

        for(int jj=0; jj<word.length(); jj++){
            if(j+jj >= board[0].length){
                return false;
            }

            if(board[i][j+jj] == '-' || board[i][j+jj] == word.charAt(jj)){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }

    public static boolean canWePlaceWordVertically(char[][] board, String word, int i, int j){
       if(i-1>=0 && board[i-1][j] != '+'){
           return false;
       }else if(i+word.length() < board.length && board[i+word.length()][j] != '+'){
           return false;
       }

       for(int ii=0; ii<word.length(); ii++){
           if(i+ii >= board.length){
               return false;
           }

           if(board[i+ii][j] == '-' || board[i+ii][j] == word.charAt(ii)){
               continue;
           }else{
               return false;
           }
       }

       return true;
    }

    public static boolean[] placeWordHorizontally(char[][] board, String word, int i, int j){
        boolean[] weplaced = new boolean[word.length()];

        for(int jj =0; jj<word.length(); jj++){
            if(board[i][j+jj] == '-'){
                board[i][j+jj] = word.charAt(jj);
                weplaced[jj] = true;
            }
        }

        return weplaced;
    }

    public static boolean[] placeWordVertically(char[][] board, String word, int i, int j){
        boolean[] weplaced = new boolean[word.length()];

        for(int ii=0; ii<word.length(); ii++){
            if(board[i+ii][j] == '-'){
                board[i+ii][j] = word.charAt(ii);
                weplaced[ii] = true;
            }
        }
        return weplaced;
    }

    public static void unPlaceWordHorizontally(char[][] board, boolean[] weplaced, int i, int j){
        for(int jj=0; jj<weplaced.length; jj++){
            if(weplaced[jj] == true){
                board[i][j+jj] = '-';
            }
        }
    }

    public static void unPlaceWordVertically(char[][] board, boolean[] weplaced, int i, int j){
        for(int ii=0; ii<weplaced.length; ii++){
            if(weplaced[ii] == true){
                board[i+ii][j] = '-';
            }
        }
    }

    public static void solution(char[][] board, String[] words, int idx){
        if(idx == words.length){
            display(board);
            return;
        }
         
        String word = words[idx];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '-' || board[i][j] == word.charAt(0)){
                    if(canWePlaceWordHorizontally(board, word, i, j) == true){
                        boolean[] weplaced = placeWordHorizontally(board, word, i, j);
                        solution(board, words, idx+1);
                        unPlaceWordHorizontally(board, weplaced, i, j);
                    }

                    if(canWePlaceWordVertically(board, word, i, j) == true){
                        boolean[] weplaced = placeWordVertically(board, word, i, j);
                        solution(board, words, idx+1);
                        unPlaceWordVertically(board, weplaced, i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        char[][] arr = {{'+','-','+','+','+','+','+','+','+','+'},
                          {'+','-','+','+','+','+','+','+','+','+'},
                          {'+','-','+','+','+','+','+','+','+','+'},
                          {'+','-','-','-','-','-','+','+','+','+'},
                          {'+','-','+','+','+','-','+','+','+','+'},
                          {'+','-','+','+','+','-','+','+','+','+'},
                          {'+','+','+','+','+','-','+','+','+','+'},
                          {'+','+','-','-','-','-','-','-','+','+'},
                          {'+','+','+','+','+','-','+','+','+','+'},
                          {'+','+','+','+','+','-','+','+','+','+'}
                        };
        String[] words = {"LONDON", "DELHI", "ICELAND", "ANKARA"};
        solution(arr, words, 0);
    }
}