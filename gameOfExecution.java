class gameOfExecution{

    public static int solution(int n, int k){
        if(n == 1){
            return 0;
        }

        int x = solution(n-1, k);
        int y = (x+k)%n;

        return y;
    }

    public static void main(String[] args){
        int n = 6;
        int k = 2;
        
        int ans = solution(n, k);
        System.out.println(ans);
    }
}
 