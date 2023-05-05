import java.util.ArrayList;

class Coordinate {
    Integer row, col;

    public Coordinate(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }
}

class Path {

    boolean isAtOrigin;
    ArrayList<Coordinate> pathList;

    ArrayList<Coordinate> getPath(Integer [][] grid) {
        if (grid.length == 0) return null;
        pathList = new ArrayList<Coordinate>(0);
        if (this.moving(grid, grid.length - 1, grid[0].length - 1)) {
            return pathList;
        }
        return null;
    }

    boolean moving(Integer [][] grid, int row, int col) {
        if (row < 0 || col < 0 || grid[row][col] == null) {
            return false;
        }

        isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || this.moving(grid, row, col - 1) || this.moving(grid, row - 1, col)) {
            this.pathList.add(new Coordinate(row, col));
            return true;
        }
        return false;
    } 
}

public class RobotInAGrid {

    static void printPaths(ArrayList<Coordinate> paths) {
        for(int i = 0; i < paths.size(); i++) {
            System.out.print("(" + paths.get(i).row + ", " + paths.get(i).col + "), ");
        }
    }

    public static void main(String[] args) {
        Path obj = new Path();
        // Integer [][] mat = {{0, 0, 0, null}, {0, 0, 0, 0}, {0, 0, null, 0}, {0, 0, null, 0}};
        Integer [][] mat = {{0, 0, null}, {0, 0, 0}, {null, 0, 0}};
        ArrayList<Coordinate> pathList =  obj.getPath(mat);
        printPaths(pathList);
    }
}
