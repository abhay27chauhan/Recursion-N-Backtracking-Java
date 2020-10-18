import java.util.HashMap;
class permutationsOfAString{

    public static void solution(int cs, int ts, HashMap<Character, Integer> fmap, String asf){
        if(cs>ts){
            System.out.println(asf);
            return;
        }

        for(char c: fmap.keySet()){
            if(fmap.get(c) > 0){
                fmap.put(c, fmap.get(c) - 1);
                solution(cs+1, ts, fmap, asf + c);
                fmap.put(c, fmap.get(c) + 1);
            }
        }
    }

    public static void main(String[] args){
        String str = "aabb";

        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char c: str.toCharArray()){
            if(fmap.containsKey(c)){
                fmap.put(c, fmap.get(c) + 1);
            }else{
                fmap.put(c, 1);
            }
        }

        solution(1, str.length(), fmap, "");
    }
}