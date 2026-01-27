import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        // 탐색 가능한 시작점의 끝 범위
        int x_start = N - 7;
        int y_start = M - 7;

        for (int i = 0; i < x_start; i++) {
            for (int j = 0; j < y_start; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y) {
        // 탐색할 마지막 점
        int x_end = x + 8;
        int y_end = y + 8;
        int count = 0;

        // 맨 처음 칸의 색깔
        boolean TF = arr[x][y];

        for(int i = x; i < x_end; i++) {
            for(int j = y; j < y_end; j++) {
                if(arr[i][j] != TF) {
                    count++;
                }

                // 바로 다음 칸 색깔 바꾸기
                TF = (!TF);
            }

            // 다음 줄 처음 칸 색깔 바꾸기
            TF = (!TF);
        }

        // 전체 칸의 개수는 64개 이므로, 색깔이 바뀔 경우 색칠 횟수는 64에서 원래 횟수 빼기
        count = Math.min(count, 64 - count);

        min = Math.min(count, min);
    }
}