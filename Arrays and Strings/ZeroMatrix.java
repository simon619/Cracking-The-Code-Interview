public class ZeroMatrix {

    int [][] mat;

    public ZeroMatrix(int[][] mat) {
        this.mat = mat;
    }

    int [][] nullify() {
        boolean [] row = new boolean[mat[0].length];
        boolean [] col = new boolean[mat.length];

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < row.length; i++) {
            if(row[i]) {
                rowNulify(row, i);
            }
        }

        for(int i = 0; i < col.length; i++) {
            if(col[i]) {
                columnNulify(col, i);
            }
        }

        return this.mat;

    }

    void rowNulify(boolean [] row, int x) {
        for(int i = 0; i < row.length; i++) {
            this.mat[x][i] = 0; 
        }
    }

    void columnNulify(boolean[] col, int x) {
        for(int i = 0; i < col.length; i++) {
            this.mat[i][x] = 0; 
        }
    }
    

    public static void main(String[] args) {
        int [][] mat = {{0, 1, 2}, {4, 0, 5}, {6, 7, 8}};
        ZeroMatrix obj = new ZeroMatrix(mat);
        int [][] res = obj.nullify();
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
