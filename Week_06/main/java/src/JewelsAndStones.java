public class JewelsAndStones {


    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0 ; i < S.length() ; i++){
            char c = S.charAt(i);
            if(J.indexOf(c)!= -1){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.err.println(jewelsAndStones.numJewelsInStones("aA","aAAbbbb"));
    }
}
