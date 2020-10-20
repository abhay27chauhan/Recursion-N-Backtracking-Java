// Select K distinct Characters
import java.util.HashSet;
class WordsKSelection{

    public static void solution(int i, String ustr, int ssf, int k, String asf){
        if(i == ustr.length()){
            if(ssf == k){
                System.out.println(asf);
            }
            return;
        }

        char c = ustr.charAt(i);

        solution(i+1, ustr, ssf + 1, k, asf + c);
        solution(i+1, ustr, ssf, k, asf);
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

        solution(0, ustr, 0, k, "");
    }
}