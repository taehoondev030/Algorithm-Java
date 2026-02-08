import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int slice = (int) Math.round(n * 0.15);
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        int count = 0;

        while(true) {
            if(count < slice) {
                count++;
                continue;
            }
            if(count >= n - slice) {
                break;
            }

            sum += arr[count];
            count++;
        }

        long avg = Math.round((double) sum / (n - (2 * slice)));
        System.out.println(avg);
    }
}