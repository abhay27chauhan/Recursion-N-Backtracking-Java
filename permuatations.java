class permuatations{

    public static void solution(int[] boxes, int ci, int ti){
        if(ci > ti){
            for(int i=0; i<boxes.length; i++){
                System.out.print(boxes[i]);
            }System.out.println();

            return;
        }

        for(int i=0; i<boxes.length; i++){
            if(boxes[i] == 0){
                boxes[i] = ci;
                solution(boxes, ci+1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args){
        int nboxes = 4;
        int ritems = 2;

        solution(new int[nboxes], 1, ritems);
    }
}