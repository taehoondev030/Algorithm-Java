import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 인덱스 편의성을 위해 N+1 | R, G, B 중 1개이므로 3
        int[][] cost = new int[N+1][3]; // 각 색깔별로 집을 색칠하는 비용
        int[][] dp = new int[N+1][3]; // 각 집을 색칠하는 최소 비용

        for(int i = 1; i <= N; i++) {
            // 색깔별로 집을 색칠하는 비용 입력
            StringTokenizer st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken()); // R
            cost[i][1] = Integer.parseInt(st.nextToken()); // G
            cost[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        // 초기값 설정
        // 첫번째 집은 바로 칠하므로 비용 자체가 최소값
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        for(int i = 2; i <= N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // 마지막 집까지 칠했을때 비용이 가장 적은 색 조합을 선택
        int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
        System.out.println(result);
    }
}