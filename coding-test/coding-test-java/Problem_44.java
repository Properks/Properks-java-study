import java.util.*;

// 스도쿠 퍼즐 (저자 문제)
public class Problem_44 {

    public static void main(String[] args) {
        int[][] board1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(Arrays.deepToString(solution(board1)));

        int[][] board2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println(Arrays.deepToString(solution(board2)));

    }

    public static class Block {
        int x;
        int y;
        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] solution(int[][] board) {
        dfs(board);
        return board;
    }

    public static boolean dfs(int[][] board) {
        Block empty = findEmpty(board);
        if (empty == null) {
            return true;
        }

        // return true, false는 현재 방식? 경로? 가 올바른지를 판단해주는 반환값, 즉, false가 나오면 transaction 처럼 롤백 후 다른 값을 넣으면서 다시 실행
        // 결국 모든 경우의 수를 하면서 중간에 막히면 바로 돌아가는 방식
        for (int possibleNumber : findPossibleNumber(board, empty.x, empty.y)) {
            board[empty.x][empty.y] = possibleNumber;
            if (dfs(board)) {
                return true;
            }
            board[empty.x][empty.y] = 0;
        }
        return false;
    }

    public static Block findEmpty(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    return new Block(i, j);
                }
            }
        }
        return null;
    }

    public static List<Integer> findPossibleNumber(int[][] board, int x, int y) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != 0) {
                list.remove(Integer.valueOf(board[x][i]));
            }
            if (board[i][y] != 0) {
                list.remove(Integer.valueOf(board[i][y]));
            }
        }
        return list;
    }


}
