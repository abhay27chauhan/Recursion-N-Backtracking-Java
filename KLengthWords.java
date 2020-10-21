// permuatations
import java.util.HashSet;
class KLengthWords{

    public static void solution(int cc, String ustr, Character[] spots, int ssf, int ts){
        if(cc == ustr.length()){
            if(ssf == ts){
                for(int i=0; i<spots.length; i++){
                    System.out.print(spots[i]);
                }System.out.println();
            }
            return;
        }
        
        char c = ustr.charAt(cc);
        for(int i=0; i<spots.length; i++){
            if(spots[i] == null){
                spots[i] = c;
                solution(cc+1, ustr, spots, ssf+1, ts);
                spots[i] = null;
            }
        }

        solution(cc+1, ustr, spots, ssf, ts);
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

        Character[] spots = new Character[k];
        solution(0, ustr, spots, 0, k);
    }
}