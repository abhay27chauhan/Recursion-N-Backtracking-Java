// ncr = npr / r!
class combinations2{

    public static void solution(int ci, int ti, boolean[] boxes, int lp){
        if(ci > ti){
            for(int i=0; i<boxes.length; i++){
                if(boxes[i]){
                    System.out.print("i ");
                }else{
                    System.out.print("- ");
                }
            }System.out.println();
            return;
            
        }

        for(int i = lp+1; i<boxes.length; i++){
            if(boxes[i] == false){
                boxes[i] = true;
                solution(ci+1, ti, boxes, i);
                boxes[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int nboxes = 4;
        int ritems = 2; // similar items

        solution(1, ritems, new boolean[nboxes], -1);
    }
}