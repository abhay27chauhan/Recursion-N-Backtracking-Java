// using combination 
// npr = ncr * r!
class permutations2{

    public static void solutions(int cb, int tb, boolean[] items, int ssf, int ti, String asf){
        if(cb > tb){
            if(ssf == ti){
                System.out.println(asf);
            }

            return;
        }

        for(int i =0; i<items.length; i++){
            if(items[i] == false){
                items[i] = true;
                solutions(cb+1, tb, items, ssf+1, ti, asf + (i+1));
                items[i] = false;
            }
        }

        solutions(cb+1, tb, items, ssf, ti, asf + 0);
    }

    public static void main(String[] args){
        int nboxes = 4;
        int ritems = 2;

        solutions(1, nboxes, new boolean[ritems], 0, ritems, "");
    }

}