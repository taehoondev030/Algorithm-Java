import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[6];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        int shirt = 0;
        int pen_set = 0;
        int pen_one = 0;

        for(int i = 0; i < 6; i++) {
            if(arr[i] % T == 0) {
                shirt += arr[i] / T;
            } else {
                shirt += arr[i] / T + 1;
            }
        }

        pen_set = N / P;
        pen_one = N % P;

        StringBuilder sb = new StringBuilder();
        sb.append(shirt).append("\n");
        sb.append(pen_set).append(" ").append(pen_one);

        System.out.println(sb);
    }
}