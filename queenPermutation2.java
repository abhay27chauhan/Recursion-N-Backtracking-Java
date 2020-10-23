class queenPermutation2{

    public static void queenPermutation(int qpsf, int tq, int row, int col, String asf, boolean[] queens){
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }

            return;
        }

        int nr = 0;
        int nc = 0;
        String fac = "\0";
        if(col == tq-1){
            nr = row+1;
            nc = 0;
            fac = "\n";
        }else{
            nr = row;
            nc = col+1;
            fac = "\t";
        }

        for(int i=0; i<queens.length; i++){
            if(queens[i] == false){
                queens[i] = true;
                queenPermutation(qpsf+1, tq, nr, nc, asf + "q" + (i+1) + fac, queens);
                queens[i] = false;
            }
        }

        queenPermutation(qpsf, tq, nr, nc, asf + "-" + fac, queens);
    }

    public static void main(String[] args){
        int n = 2;
        boolean[] queens = new boolean[n];
        queenPermutation(0, n, 0, 0, "", queens);
    }
}