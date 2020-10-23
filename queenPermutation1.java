class queenPermutation1{

    public static void queenPermutation(int qpsf, int tq, int[][] chess){
        if(qpsf == tq){
            for(int row=0; row<chess.length; row++){
                for(int col=0; col<chess.length; col++){
                    if(chess[row][col] != 0){
                        System.out.print("q" + chess[row][col] + "\t");
                    }else{
                        System.out.print("-\t");
                    }

                }System.out.println();
            }System.out.println();

            return;
        }

        for(int row=0; row<chess.length; row++){
            for(int col=0; col<chess.length; col++){
                if(chess[row][col] == 0){
                    chess[row][col] = (qpsf + 1);
                    queenPermutation(qpsf+1, tq, chess);
                    chess[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        int n = 2;
        int[][] chess = new int[n][n];

        queenPermutation(0, n, chess);
    }
}