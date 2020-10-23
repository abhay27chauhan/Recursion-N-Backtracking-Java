class queenCombination1{

    public static void queenCombination(int qpsf, int tq, int row, int col, String asf)
    {   
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }   

        int nr = 0;
        int nc = 0;
        String yasf = "";
        String nasf = "";
        if(col == tq-1){
            nr = row+1;
            nc = 0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        }else{
            nr = row;
            nc = col+1;
            yasf = asf + "q";
            nasf = asf + "-";
        }

        queenCombination(qpsf + 1, tq, nr, nc, yasf);
        queenCombination(qpsf, tq, nr, nc, nasf);
    }

    public static void main(String[] args){
        int n =2;

        queenCombination(0, n, 0, 0, "");
    }
}