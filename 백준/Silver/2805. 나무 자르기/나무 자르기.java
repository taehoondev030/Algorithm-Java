import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 나무의 높이를 저장하는 배열
        int[] tree = new int[N];

        int max = 0; // 상한선
        int min = 0; // 하한선
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(tree[i] > max) {
                max = tree[i];
            }
        }

        // 이분 탐색
        while(min < max) {
            int mid = (max + min) / 2;
            long sum = 0; // 자른 나무 높이의 합

            for(int treeCut : tree) {
                // 자르는 높이보다 더 큰 나무의 길이만 더한다.
                if(treeCut - mid > 0) {
                    sum += treeCut - mid;
                }
            }

            // 자른 나무 길이의 합이 M보다 큰 경우 (더 많이 자른 경우)
            // 자르는 위치가 낮다는 뜻이므로 높이를 올려야 한다.
            // = 하한선을 올려야 한다.
            if(sum >= M) {
                // mid(자르는 위치)보다 높아야 한다는 것을 확인했기 때문에 +1
                min = mid + 1;
            }
            // 자른 나무 길이의 합이 M보다 작은 경우 (더 적게 자른 경우)
            // 자르는 위치가 높다는 뜻이므로 높이를 낮춰야 한다.
            // = 상한선을 내려야 한다.
            else {
                max = mid;
            }
        }

        System.out.println(min-1);
    }
}