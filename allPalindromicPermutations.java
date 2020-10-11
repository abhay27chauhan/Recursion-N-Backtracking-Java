import java.util.HashMap;
class allPalindromicPermutations{

    public static void solution(int i, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf){
        if(i>ts){
            String rev = "";
            for(int j=asf.length()-1; j>=0; j--){
                rev += asf.charAt(j);
            }

            String res = asf;
            if(oddc != null){
                res += oddc;
            }

            res += rev;

            System.out.println(res);
            return;
        }

        for(char c: fmap.keySet()){
            int f = fmap.get(c);
            if(f > 0){
                fmap.put(c, f-1);
                solution(i+1, ts, fmap, oddc, asf + c);
                fmap.put(c, f);
            }
        }

    }

    public static void main(String[] args){
        String str = "aaabb";
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char c: str.toCharArray()){
            if(fmap.containsKey(c)){
                int of = fmap.get(c);
                fmap.put(c, of+1);
            }else{
                fmap.put(c, 1);
            }
        }

        Character oddc = null;
        int odd = 0;
        int len = 0;

        for(char c: fmap.keySet()){
            int f = fmap.get(c);

            if(f%2 == 1){
                oddc = c;
                odd++;
            }
            len +=f/2;

            fmap.put(c, f/2);
        }

        solution(1, len, fmap, oddc, "");
    }
}