class queenCombination3{

    public static void queenCombination(int qpsf, int tq , boolean[][] chess, int lo){
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

        for(int cell = lo +1; cell<chess.length*chess.length; cell++){
            int row = cell/chess.length;
            int col = cell%chess.length;

            chess[row][col] = true;
            queenCombination(qpsf+1, tq, chess, cell);
            chess[row][col] = false;
        }
    }

    public static void main(String[] args){
        int n = 2;
        boolean[][] chess = new boolean[n][n];

        queenCombination(0, n, chess, -1);
    }
}