import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static boolean[][] board;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        // 탐색 시작 가능한 최대 범위
        int start_n = N - 7;
        int start_m = M - 7;

        for(int i = 0; i < start_n; i++) {
            for(int j = 0; j < start_m; j++) {
                search(i, j);
            }
        }

        System.out.println(min);
    }

    public static void search(int x, int y) {
        int end_n = x + 8;
        int end_m = y + 8;
        int count = 0; // 바꿔야 하는 칸의 갯수

        // 시작 칸
        boolean first = board[x][y];

        for(int i = x; i < end_n; i++) {
            for(int j = y; j < end_m; j++) {
                if(board[i][j] != first) {
                    count++;
                }

                // 다음 칸 색깔 전환 (확인용)
                first = (!first);
            }

            // 다음 줄 색깔 전환 (확인용)
            first = (!first);
        }

        // 최대 64개를 칠해야 하므로 첫번째 칸의 색깔이 전환되는 경우는 64 - count
        count = Math.min(count, 64 - count);

        min = Math.min(count, min);
    }
}