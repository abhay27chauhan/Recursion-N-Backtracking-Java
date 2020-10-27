class NQueenPermutations{

    public static boolean isQueenSafe(int row, int col, int[][] chess){
        for(int i=row, j=col; i>=0; i--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i=row, j=col; i<chess.length; i++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i=row, j=col; j>=0; j--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i=row, j=col; j<chess.length; j++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j>=0; i--,j--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j<chess.length; i--,j++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i=row, j=col; i<chess.length && j>=0; i++,j--){
            if(chess[i][j] != 0){
                return false;
            }
        }

        for(int i=row, j=col; i<chess.length && j<chess.length; i++,j++){
            if(chess[i][j] != 0){
                return false;
            }
        }

        return true;
    }

    public static void NQueenPermutations(int qpsf, int tq, int[][] chess){
        if(qpsf == tq){
            for(int i=0; i<chess.length; i++){
                for(int j=0; j<chess.length; j++){
                    if(chess[i][j] != 0){
                        System.out.print("q" + chess[i][j] + "\t");
                    }else{
                        System.out.print("-\t");
                    }
                }System.out.println();
            }System.out.println();
        }

        for(int i=0; i<chess.length*chess.length; i++){
            int row = i/chess.length;
            int col = i%chess.length;

            if(chess[row][col] == 0 && isQueenSafe(row, col, chess) == true){
                chess[row][col] = qpsf + 1;
                NQueenPermutations(qpsf+1, tq, chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args){
        int n = 4;
        int[][] chess = new int[n][n];

        NQueenPermutations(0, n, chess);
    }
}