import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N + M];
        int count = 0;

        for(int i = 0; i < N + M; i++) {
            String str = br.readLine();
            arr[i] = str;
        }

        Arrays.sort(arr);
        
        for(int i = 1; i < arr.length; i++) {
            if (arr[i].equals(arr[i - 1])) {
                count++;
                sb.append(arr[i]);
                sb.append("\n");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}