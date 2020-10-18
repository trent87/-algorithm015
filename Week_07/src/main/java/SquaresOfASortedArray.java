import java.util.Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        if (A == null) {
            return new int[0];
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i]*A[i];
        }
        Arrays.sort(res);
        return res;
    }
}
