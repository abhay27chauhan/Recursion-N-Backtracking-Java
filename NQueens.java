// method -2;

class NQueens{

    public static void printNQueens(int[][] chess, int[] cols, int[] ndia, int[] rdia, String qsf, int row){
        if(row == chess.length){
            System.out.println(qsf);
            return;
        }

        for(int col = 0; col<chess[0].length; col++){
            if(cols[col] != 1 && ndia[row+col] != 1 && rdia[row-col + chess.length] != 1){
                chess[row][col] = 1;
                cols[col] = 1;
                ndia[row+col] = 1;
                rdia[row-col + chess.length] = 1;

                printNQueens(chess, cols, ndia, rdia, qsf + row + "-" + col + ", ", row +1);

                chess[row][col] = 0;
                cols[col] = 0;
                ndia[row+col] = 0;
                rdia[row-col + chess.length] = 0;
            }

        }
    }

    public static void main(String[] args){
        int[][] arr = {{0,0,0,0},
                       {0,0,0,0},
                       {0,0,0,0},
                       {0,0,0,0}};
                       
        int n = arr.length;
        int[] cols = new int[n];
        int[] ndia = new int[2*n -1];
        int[] rdia = new int[2*n -1];
        printNQueens(arr, cols, ndia, rdia, "", 0);
    }
}