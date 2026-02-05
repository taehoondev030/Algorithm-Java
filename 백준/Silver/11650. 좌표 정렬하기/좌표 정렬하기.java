import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            arr[i][1] = Integer.parseInt(st.nextToken()); // y좌표
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                // x좌표가 같으면
                if(i1[0] == i2[0]) {
                    // y좌표 비교
                    return i1[1] - i2[1];
                }
                else {
                    return i1[0] - i2[0];
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}