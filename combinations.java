// the items will be identical in this case

class combinations{

    public static void solution(int cb, int tb, int ssf, int ti, String asf){
        if(cb>tb){
            if(ssf == ti){
                System.out.println(asf);
            }

            return;
        }

        solution(cb+1, tb, ssf, ti, asf + "- ");
        solution(cb+1, tb, ssf+1, ti, asf + "i ");
    }

    public static void main(String[] args){
        int nboxes = 4;
        int ritems = 2;

        solution(1, nboxes, 0, ritems, "");
    }
}