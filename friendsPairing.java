class friendsPairing{

    public static void solution(int i, int n, boolean[] used, String asf){
        if( i> n){
            System.out.println(asf);
            return;
        }
        if(used[i] == true){
            solution(i+1, n, used, asf);
        }else{
            used[i] = true;
            solution(i+1, n, used, asf + "(" + i + ")");
            for(int j=i+1; j<=n; j++){
                if(used[j] == false){
                    used[j] = true;
                    solution(i+1, n, used, asf + "(" + i + j + ")");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }

    public static void main(String[] args){
        int n = 4; // no. of friends
        boolean[] used = new boolean[n+1];
        solution(1, n, used, "");

    }
}