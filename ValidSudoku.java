import java.util.HashSet;
import java.util.Set;

// TC: O(1). Sudoku is a 9x9 matrix. all the time 81 elements will be visited. which is constant. 
// SC: O(1). HashSet is used but the elements will be added to the hashSet is 81 * 3= 243. which is constant.
public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new String[][] { { "5", "3", ".", ".", "7", ".", ".", ".", "." },
                { "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".", ".", ".", ".", "6", "." },
                { "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
                { "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." },
                { ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".", ".", "7", "9" } }));

        System.out.println(isValidSudoku(new String[][] { { "8", "3", ".", ".", "7", ".", ".", ".", "." },
                { "6", ".", ".", "1", "9", "5", ".", ".", "." }, { ".", "9", "8", ".", ".", ".", ".", "6", "." },
                { "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
                { "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." },
                { ".", ".", ".", "4", "1", "9", ".", ".", "5" }, { ".", ".", ".", ".", "8", ".", ".", "7", "9" } }));
    }

    // Checking for row, col and sub Matrix(size/3)
    public static boolean isValidSudoku(String[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String curr = board[i][j];
                if (board[i][j] != "." && (!set.add(curr + "row" + i) || !set.add(curr + "col" + j)
                        || !set.add(curr + "sub" + i / 3 + "-" + j / 3)))
                    return false;
            }
        }
        return true;
    }
}
