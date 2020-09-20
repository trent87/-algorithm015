public class SearchA2dMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int v = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if (v == target) {
                return true;
            } else if (v < target) {
                low = mid + 1;
            } else {
                high = mid -1 ;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();
//        int[][] matrix = new int[][]{{1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}};

        int[][] matrix = new int[][]{{1, 3}};
        System.err.println(searchA2dMatrix.searchMatrix(matrix, 3));

    }

}
