import java.util.ArrayList;
import java.util.HashSet;

class MakeMatch {

    ArrayList<String []> resBoard = new ArrayList<String []>(0);
    Character [][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                           {'.', '.', '.', '.', '.', '.', '.', '.'},
                           {'.', '.', '.', '.', '.', '.', '.', '.'},
                           {'.', '.', '.', '.', '.', '.', '.', '.'},
                           {'.', '.', '.', '.', '.', '.', '.', '.'},
                           {'.', '.', '.', '.', '.', '.', '.', '.'},
                           {'.', '.', '.', '.', '.', '.', '.', '.'},
                           {'.', '.', '.', '.', '.', '.', '.', '.'}};
    HashSet<Integer> colSet = new HashSet<Integer>(0),
            negDiagonalSet = new HashSet<Integer>(0),
            posDiagonalSet = new HashSet<Integer>(0);

    void printBoard() {
        for (int i = 0; i < this.resBoard.size(); i++) {
            for (int j = 0; j < this.resBoard.get(i).length; j++) {
                System.out.print("| ");
                System.out.print(this.resBoard.get(i)[j]);
                System.out.print("|");
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        }
    }


    String [] convertToString(Character [][] ch) {
        String [] stringArray = new String[ch.length];
        for (int i = 0; i < ch.length; i++) {
            String st = "";
            for (int j = 0; j < ch[0].length; j++) {
                st += Character.toString(ch[i][j]) + " ";
            }
            stringArray[i] = st;
        }
        return stringArray;
    }


    void backTracking(int row) {
        if (row == board.length) {
            String [] st = this.convertToString(board);
            this.resBoard.add(st);
        }
        
        else {
            for (int col = 0; col < board.length; col++) {
                if (colSet.contains(col) || negDiagonalSet.contains(row - col) || posDiagonalSet.contains(row + col)) {
                    continue;
                }
                else {
                    this.board[row][col] = 'Q';
                    colSet.add(col);
                    negDiagonalSet.add(row - col);
                    posDiagonalSet.add(row + col);
                    this.backTracking(row + 1);

                    colSet.remove(col);
                    negDiagonalSet.remove(row - col);
                    posDiagonalSet.remove(row + col);
                    this.board[row][col] = '.';
                }
            }
        }
    }

    void makeMatch() {
        
        backTracking(0);
        this.printBoard();
    }
}


public class EightQueens {
    public static void main(String[] args) {
        MakeMatch obj = new MakeMatch();
        obj.makeMatch();
    }
}
