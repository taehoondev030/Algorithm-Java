import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n + 1000000]++;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.print(sb);
    }
}