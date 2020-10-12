import java.util.Stack;
import java.util.HashSet;
class removeInvalidParenthesis{

    public static void solution(String str, int rma, HashSet<Character> hs){
        if(rma == 0){
            if(getSize(str) == 0){
                System.out.println(str);
            }

            return;
        }

        for(int i=0; i<str.length(); i++){
            String left = str.substring(0, i);
            String right = str.substring(i+1);

            solution(left+right, rma-1, hs);
        }
    }

    public static int getSize(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.size() == 0){
                    st.push(ch);
                }else if(st.peek() == ')'){
                    st.push(ch);
                }else if(st.peek() == '('){
                    st.pop();
                }else{

                }
            }
        }
        return st.size();
    }

    public static void main(String[] args){
        String str = "()())()";
        int rma = getSize(str);
        solution(str, rma, new HashSet<>()); 
    }
}