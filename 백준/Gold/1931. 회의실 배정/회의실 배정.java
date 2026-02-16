import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            meeting[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // 종료 시간이 빠른 순서대로 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                // 종료 시간이 같으면 시작 시간을 기준으로 정렬
                if(s1[1] == s2[1]) {
                    return s1[0] - s2[0];
                }
                return s1[1] - s2[1];
            }
        });

        int count = 1; // 회의실 개수
        int window = 0;

        int end = meeting[0][1];
        for(int i = 1; i < N; i++) {
            int nextStart = meeting[i][0];
            // 다음 회의 시작시간이 현재 회의 종료시간 보다 늦거나 같다면
            if(nextStart >= end) {
                count++;
                end = meeting[i][1];
            } else {
                continue;
            }
        }

        System.out.println(count);
    }
}