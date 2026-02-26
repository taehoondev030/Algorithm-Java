import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001]; // 기준점(0)의 인덱스는 4000

        double sum = 0;
        int max = -4000;
        int min = 4000;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 4000]++;

            // 합
            sum += num;
            // 최대값
            if(num > max) {
                max = num;
            }
            // 최소값
            if(num < min) {
                min = num;
            }
        }

        int mid = 0;
        int midCount = 0;

        int many = 0;
        int manyCount = 0;
        boolean flag = false; // 1개만 나왔는지 확인

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                // 같은 수가 여러번 나올 수 있으므로
                if(midCount < (N + 1) / 2) {
                    midCount += arr[i];
                    mid = i - 4000;
                }
            }

            if(arr[i] > manyCount) {
                manyCount = arr[i];
                many = i - 4000;
                flag = true;
            }

            // 두번째로 나온 최빈값인 경우
            else if(arr[i] == manyCount && flag == true) {
                many = i - 4000;
                flag = false;
            }
        }

        // 산술평균 O
        sb.append((int)Math.round(sum / N)).append("\n");
        // 중앙값
        sb.append(mid).append("\n");
        // 최빈값
        sb.append(many).append("\n");
        // 범위 O
        sb.append(max - min);

        System.out.print(sb);
    }
}