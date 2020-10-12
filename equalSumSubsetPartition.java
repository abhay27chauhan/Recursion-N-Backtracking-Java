import java.util.ArrayList;
class equalSumSubsetPartition{

    public static void solution(int[] arr, int i, int n, int k, int nos, int[] subsetSum, ArrayList<ArrayList<Integer>> ans){
        if(i == n){
            if(nos == k){
                boolean flag = true;
                for(int idx =0; idx < subsetSum.length-1; idx++){
                    if(subsetSum[idx] != subsetSum[idx+1]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(ArrayList<Integer> set: ans){
                        System.out.print(set);
                    }System.out.println();
                }
            }

            return;
        }

        for(int j=0; j<ans.size(); j++){
            if(ans.get(j).size()>0){
                ans.get(j).add(arr[i]);
                subsetSum[j] += arr[i];
                solution(arr, i+1, n, k, nos, subsetSum, ans);
                ans.get(j).remove(ans.get(j).size()-1);
                subsetSum[j] -= arr[i];
            }else{
                ans.get(j).add(arr[i]);
                subsetSum[j] += arr[i];
                solution(arr, i+1, n, k, nos+1, subsetSum, ans);
                ans.get(j).remove(ans.get(j).size()-1);
                subsetSum[j] -= arr[i];
                break;
            }
        }
    }

    public static void main(String[] args){
        int n = 8;
        int sum = 0;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
            sum += arr[i];
        }

        int k = 4;
        if(k==1){
            System.out.print("[");
            for(int i=0; i<n-1; i++){
                System.out.print(arr[i] + ", ");
            }
            System.out.println(arr[n-1] + "]");
            return;
        }

        if(k>n || sum%k != 0){
            System.out.println(-1);
            return;
        }

        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<k; i++){
            ans.add(new ArrayList<>());
        }

        solution(arr, 0, n, k, 0, subsetSum, ans);
    }
}