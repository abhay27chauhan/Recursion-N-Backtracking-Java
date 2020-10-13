//tug of war
import java.util.ArrayList;
class minimumSubsetSumDifference{
    
    static int minDiff = Integer.MAX_VALUE;
    static String ans = "";

    public static void solution(int[] arr, int idx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1, int soset2){
        if(idx == arr.length){
            int delta = Math.abs(soset1 - soset2);
            if(delta< minDiff){
                minDiff = delta;
                ans = set1 + " " +set2; 
            }

            return;
        }

        if(set1.size() < (arr.length + 1)/2){
            set1.add(arr[idx]);
            solution(arr, idx+1, set1, set2, soset1 + arr[idx], soset2);
            set1.remove(set1.size()-1);
        }

        if(set2.size() < (arr.length + 1)/2){
            set2.add(arr[idx]);
            solution(arr, idx+1, set1, set2, soset1, soset2 + arr[idx]);
            set2.remove(set2.size()-1);
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        solution(arr, 0, set1, set2, 0, 0);
        System.out.println(ans);
    }
}