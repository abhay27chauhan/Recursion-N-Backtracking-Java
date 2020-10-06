import java.util.ArrayList;
class goldMine2{

    public static void goldMine(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> list){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] == 0 || visited[i][j] == true){
            return;
        }

        visited[i][j] = true;
        list.add(arr[i][j]);
        goldMine(arr, i-1, j, visited, list);
        goldMine(arr, i, j+1, visited, list);
        goldMine(arr, i, j-1, visited, list);
        goldMine(arr, i+1, j, visited, list);
    }

    public static void main(String[] args){
        int[][] arr = {{10,0,100,200,0,8,0},
                        {20,0,0,0,0,6,0},
                        {30,0,0,9,12,3,4},
                        {40,0,2,5,8,3,11},
                        {0,0,0,0,0,9,0},
                        {5,6,7,0,7,4,2},
                        {8,9,10,0,1,10,8}
                    };
        
        int max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] != 0 && visited[i][j] == false){
                    ArrayList<Integer> list = new ArrayList<>();
                    goldMine(arr, i, j, visited, list);

                    int sum = 0;
                    for(int val: list){
                        sum += val;
                    }

                    if(sum>max){
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}