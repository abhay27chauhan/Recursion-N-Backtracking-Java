class LexicographicalOrder{

    public static void printLexicographically(int i, int n){
        if( i > n){
            return;
        }

        System.out.print(i + " ");
        for(int j = 0; j<10; j++){
            printLexicographically(10*i+j, n);
        }
        
    }

    public static void main(String[] args){
        int n = 1000;

        for(int i=1; i<=9; i++){
            printLexicographically(i, n);
        }
    }
}