class BleedingIn {
    int [][] mat;

    void bleedingIn(int [][] mat, int row, int col, int newVal, int oldVal) {
        if (mat[row][col] == oldVal) {
            this.mat = mat;
            this.bleedingIn(row, col, newVal, oldVal);
        }
    }

    void bleedingIn(int row, int col, int newVal, int oldVal) {
        if (row < 0 || row > this.mat.length - 1 || col < 0 || col > this.mat[0].length - 1) {
        }
        else {
            if (this.mat[row][col] == oldVal) {
                this.mat[row][col] = newVal;
                this.bleedingIn(row + 1, col, newVal, oldVal);
                this.bleedingIn(row - 1, col, newVal, oldVal);
                this.bleedingIn(row, col + 1, newVal, oldVal);
                this.bleedingIn(row, col - 1, newVal, oldVal);
            }
        }
    }

    void printMatrix(int [][] mat) {
        for(int i = 0; i < mat.length; i++) {
            System.out.print("| ");
            for(int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("");
    }
}

public class PaintFill {
    public static void main(String[] args) {
        BleedingIn obj = new BleedingIn();
        int [][] mat = {{2, 1, 1, 1, 0, 2, 2}, {2, 0, 0, 0, 0, 0, 2}, {3, 1 ,0, 0, 1, 0, 3},
                    {3, 0, 0, 1, 1, 1, 0}, {0, 0, 1, 2, 2, 2, 3}, {3, 3, 0, 0, 1, 1, 2},
                    {1, 1, 3, 3, 3, 2, 3}};
        obj.printMatrix(mat);
        // int r = mat.length / 2, c = mat[0].length / 2;
        int r = 1, c = 1;
        obj.bleedingIn(mat, r, c, 4, mat[r][c]);
        obj.printMatrix(obj.mat);
    
    }
}
