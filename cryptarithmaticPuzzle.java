import java.util.HashMap;
class cryptarithmaticPuzzle{

    public static int getnum(HashMap<Character, Integer> hm, String s){
        String ans = "";
        for(char c: s.toCharArray()){
            ans += hm.get(c);
        }

        return Integer.parseInt(ans);
    }

    public static void solution(HashMap<Character, Integer> hm, int idx, boolean[] used, String unique, String s1, String s2, String s3){
        if(idx == unique.length()){
            int num1 = getnum(hm, s1);
            int num2 = getnum(hm, s2);
            int num3 = getnum(hm, s3);

            if(num1 + num2 == num3){
                for(int i=0; i<26; i++){
                    char c = (char)(i + 'a');
                    if(hm.containsKey(c)){
                        int num = hm.get(c);
                        System.out.print(c + "-" + num + " ");
                    }
                }System.out.println();
            }
            return;
        }

        char ch = unique.charAt(idx);
        for(int i=0; i<=9; i++){
            if(used[i] == false){
                used[i] = true;
                hm.put(ch, i);
                solution(hm, idx+1, used, unique, s1, s2, s3);
                used[i] = false;
                hm.put(ch, -1);
            }
        }
    }

    public static void main(String[] args){
        String s1 = "send";
        String s2 = "more";
        String s3 = "money";
        String unique = "";

        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s1.toCharArray()){
            if(!hm.containsKey(c)){
                hm.put(c, -1);
                unique += c;
            }
        }

        for(char c: s2.toCharArray()){
            if(!hm.containsKey(c)){
                hm.put(c, -1);
                unique += c;
            }
        }

        for(char c: s3.toCharArray()){
            if(!hm.containsKey(c)){
                hm.put(c, -1);
                unique += c;
            }
        }

        boolean[] used = new boolean[10];
        solution(hm, 0, used, unique, s1, s2, s3);

    }
}