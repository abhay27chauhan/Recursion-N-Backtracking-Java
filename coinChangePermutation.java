class coinChangePermutation{

    public static void solution(int i, int[] coins, int amtsf, int tamt, String asf){   if(i == coins.length){
            if(amtsf == tamt){
                System.out.println(asf + ".");
            }

            return;
        }
        int count = tamt/coins[i];
        for(int j=count; j>=1; j--){
            String set = "";
            for(int k=0; k<j; k++){
                set += coins[i] + "-";
            }
            solution(i+1, coins, amtsf + coins[i]*j, tamt, asf + set);
        }

        solution(i+1, coins, amtsf, tamt, asf);
    }

    public static void main(String[] args){
        int[] coins = {2,3,5,6,7};
        int amt = 12;

        solution(0, coins, 0, amt, "");
    }
}