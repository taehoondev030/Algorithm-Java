import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];

        int N = Integer.parseInt(br.readLine());
        while(true) {
            // 만약 숫자가 6이나 9인 경우
            if((N % 10 == 6) || (N % 10 == 9)) {
                // 6이 9보다 더 많거나 같게 나온 경우 9로 치환
                if(arr[6] >= arr[9]) {
                    arr[9]++;
                }
                // 9가 6보다 더 많이 나온 경우 6으로 치환
                else {
                    arr[6]++;
                }
            }
            // 6과 9 외의 숫자인 경우 그대로 카운팅
            else {
                arr[N % 10]++;
            }

            if(N / 10 == 0) {
                break;
            }

            N /= 10;
        }

        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}