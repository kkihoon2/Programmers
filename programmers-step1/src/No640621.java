import java.util.ArrayList;
import java.util.List;

class No640621 {
    public int solution(int[][] board, int[] moves) {
        int len = board.length;
        List<List<Integer>> cols = new ArrayList<>();
        // make a stack for each col
        for (int i = 0; i <= len; i++) {
            cols.add(new ArrayList<Integer>());
        }
        for (int r = len - 1; r >= 0; r--) {
            for (int c = len - 1; c >= 0; c--) {
                if (board[r][c] != 0) {
                    cols.get(c + 1).add(board[r][c]);
                }
            }
        }

        List<Integer> basket = new ArrayList<>();
        int cnt = 0;
        for (int m : moves) {
            // edge: col could be empty
            List<Integer> col = cols.get(m);
            if (!col.isEmpty()) {
                int doll = col.remove(col.size() - 1);
                if (!basket.isEmpty() && basket.get(basket.size() - 1) == doll) {
                    // remove two dolls
                    basket.remove(basket.size() - 1);
                    cnt += 2;
                } else {
                    basket.add(doll);
                }
            }
        }
        return cnt;
    }
}