// Select K distinct Characters
import java.util.HashSet;
class WordsKSelection2{

    public static void solution(int cs, int k, String ustr, int lo, String asf){
        if(cs > k){
            System.out.println(asf);
            return;
        }

        for(int i=lo+1; i<ustr.length(); i++){
            char c = ustr.charAt(i);
            solution(cs + 1, k, ustr, i, asf + c);
        }

    }

    public static void main(String[] args){
        String str = "aabbbccdde";
        int k = 3;

        String ustr = "";
        HashSet<Character> set = new HashSet<>();
        for(char c: str.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                ustr += c;
            }
        }

        solution(1, k, ustr, -1, "");
    }
}