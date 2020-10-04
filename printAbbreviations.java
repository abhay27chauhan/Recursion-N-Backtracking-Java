class printAbbreviations{

    public static void printAbb(String str, String asf, int count, int pos){
        if(pos == str.length()){
            if(count == 0){
                System.out.println(asf);
            }else{
                System.out.println(asf + count);
            }
            return;
        }

        if(count == 0){
            printAbb(str, asf + str.charAt(pos), 0, pos+1);
        }else{
            printAbb(str, asf + count + str.charAt(pos), 0, pos+1);
        }
        printAbb(str, asf, count+1, pos+1);
    }

    public static void main(String[] args){
        String str = "pep";
        printAbb(str, "", 0, 0);
    }
}