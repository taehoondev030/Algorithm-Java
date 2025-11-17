//  부분수열의 합

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int answer = 0; // 부분수열의 개수

        // mask = 0이면 000...0으로 아무도 선택 안한 공집합 (부분수열 제외)
        // mask = 5 : 5 = 0101, 부분집합은 {arr[0], arr[2]}
        // 1 << N = 2^N (N개의 원소에 대한 부분집합은 총 2^N개)
        for(int mask = 1; mask < (1 << N); mask++) {
            int sum = 0; // 부분수열의 합

            // 예를 들어 mask = 5면 0101, 0번과 2번 원소 선택한 것
            for(int i = 0; i < N; i++) {
                // (1 << i)는 i번째 비트만 1인 숫자
                // i=0 : 0001 / i=1 : 0010
                // mask의 i번째 비트가 1인지 확인
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }

            if (sum == S) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}