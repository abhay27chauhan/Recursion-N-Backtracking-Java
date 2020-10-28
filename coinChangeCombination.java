class coinChangeCombination{

    public static void solution(int i, int[] coins, int amtsf, int tamt, String asf)
    {   
        if(i == coins.length){
            if(amtsf == tamt){
                System.out.println(asf + ".");
            }

            return;
        }
        solution(i+1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        solution(i+1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args){
        int[] coins = {2,3,5,6,7};
        int amt = 12;
        
        solution(0, coins, 0, amt, "");
    }
}