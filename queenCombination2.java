class queenCombination2{

    public static void queenCombination(int qpsf, int tq, boolean[][] chess, int row, int lo){
        if(qpsf == tq){
            for(int i=0; i<chess.length; i++){
                for(int j=0; j<chess.length; j++){
                    if(chess[i][j]){
                        System.out.print("q");
                    }else{
                        System.out.print("-");
                    }
                }System.out.println();
            }System.out.println();

            return;
        }

        for(int col = lo+1; col<chess[0].length; col++){
            chess[row][col] = true;
            queenCombination(qpsf+1, tq, chess, row, col);
            chess[row][col] = false;
        }

        for(int i=row+1; i<chess.length; i++){
            for(int col = 0; col<chess.length; col++){
                chess[i][col] = true;
                queenCombination(qpsf+1, tq, chess, i, col);
                chess[i][col] = false;
            }
        }
    }

    public static void main(String[] args){
        int n =2;
        boolean[][] chess = new boolean[n][n];

        queenCombination(0, n, chess, 0, -1);
    }
}