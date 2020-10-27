class NKnightsCombinations{

    public static boolean isKnightSafe(int row, int col, boolean[][] chess){
        if(row-2 >=0 && col-1>=0 && chess[row-2][col-1]){
            return false;
        }

        if(row-1 >=0 && col-2>=0 && chess[row-1][col-2]){
            return false;
        }

        if(row-2 >=0 && col+1<chess.length && chess[row-2][col+1]){
            return false;
        }

        if(row-1 >=0 && col+2<chess.length && chess[row-1][col+2]){
            return false;
        }

        return true;
    }

    public static void NKnightsCombinations(int kpsf, int tq, boolean[][] chess, int lo){
        if(kpsf == tq){
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

        for(int i= lo +1; i<chess.length*chess.length; i++){
            int row = i/chess.length;
            int col = i/chess.length;

            if(chess[row][col] == false && isKnightSafe(row, col, chess) == true){
                chess[row][col] = true;
                NKnightsCombinations(kpsf + 1, tq, chess, i);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args){
        int n = 4;
        boolean[][] chess = new boolean[n][n];

        NKnightsCombinations(0, n, chess, -1);
    }
}