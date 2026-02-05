import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] rank = new int[N]; // 덩치 순위
        int[] weight = new int[N]; // 몸무게
        int[] height = new int[N]; // 키

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            rank[i] = 1;
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            weight[i] = w;
            height[i] = h;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i==j) {
                    continue;
                }
                // 비교 대상보다 키와 몸무게가 작으면
                if(weight[i] < weight[j] && height[i] < height[j]) {
                    rank[i]++; // 순위 증가
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i : rank) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}