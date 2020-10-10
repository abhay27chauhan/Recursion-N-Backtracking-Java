import java.util.ArrayList;
class partitionInKSubsets{
    static int counter = 0;
    public static void solution(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> lists){
        if(i > n){
            if(nos == k){
                counter++;
                System.out.print(counter + ". ");
                for(ArrayList<Integer> set: lists){
                    System.out.print(set);
                }System.out.println();
            }

            return;
        }

        for(int j=0; j<lists.size(); j++){
            if(!lists.get(j).isEmpty()){
                lists.get(j).add(i);
                solution(i+1, n, k, nos, lists);
                lists.get(j).remove(lists.get(j).size()-1);
            }else{
                lists.get(j).add(i);
                solution(i+1, n, k, nos+1, lists);
                lists.get(j).remove(lists.get(j).size()-1);
                break;
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int n = 4;
        int k = 3;
        for(int i=0; i<k; i++){
            lists.add(new ArrayList<>());
        }

        solution(1, n, k, 0, lists);
    }
}