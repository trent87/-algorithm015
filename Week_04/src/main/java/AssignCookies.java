import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        if(g != null || s != null){
            Arrays.sort(g);
            Arrays.sort(s);
        }
        else{
            return 0;
        }
        int gi = 0 , si =0;
        while(gi < g.length && si < s.length){
            if(g[gi] <= s[si]){
                gi ++;
            }
            si ++;
        }
        return gi;
    }

    public static void main(String[] args){
        AssignCookies assignCookies = new AssignCookies();
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.err.println(assignCookies.findContentChildren(g,s));
    }

}
