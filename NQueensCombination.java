class NQueensCombination{

    public static boolean isQueenSafe(int row, int col, boolean[][] chess){
        for(int i=row, j = col; i>=0; i--){
            if(chess[i][j]){
                return false;
            }
        }

        for(int i=row, j = col; j>=0; j--){
            if(chess[i][j]){
                return false;
            }
        }

        for(int i=row, j = col; i>=0 && j>=0; i--, j--){
            if(chess[i][j]){
                return false;
            }
        }

        for(int i=row, j = col; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j]){
                return false;
            }
        }

        return true;
    }

    public static void NQueensCombination(int qpsf, int tq, boolean[][] chess, int lo){
        if(qpsf == tq){
            for(int i=0; i<chess.length; i++){
                for(int j=0; j<chess.length; j++){
                    if(chess[i][j] == true){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                }System.out.println();
            }System.out.println();

            return;
        }

        for(int i = lo +1; i<chess.length*chess.length; i++){
            int row = i/chess.length;
            int col = i%chess.length;

            if(chess[row][col] == false && isQueenSafe(row, col , chess) == true){
                chess[row][col] = true;
                NQueensCombination(qpsf+1, tq, chess, i);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args){
        int n = 4;
        boolean[][] chess = new boolean[n][n];

        NQueensCombination(0, n, chess, -1);
    }
}