public class RotateMatrix {

    int [][] rotation(int [][] mat) {
        
        if (mat.length != mat[0].length) {
            return mat;
        }

        int first, last, n = mat.length;
        for(int layer = 0; layer < n / 2; layer++) {
            first = layer;
            last = n - 1 - layer;

            for(int i = first; i < last; i++) {

                int offset = i - first;

                int temp = mat[first][i];

                mat[first][i] = mat[last - offset][first];

                mat[last - offset][first] = mat[last][last - offset];

                mat[last][last - offset] = mat[i][last];

                mat[i][last] = temp;

            }
        }

        return mat;

    }

    public static void main(String[] args) {
        int [][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        RotateMatrix obj = new RotateMatrix();
        int [][] mat = obj.rotation(matrix);
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }

    }
    
}
