import java.util.HashSet;
class wordBreak{

    public static void soultion(String sent, HashSet<String> words, String asf){
        if(sent.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<sent.length(); i++){
            String left = sent.substring(0, i+1);
            String right = sent.substring(i+1);
            if(words.contains(left)){
                soultion(right, words, asf + left + " ");
            }
        }
    }

    public static void main(String[] args){
        HashSet<String> words = new HashSet<>();
        words.add("micro");
        words.add("soft");
        words.add("hi");
        words.add("ring");
        words.add("hiring");
        words.add("microsoft");

        String sentence = "microsofthiring";
        soultion(sentence, words, "");
    }
}