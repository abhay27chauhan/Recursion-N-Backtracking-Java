class maximumNumberAfterKSwaps{

    static String max;
    public static String swap(String s, int i, int j){
        char ci = s.charAt(i);
        char cj = s.charAt(j);

        String left = s.substring(0, i);
        String middle = s.substring(i+1, j);
        String right = s.substring(j+1);

        return left + cj + middle + ci + right;
    }

    public static void findMaximum(String s, int k){
        if( k == 0){
            if(Integer.parseInt(s) > Integer.parseInt(max)){
                max = s; 
            }
            return;
        }

        for(int i=0; i<s.length()-1; i++){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(j) > s.charAt(i)){
                    String swaped = swap(s, i, j);
                    findMaximum(swaped, k-1);
                }
            }
        }
    }

    public static void main(String[] args){
        String str = "1234567";
        int k = 4;
        max = str;
        findMaximum(str, k);
        System.out.println(max);
    }
}