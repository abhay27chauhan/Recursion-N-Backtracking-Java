import java.util.HashMap;
import java.util.HashSet;
class wordPatternMatching{

    public static void solution(String str, String pattern, HashMap<Character, String> hm, String op){
        if(pattern.length() == 0){
            if(str.length() == 0){
                HashSet<Character> isUsed = new HashSet<>();
                for(int i=0; i<op.length(); i++){
                    char c = op.charAt(i);
                    if(!isUsed.contains(c)){
                        System.out.println(c + " -> " + hm.get(c));
                        isUsed.add(c);
                    }
                }
            }
            return;
        }

        char c = pattern.charAt(0);
        String rop = pattern.substring(1);

        if(hm.containsKey(c)){
            String getStr = hm.get(c);
            if(str.length() >= getStr.length()){
                String left = str.substring(0, getStr.length());
                String right = str.substring(getStr.length());
                if(left.equals(getStr)){
                    solution(right, rop, hm ,op);
                } 
            }
        }else{
            for(int i=0; i<str.length(); i++){
                String left = str.substring(0, i+1);
                String right = str.substring(i+1);
                hm.put(c, left);
                solution(right, rop, hm, op);
                hm.remove(c);
            }
        }
        
    }

    public static void main(String[] args){
        String str = "graphtreegraph";
        String pattern = "pep";
        HashMap<Character, String> hm = new HashMap<>();
        solution(str, pattern, hm, pattern);
    }
}