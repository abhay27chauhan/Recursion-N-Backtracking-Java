class palindromePartioningOfString{
    public static Boolean isPalindrome(String s){
        int i=0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    public static void solution(String str, String asf){
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<str.length(); i++){
            String s = str.substring(0, i+1);
            String ros = str.substring(i+1);
            if(isPalindrome(s) == true){
                solution(ros, asf + "(" + s + ")");
            }
        }
    }

    public static void main(String[] args){
        String str = "abaaba";

        solution(str, "");
    }
}