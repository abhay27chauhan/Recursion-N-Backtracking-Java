import java.util.HashMap;
class permutationsOfString2{

    public static void solution(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence){
        if(cc == str.length()){
            for(int i=0; i<spots.length; i++){
                System.out.print(spots[i]);
            }System.out.println();

            return;
        }

        char c = str.charAt(cc);
        int lo = lastOccurence.get(c);

        for(int i=lo+1; i<spots.length; i++){
            if(spots[i] == null){
                spots[i] = c;
                lastOccurence.put(c, i);
                solution(cc+1, str, spots, lastOccurence);
                lastOccurence.put(c, lo);
                spots[i] = null;
            }
        }
    }

    public static void main(String[] args){
        String str = "aabb";

        Character[] spots = new Character[str.length()];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for(char c: str.toCharArray()){
            if(!lastOccurence.containsKey(c)){
                lastOccurence.put(c, -1);
            }
        }

        solution(0, str, spots, lastOccurence);
    }
}