// permuatations
import java.util.HashSet;
class KLengthWords2{

    public static void solution(String ustr, int cs, int ts, HashSet<Character> cset, String asf){
        if(cs > ts){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<ustr.length(); i++){
            char c = ustr.charAt(i);
            if(cset.contains(c) == false){
                cset.add(c);
                solution(ustr, cs+1, ts, cset, asf + c);
                cset.remove(c);
            } 
        }
    }

    public static void main(String[] args){
        String str = "abcabc";
        int k = 2;

        String ustr = "";
        HashSet<Character> set = new HashSet<>();
        for(char c: str.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                ustr += c;
            }
        }

        HashSet<Character> cset = new HashSet<>();
        solution(ustr, 1, k, cset, "");
    }
}